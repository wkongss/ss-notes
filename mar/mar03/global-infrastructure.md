
AWS have built a global server infrastructure that's able to handle cloud operations all around the world. This allows for 
 - Proximity to end users,
 - Regional regulation compliance
 - Regional service availability
 - Pricing variance
 - Regional Redundancy
 
 Collectively, this is known as the AWS Backbone:

## The AWS Backbone

AWS' network is separated into tiers:

**Regions** are the largest atomic structure, containing multiple data centers. They are generally located near population hotspots and serve an entire geographic region.
 - Regions are generally considered isolated in that most services do not work for instances across regions.

**Availability Zones** (AZ) are a discrete data center or set of data centers within a region that operate in an isolated fashion from other centers in a region. Each region has at least three of these AZs.
 - While AZs are isolated from one another for the sake of fault tolerance and redundancy, certain services such as auto-scaling groups and load balancers work across instances spanning multiple AZs within the same region, allowing you to take advantage of the redundancy. 

**Edge Locations** smaller data centers that are designed to be close in proximity to users for caching (i.e. CDNs) and allow users not located near an AZ to network to the closest one automatically.

### Global Content Delivery

When delivering services to users across the globe, we have two main ways of ensuring lower latency for a better user experience:
 - Set up multiple clones of the same service across multiple regions
    - Generally more expensive, but offers regional redundancy.
 - Use a content delivery network with fewer instances of your application.
    - Generally cheaper while still taking advantage of caching for frequently-accessed resources.

The premier service of content delivery is **AWS Cloudfront**:
 - Caches resources at edge locations
 - Initial delivery takes longer, but cache hits are fast.

### Outposts

**AWS Outposts** are a service that installs AWS servers directly on-location, allowing you to have physical hardware on-site while still having access to built-in services.
 - Very costly
 - Extremely low latency
 - Better security/privacy assurance

### AWS Access

Three main ways to access:
 - Via the console
 - Via a local command-line interface
 - Via an executable program using the SDK via the AWS API.

Console access is manual while CLI and SDK access are considered programatic.
 - Authentication for the console includes logging in from the web with a username and password.
 - For programatic access, authentication usually includes an access key and a secret.