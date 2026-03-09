## Databases

AWS offers multiple type of database services. Most broadly, they can be split into two categories:

### Relational Databases

Structured database tables that store specific entities following a fixed schema. Most common is SQL.

AWS' implementation is its **Relational Database Service** (RDS). 
 - Automatically operates and scales the database in the cloud.
 - Fully-managed by AWS
 - Can store and transmit data in an encrypted form
 - Runs in a specific AZ and tied to EC2 instances.

RDS contains many database engines:
1. Amazon Aurora - specific to RDS
	 - Can optimize for high IO operations
	 - Automatically replicated across the region
	 - Built on top of either PostgreSQL or MySQL
	 - Generally faster than the normal RDS instances
	 - Can be used in a serverless manner
2. PostgreSQL
3. MySQL
4. MariaDB
5. Oracle DB
6. Microsoft SQL
7. IBM db2

Certain enterprise options such as Oracle DB may be costlier. Choose the engine based on your current tech stack, cost, or specific features necessary.
### Nonrelational Databases

Not Only SQL are non-relational and usually use either key-value pairs, JSON format, or Graph formats to store data. Generally, this is more for more less structured data.

AWS offers multiple services:
1. **DynamoDB** - Serverless key-value database that automatically scales with capacity and traffic.
2. **Amazon Document DB** - AWS' implementation of MongoDB as a service
3. **Amazon Neptune** - Graph database that can store networks and loosely-structured connections
4. **Amazon Quantum Ledger DB** (QLDB) - Stores a history via a centralized blockchain
5. **Amazon Managed Blockchain** - Stores a history via a decentralized blockchain

#### Database Migration Service

AWS offers a Database Migration Service (DMS) that allows you to migrate an existing database to a target database service in the cloud.
 - Database types don't necessarily have to match (i.e. Microsoft SQL -> Aurora)

### Other Database Services

AWS also offers a variety of other DB services:

1. **Amazon Redshift** - Mainly used for querying and analyzing data across multiple disjoint databases (a data warehouse)
2. **Amazon Elasticache** - Caching service to improve read efficiency for RDS DBs (can be implemented through Redis or Memcached)
3. **Amazon DynamoDB Accelerator** (DAX) - Caching service for DynamoDB to microseconds.