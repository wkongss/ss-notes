## Kubernetes

For multi-container applications, such as with microservice architectures, we need some way to manage the complexity of these containers as our application grows.

**Kubernetes** or (K8s) is an open source DevOps tool that does this through container orchestration. This allows for:
 - High availability through replication and automatic container restarts
 - Scalability through dynamic container allocation
 - Resilience through regular backups and rollback potential 

### Clusters

The core model of K8s is that of a **cluster**, which is a unit of managed containers divided into two planes:

1. The **control plane** manages the interaction for the cluster, as well as the general stability and health of the group.
2. The **data plane** consists of all of the actual containers within compartments called nodes.

#### The Control Plane

The control plane can further be subdivided into four required parts:

1. **kube-apiserver** - handles all interaction with the cluster through its exposed Kubernetes API.
2. **etcd** - provides cluster-specific key-value pair storage, including the current state of the cluster. Can also be used as backup storage.
3. **kube-scheduler** - whenever a new pod comes online within the cluster, this will choose the correct node to assign it to based on resources, policies, locality, and deadlines.
4. **kube-controller-manager** - handles the actual cluster health and management via controller processes including node controllers, job controllers, endpointslice controllers, and serviceaccount controllers.

The controller plane is built to scale horizontally, meaning we replicate the same plane multiple times within a cluster to handle faults or increased loads.

#### The Data Plane

The data plane consists of **nodes**, which operate on their own physical or virtual machine. Each node consists of:

1. A **kubelet** - ensures the health of the pods running within the node based off of the PodSpecs defined, as well as relay the health back to the control plane.
2. A **kube-proxy** - handles the communication between the nodes by maintaining network rules, forwarding traffic, and filtering packets.
3. A **container runtime** - a runtime such as **Docker** handles Kubernetes' ability to actually run your containers.
4. **Pods** containing one or more containers, serving as the atomic executable within Kubernetes. Within Kubernetes, each pod is assigned its own IP address for communication.

#### Supporting Objects

Kubernetes offers many objects that you can deploy within your clusters:

1. **Pods** - The most atomic object that houses one or more containers. Generally advised to not create them as one offs and instead use the more declarative managed deployments.
2. **Deployments** - the de facto way of creating stateless pods. They allow for the automatic allocation of pods to nodes via replica sets and provide options for 
3. **StatefulSets** - for creating stateful pods such as databases where replications need to be synchronized.
4. **Services** - Persistent processes associated with a type of pod that handle exposing pods to your Kubernetes network (handles dynamic IP addresses of pods as they terminate and are recreated) as well as some load balancing. Includes:
	- ClusterIP
	- LoadBalancer
	- NodePort
	- ExternalName
5. **Secret** - Handles confidential information such as DB credentials. Encoded in Base64.
6. **ConfigMap** - Handles configuration information such as DB URLs. Encoded in plaintext.
7. **Ingress** - Exposes your cluster to external networks and handles incoming traffic, making sure they get routed to the correct spot.

Other implicit configurations you can define are:
 - **Horizontal Pod Autoscaler** (HPA) - Automatically scales deployments based off of predefined policies.
 - **Network Policies** - Controls traffic flow within the cluster
 - **Limits** - The minimum (request) and maximum (limit) resources a given container has access to.
 - **Quotas** - The minimum and maximum resources able to be allocated across the entire cluster. 

### Defining and Deploying Kubernetes Objects

Kubernetes objects are defined within the YAML language and include two main components:
- **Metadata** such as `apiVersion` for the version of the Kubernetes API used, `kind` for type of object to deploy, and any `name` or `labels` for the object. 
	- You may also select a **namespace**, which essentially partitions a cluster into more isolated subclusters.
- **Specifications** that define the actual object itself. This varies based on the `kind` of object you wish to define including `ports` or things like pod resource allocation.

Then, to deploy your object, spin up a mini K8s cluster with

```
minikube start
```

This is a single-node cluster that makes testing Kubernetes locally much easier as you don't need to be in control of an entire fleet of nodes in order to test an application.

Then, apply the object with `kubectl`:

```
kubectl apply -f path.yml
```

#### Example Definition

```yaml
# Version of the API
apiVersion: apps/v1

# We're making a deployment
kind: Deployment

# Lets us filter objects later on
metadata:
  name: nginx-deployment
  labels:
    app: nginx

# What our deployment actually does
spec:
  # Replica set of size 3
  replicas: 3
  
  # All pods in our deployment have label of "app.nginx"
  # Used for differentiation and querying our containers
  selector:
    matchLabels:
      app: nginx
  
  strategy:
    # If a change is detected, create and replace pods to ensure availability
    type: RollingUpdate
    # When updating, we create an additional replica with new info and take one
    # existing one down to roll out an update
    rollingUpdate:
      maxUnavailable: 1
      maxSurge: 1

  # Give all pods in this set a label of "app.nginx"
  template:
    metadata:
      labels:
        app: nginx
    
    # Our pod specs
    spec:
      containers:
      - name: nginx
        image: nginx:1.14.2
        resources:
        # Each container has a minimum allocation of:
        # 128 Mi of memory, 0.5 vCPUs
          requests:
            memory: "128Mi"
            cpu: "500m"
        # Maximum allocation:
          limits:
            memory: "256Mi"
            cpu: "1000m"
        ports:
        - containerPort: 80
```

RollingUpdates also allow for rollbacks using the following command:

```
kubectl rollout undo <deployment>
```

Reference: https://kubernetes.io/docs/concepts/workloads/controllers/deployment/