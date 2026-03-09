## Pricing

It's important to understand how billing in AWS works in order to maximize what you get for your money.

Generally, there are certain concepts AWS runs on:
 - **Pay as you go** (consumption-based) - pay for resources used (associated with serverless models)
 - **Pay for what you reserve** - pay for services by reserving capacity like EC2 or RDS
 - **Pay based on volume** - certain services have discounts as you use more (i.e. less cost per GB or request)

The **AWS Pricing Calculator** lets you specify a configuration for a service and it'll show you a pricing estimate that can be exported and combined with other estimates.

The **AWS Budgets** tool lets you view your current monthly expenditures and set thresholds for usage/costs so you don't overspend.
 - Also includes forecasted values for end of month
 - Thresholds can either just send an alert or perform an action to shut down resources.
 - Has groupings and tag feature to filter items

The **AWS Cost Explorer** tool lets you view your historical spending and resource usage over time.
 - Includes graphs and tables for metrics
 - Can filter based on services, users, set time periods, etc.
 - Can download data via CSV and other reports

### Specific Service Charges

- **AWS Lambda**
	- Compute time
	- Number of requests
	- Can be paid via compute savings plan
- **EC2**
	- Provisioning the instance
	- Reduce with spot instances
- **S3**
	- Storage by GB/month
	- Requests and retrievals by tier
	- Transfer to end user (egress) or different regions with exception of CDN delivery
	- Management and cross-region replication
### AWS Free Tier

Contains three tiers of services:
1. **Always Free** - do not expire, but do come with certain restrictions (i.e. number of requests)
2. **12 Months Free** - free within a limit for 12 months. Recently changed to a credit model where you can expend $200 of free credits on these.
3. **Trials** - free for a set amount of time (30-90 days)

### Billing Consolidation

Using AWS orgs, you can receive a single itemized bill for all accounts. 
 - This also allows for savings from cross-account volume resource usage.

### AWS Support

AWS offers multiple tiers of support that affect what resources you have access to while using Amazon Web Services:

1. **Basic**
	- Technical papers, documentation
	- AWS help dashboard
	- Some Trusted Advisor checks
	- Free!
2. **Developer** - $29/month
	 - More checks
	 - Diagnostic tools
	 - Best-practice guides
3. **Business** - $100/month
	- All AWS Trusted Advisor checks
	- Use-case guides
4. **Enterprise On-Ramp** - $5500/month
	- A technical account manager who will work with you
	- Architecture guides
5. **Enterprise** - $15000/month
	- Infrastructure event
	- A dedicated technical account manager for your org specifically

### AWS Marketplace

The **AWS Marketplace** is a catalog containing third-party software and tooling for building your cloud application. Each entry has pricing and reviews. Broken into categories: business applications, data and analytics, DevOps, infrastructure software, internet of things, machine learning, migration, and security.