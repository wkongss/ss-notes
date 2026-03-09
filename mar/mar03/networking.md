## Amazon VPC

A **Private Cloud** is a network associated with private and public functions of a service.

Hosting one in the cloud, then, makes it a **Virtual Private Cloud**, which AWS offers a service for: **Amazon VPC**.

### Addressing

Within a network, each machine has its own **Internet Protocol** (IP) address that uniquely identifies the device.

This IP address can be either:

- **IPv4** with form A.B.C.D where each portion is a number 0-255, offering 32 bits in total.
- **IPv6** with form A:B:C:D:E:F:G:H where each portion is a hexadecimal number `0000`- `ffff`, offering 128 bits in total.

By default, AWS uses IPv4.
Certain ranges of IP addresses correspond to being associated with a private network:

- 10.0.0.0 (what AWS usually uses)
- 192.168.0.0
- 172.16-32.0.0

We can further subdivide some ranges with a **CIDR Block** via a **subset mask** in order to specify which bits identify the network and which ones identify the host device.

```
network  host
|-----| |-----|
255.255.255.255/16 <- mask stating the first n bits identify the network
```

Generally, use a subnet mask of about 16 for maximum flexibility between networks and devices.

### Private Cloud Architecture

A VPC is made of isolated public and private **subnetworks** (subnets) that have their own resource allocations and interface with each other and the internet in different manners. Each subnet can have its own policies including that of a **Route Table**, which directs the next step to take in order to find a specific IP address.

To handle traffic from the Internet, our VPC will contain an **Internet Gateway** that serves as the entry and exit layer between the Internet and our VPC. If a subnet is public, it will have non-private IP addresses point to the designated Internet gateway.

To handle connections to private subnets, we have two options:

1.  **VPN Gateway** - This established a virtual private network connection between the VPC and a remote machine that lets you access cloud resources via an Internet connection as if you were part of a shared network.
2.  **AWS Direct Connect** - An expensive option where the company lays and maintains physical cable to the closest AWS direct connect endpoint for a direct connection. Faster with provisioned bandwidth and more reliable (not as reliant on current Internet connection), but can be cost-prohibitive.

### Network Security

Amazon VPCs have two main firewalls to protect your subnets and instances. They filter inbound and outbound packets based on a set policy.

| **Network Access Control List (Network ACL)**                                      | **Security Groups**                                              |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------- |
| Subnet-level                                                                       | Instance-level                                                   |
| Stateless                                                                          | Stateful                                                         |
| Default: allows all in/outbound traffic <br>Custom: denies all in/outbound traffic | Default: denies all inbound traffic, denies all outbound traffic |
Things to filter by include port, protocol, and origin of the traffic.
### DNS Resolution

When interacting with the Internet, we usually don't use the actual IP address in our search bar. Instead, we type in something like `amazon.com` and it magically points us to the correct IP address.

This is done through a **Domain Name Service** (DNS) that transforms our readable URL to the correct IP address behind the scenes.

AWS offers such a service called **Route 53**. Although other services allow for domain registration and control, Route 53 offers certain nice-to-have integrations:
 - Primitive DNS load-balancing - specify IPs and have it rotate between them in a round-robin fashion
 - Latency routing - point users to the service that would provide the best latency 
 - Geolocation routing - point users to the regional service based on their location