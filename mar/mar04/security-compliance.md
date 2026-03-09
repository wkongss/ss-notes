## Security

Both the service provider and AWS are responsible for certain parts of security.

Anything that has to do with the provider's application and/or configuration are the responsibility of the AWS customer:
 - EC2 instance software
 - Applications delivered
 - Security groups
 - Firewall configuration
 - Account management

Anything that has to do with the infrastructure or platform itself is the responsibility of AWS:
 - Physical data centers
 - Hardware and software services provided
 - AWS network infrastructure
 - Virtualization and service isolation

### AWS IAM

AWS Identity and Access Management (IAM) is a free permissions service that lets you manage permissions of users at an account (contains multiple users) level.
 - Includes both **authenticating** the identity of users
 - And **authorizing** that users have necessary permissions

Each account has a **root user**. What permissions does it have? All of them. Generally advised to lock it up and instead create and use an IAM admin.

From there, create IAM policies that target specific actions (accessing a service/resource). 
These include:
 - **Version** - The version of the policy
 - **Statement** - Contains what the policy is for:
	 - **Effect** - Allow or deny the resource/service?
	 - **Action** - What to allow or deny?
	 - **Resource** - Which resources to allow or deny?
 
Note that these do NOT contain a **Principal** - For specific types of policies like resource policies, they must include a target of who the policy affects. Instead, IAM policies are assigned directly to targets.

The policy resolution is as-follows:
 - *Explicit Denies are the most powerful.* If multiple policies are assigned, a single explicit deny ensures the permission is not available.
 - *Explicit Allows override everything but explicit denies*. 
 - *Everything else is Implicitly Denied*


These can be assigned to:
 - **Users** - An individual or application (i.e. a service user)
	 - Best practice to provide each individual a user for the most granularity
 - **Group** - A group of users used for ease of policy management. Users can be a part of multiple groups
 - **Role** - A set of permissions temporarily assigned to / assumed by a user. Overrides all previous permissions

The best practice is to provide the least permissions possible for each individual to effectively execute their tasks.

### Multifactor Authentication

Multifactor Authentication (MFA) allows users to authenticate themselves with more than something like a password. This includes things that:
 - They know (passwords, security questions)
 - They have (authenticator app on a phone)
 - They are (fingerprints, face ID)

### AWS Organizations

AWS Orgs allows a tier higher than account-based IAM policies by managing multiple accounts (i.e. tech account, HR account, legal account).

Lets an admin define **Service Control Policies** (SCPs) on either:
 - An account
 - An **organization unit** (OU) consisting of multiple accounts - analogous to a group of users.

Unlike IAM policies, these are only used to deny permissions rather than explicitly grant them.

### Application Security

AWS provides multiple services to help with securing your entire cloud application.

#### AWS Web Application Firewall

Although we already have internal firewalls such as a Network APL and Instance security policies, Amazon offers another service called the **AWS Web Application Firewall** (WAF).

The WAF is an application-wide firewall that intercepts traffic before it even hits the outer layer of the VPC. It allows you to configure policies:
 - Similar to APL and instance policies, can allow/deny based on port, protocol, origin.
 - Can also filter the *content* for malicious patterns like SQL, XSS, HTTP flooding
 - Can use prebuilt AWS or third-party managed rules from the marketplace

#### AWS Shield

**AWS Shield** is a freemium service that protects your application from large spikes in malicious traffic known as Denial of Service (DoS) and Distributed Denial of Service (DDoS) attacks.
 - Integrates with other security services
 - Has a free tier for basic protection
 - Advanced tier is expensive but provides more sophisticated protection

#### AWS Key Management Service

**AWS Key Management Service** (KMS) is a service that helps create and manage keys for encrypting and decrypting data/traffic.

#### Amazon GuardDuty

**Amazon GuardDuty** is a service that provides cybersecurity threat detection via:
 - Analyzing network and account activity
 - Reporting abnormal findings
## Compliance

**AWS Artifact** is a free library that provides 
 - AWS' own security and compliance reports, 
 - Compliance agreements (plus tools for reviewing, accepting, and managing them),
 - Third-party audit reports

**Customer Compliance Center** provides you with resources on AWS compliance to regional and global standards (HIPPA, DoD, etc.). Contains:
 - Third-party resources and stories for regulatory compliance
 - Compliance papers and documentation
 - Training tools for compliance learning