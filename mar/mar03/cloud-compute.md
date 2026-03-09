
AWS allows you to run computing tasks directly within the cloud. This can be done with multiple services including EC2 or AWS Lambda:

## EC2

 **EC2 (Elastic Compute Cloud)** is a service offering a virtual machine (virtualized OS that you can manipulate) with a certain amount of virtual CPU cores, RAM, storage space, and bandwidth (inbound + outbound traffic). Unless specifically dedicated, are isolated units that may share the same hardware as other customers' instances.
 - Generally deployed on the order of minutes
 - From here, you can then access the VM using the AWS Console or through an SSH connection
 - Considered infrastructure as a service (IaaS)

#### Instance Types

EC2 instances come in many different types:
1. **General Purpose** - A general balance of compute, memory, and networking resources. Great if you need your VM to handle a wide variety of tasks.
2. **Compute-Optimized** - Focus on higher performance processors for computationally-intensive tasks (i.e. handling large batch workloads).
3. **Memory-Optimized** - Focus on high memory (RAM + Cache) bandwidth for memory-intensive tasks such as highly-cached (high performance) database manipulation.
4. **Accelerated Computing** - Focus a on a particular type/specialization of computational task. For example, graphics-heavy workloads may require dedicated GPUs to accelerate the process.
5. **Storage-Optimized** - Focus on high read/write transactional bandwidth for distributed file systems and warehousing.

#### Pricing Models

EC2 instances are charged by time allocated, but are also configurable in its options and how you pay:

1. **On-Demand** - You pay by the hour and aren't locked-in to the instance - can spin up and tear down as you need to. Relatively expensive compared to other options but offers a lot of flexibility for short-term or dynamic workloads.
2. **Spot Pricing** - Similar to on-demand, but your instance can be interrupted and its processing power diverted during peak traffic hours - saves up to 90%, but cannot be used for critical infrastructure due to its unreliability.
3. **Reserved Instances** - Cheaper than on-demand instances, but locked into either a 1 or 3 year reservation paid up-front fully or partially (cheaper) or simply monthly.
4. **Compute Savings Plan** - Purchase a certain amount of compute power over a contract period (1 or 3 years), and can swap between instance types as you need. Still cheaper than on-demand.
5. **Dedicated Instance** - Flexible spin up and teardown, but guarantees that your instance is on a machine dedicated the given customer. This can ensure additional guarantees about security past the isolation of VMs + removes the risk of machine downtime due to other customers' instances. 
6. **Dedicated Host** - Same as a dedicated instance, but you rent out the entire server instead of just the instance. Offers more granular control such as getting hardware IDs and customizing the base operating system. The most expensive of EC2 options.

### Autoscaling and Load Balancing

One of the benefits of cloud computing is that we only pay for what we use, but sometimes, we need additional compute power to handle increased traffic, for instance. It'd be wasteful to partition enough instances to handle peak traffic at all times, so we can scale the number instances dynamically:

1. **Manual Scaling** - We go into the console and do this all ourselves; however, this makes our engineers very sad.
2. **Predictive Scaling** - Automatically scale the number of instances based on the minimum
3. **Dynamic Scaling** - Scale the number of instances based on hitting certain thresholds (i.e. one instance reaches 90% capacity). Includes a minimum, desired, and maximum number of instances allowed. 

When using multiple instances, it's common practice to distribute work via a load balancer. Otherwise, instances may have an uneven and inefficient workload (one instance has much more tasks than the other, wasting compute).

AWS' **Elastic Load Balancer** (ELB) allows for the routing of traffic across instances in an even manner via a single point of contact:

```
Normal traffic -> Two instances
-----------------------------------------
                          /->  Instance 1
Request -> Load Balancer <
                          \->  Instance 2

High traffic -> New Instance added
-----------------------------------------
                         /->  Instance 1
Request -> Load Balancer -->  Instance 2
                         \->  Instance 3
```

What the Elastic Load Balancer allows for is balancing across a dynamic target group in conjunction with autoscaling.

In other words, if you define a **target group** of instances and the load balancer will handle routing traffic as the target group grows and shrinks. 

### Architecture and Messaging Services

For **monolithic architecture**, you have a single application on the same instance. This includes all functionality.
 - Each instance is complex and more difficult to reason through.
 - All or nothing - if the instance is impaired, the entire application goes down.
 - Communication between components of the application is usually simpler.

For **microservice architecture**, you instead spread application functionality into components running on separate instances.
 - Each instance is a dedicated and simpler to reason through.
 - If one service is impaired, the rest generally are able to stay intact.
 - Have to handle more complex communication and data transfer between services

To facilitate microservices, we need a way for our services to communicate with each other. This is where messaging services come in:

 - **Amazon Simple Notification Service** (SNS) - Operates on a publisher/subscriber model. Certain processes will subscribe to another process. Once the publisher process pushes a notification, all subscribed processes instantly notified and receive the notification.
	 -  Certain consumers may only opt-in for a subset of notifications.
 - **Amazon Simple Queue Service** (SQS) - Operates on a producer/consumer model. Certain processes will produce tasks into a shared queue. Then, consumer processes will occasionally poll the queue when idle and claim the first task available. 
	 - Offers a 1:1 relationship between a task and a consumer. 
	 - Allows producers to queue work to be done even if consumers are currently busy.

## AWS Lambda

If you simply need cloud computing capabilities, but don't need a continuous instance, (i.e. provisioning an EC2), then AWS offers **serverless** services where it'll handle allocating compute power for you.

**AWS Lambda** is a code-on-demand service that allows execution of code based on an event (i.e. new entry in storage bucket).
 - Billing is based off of time actually computing rather than an instance existing. For this reason, this is good for sporadic or event-driven workflows.

## Container Services

In terms of hardware, when you spin up a virtual machine, the host machine needs to create a virtualized OS on top of the pre-existing native OS.

Tools like **Docker** allow for a more lightweight solution in the form of **containers**, where you set up your environment on a leaner virtualization layer rather than an entire virtualized operating system.
 - Allows for a less resource-intensive approach.

**Elastic Container Service** (ECS) is a service that allows for the management of such containers. This is done via API calls to manage and deploy Docker-based apps.

**Elastic Kubernetes Service** (EKS) performs the same function but uses Kubernetes for container orchestration instead.
 - Good if you're migrating from existing Kubernetes architecture.
 - Generally more complex than ECS.

**AWS Fargate** performs container orchestration in a serverless manner. While ECS and EKS usually run on an EC2, this will automatically provision resources for containerization.
 - Generally more expensive than ECS/EKS.