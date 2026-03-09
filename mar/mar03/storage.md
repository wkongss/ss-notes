## Storage

Within AWS, there are three main storage types:

### Block Storage

Block storage stores data similar to that of a hard drive or SSD: partitions the medium into equally-sized blocks and stores files in a range of blocks.

Comes in two forms:
1. **Elastic Block Store** (EBS) - Comes with and is associated with every EC2 instance, but lives in a different location. 
	- Persists even as the instance stops.
	- Permanently removed if the instance is terminated, but can be configured.
	- Can be backed up via EBS diff snapshots.
2. **Instance Storage** - Directly attached to a compute instance. Ephemeral - lives and dies alongside the instance.
	- Generally only available for larger EC2 instances.
	- Generally slightly faster due to proximity to instance.

This type of storage allows for easy mutation due to locality of blocks.
### Object Storage

Object Storage stores data as a three-value combination:
 1. **Key** that uniquely identifies the object. Generally looks like a URL, though with no actual file structure.
 2. **Metadata** on what is being stored
 3. **Data** itself that is being stored

*Objects are immutable* - in order to change data, you must overwrite the entire object.

#### AWS S3

**Simple Storage Service** (S3) is one of the most popular services offered by AWS in general. 
 - It provides an object store via buckets
 - Allows detailed access and modify permission policies
 - Fully-managed and serverless
 - Automatic redundancy across a region - data is automatically replicated six times across an AWS region.
 - Different tiers depending on size and access frequency
 - Durable: 10^-11 chance of losing a file annually

#### S3 Tiers

Amazon offers seven different tiers for how you store your data with different cost per GB and access time costs/guarantees at each tier.

<ins>Fast Access</ins>

1. **S3 Standard** - Cheapest access (usually free) but most costly per GB of data. Data is replicated in 3+ AZs.
2. **S3 Standard IA** - Cheaper cost per GB than Standard, but higher cost for reads.
3. **S3 One Zone IA** - Cheaper storage price than Standard IA, but only replicated in one AZ.
--- 
<ins>Archival</ins>

4. **S3 Glacier Instant Retrieval** -  Cheap storage, but costly retrievals. Guaranteed retrieval within milliseconds.
5. **S3 Glacier Flexible Retrieval** -  Cheaper storage, but costlier retrievals. Guaranteed retrieval within minutes (expedited) to hours (bulk).
6. **S3 Glacier Deep Archive** -  Cheapest storage, but costliest retrievals. Guaranteed retrieval within 12 hours.

Note that Glacier tiers require a specific API to access.

--- 
<ins>Intelligent Tiering</ins>

7. **S3 Intelligent Tiering** - Starts with S3 standard and intelligently moves data to more archival tiers as they don't get accessed for longer.
	 - Can redefine patterns with a lifecycle policy for more fine-tuned control.
### File Storage

File Storage offers a file system with directory and files to navigate.

AWS' implementation of this service is **Elastic File Service** (EFS)
 - Linux-based
 - Automatically scales with storage needs
 - Handles concurrent accesses from instances
 - Regional service and automatically replicated across AZs by default.

Amazon also offers other File System services under the FSX umbrella: Windows, Lustre, NETAPP.