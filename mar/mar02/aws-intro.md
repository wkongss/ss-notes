## AWS

Amazon Web Services is the leading cloud computing platform (leading Microsoft Azure, Google Cloud Platform) that facilitates distributed software/IT operations delivery through the internet rather than on on-site or centralized servers.

In a long, long time ago in a galaxy far far away, Amazon had to engineer a solution to its variable demand and ended up building its services to handle peak demand. It then began to offer services on unused compute and storage, thus spawning AWS.

### Cloud Compute Deployment

**Fully cloud-based** - Everything is migrated into cloud services from the design and deployment phases.

**On premisis** - Environment and resource management is hosted in compute units on-location.
 - Particularly used if upfront costs aren't a prohibiter or if you have certain contextual needs such as sensitive information that shouldn't be uploaded to a third-party service or simply have incompatable technologies.

**Hybrid deployment** - Use the cloud for certain aspects of infrastructure while maintaining other aspects on premisis.
 - Can also be simply that certain parts of the pipeline haven't been migrated or are unable to migrate.

When the AWS portions of your service, everything is done through the AWS Management console. Here, you can create, manage, and deploy various services.

### Cloud Compute Benefits

AWS lists 6 primary benefits of working with cloud-based architecture:

1. **Variable Expenses** - With traditional architecture, you have to pay for all of the hardware, maintenance, and additional overhead yourself, creating a large upfront cost. With cloud computing, you only pay for the compute power you use.
 - This means that you can scale and shrink your services depending on current load, etc.
 - Transitions from capital expenditure to operating expenditure
 - Transfers risk of hardware acquisition from you to the cloud provider

2. **Cost Optimization** - Gets rid of a lot of the overhead of traditional server architecture such as maintenance, location, location, and can instead allocate them into improving the product.

3. **Capacity** - Dynamic resource allocation allows you to not have to anticipate expected traffic. Instead, pay for what you use in bandwidth, storage, compute power by scaling out and in.

4. **Economies of Scale** - For a centralized service, AWS is able to take advantage of negotiation and buy hardware at a cheaper price. Everyone pays the same price for the service, allowing services to be offered at a relatively cheap price relative to doing so without scale.
 - This also applies to a cloud service provider's customers as large spenders may cover the prices of smaller users.

5. **Agility** - It's much easier, cheaper, and faster to migrate services from a virtualized cloud than on physical hardware.

6. **Global Infrastructure** - A large provider is able to build units throughout the world, allowing for faster content and service delivery to international and overseas consumers without needing to invest in international locations yourself.

### Cloud Compute Service Categories

There are 6 different broad categories of services AWS offers:

1. **Compute** - Deals with running programs on hardware in the cloud. Example: Elastic Compute Cloud (EC2)
2. **Networking and Content Distribution** - Deals with networking within the cloud as well as delivering content to end-users Example: Cloudfront (CDN) or Virtual Private Cloud (VPC)
3. **Storage** - Deals with storing and warehousing data. Example: Simple Storage Service (S3)
4. **Database** - Deails with querying, creating, updating, and deleting data. Example: Relational Database Service (RDS)
5. **Security, Identity, Compliance** - Deals with authentication, permissions, user groups. Example: Identity and Access Management (IAM)
6. **Management** - Handles accounts and offers collective management of organization structure for billing and rulesets. Example: AWS Orgs