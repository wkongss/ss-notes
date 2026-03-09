## Cloud Adoption Framework

The **AWS Cloud Adoption Framework** (CAF) is a resource that guides organizations towards a smooth transition towards the cloud.

Includes six guiding **perspectives**:
1. Business - makes sure our IT initiatives aligns with actual business needs and results in actual outcomes.
	 - Commonly involves business managers, finance managers budget owners, and stakeholders.
2. People - considers how it affects stakeholders (employees) in your organization
	- Commonly involves HR, staffing, management
3. Governance - includes necessary skills and processes that are needed to achieve IT and business goals
	- Commonly involves CIO, Program managers, enterprise architects, business analysts, portfolio managers.
4. Platform - focus on the actual implementation and migration of cloud solutions
	- Commonly involves CTO, IT managers solutions architects
5. Security - makes sure our security goals are met
	- Commonly involves CISO, IT security specialists
6. Operations - ensures general IT operations align with business goals
	- Commonly involves IT operations and support managers

Split into business (1-3) and technical (4-6).

## Migration Strategies

Before deciding on a strategy, first find out if you even want to migrate to the cloud during a **Discovery Phase**. This can also help better inform you on which strategy to choose.

These strategies include:
1. **Relocate** - moves an entire server to the cloud
2. **Rehost** - moves applications to the cloud separately
3. **Replatform** - migrates to the cloud but with small patches to better take advantage of the cloud
4. **Refactor/Rearchitect** - completely restructure an application to move it into the cloud
5. **Repurchase** - switching licensing models to save money or resources for the same application
6. **Retain** - keep what you have as-is
7. **Retire** - sunset your application

## AWS Snowball Edge

Service offered by AWS that ships a computer tower that assists in migration of data in a secure and offline fashion.

Compute-optimized model: 104 high-power vCPUs, 28 TB SSD, 16 nodes

Storage-optimized model: 104 vCPUs, 210 TB SSD, 16 nodes

## Innovation

How do we get from where we are and where we want to be and what's stopping us?

Consider: Serverless, AI, ML solutions.

### AI Services

#### Amazon Q

Is a generative AI assistant that helps you innovate with your application.

For everyday people: answers queries on your architecture and provides general tips.

For developers: also is able to generate code and help build AWS applications for your specific use case. 

#### SageMaker

Helps create ML models for data and analytics pipelines

## Well-Architected Framework

Helps you understand how to create better AWS applications with 6 pillars:

1. **Operational Excellence** - continually improve your operations by anticipating failure, monitoring and evolving the application
2. **Security** - protect information, systems, and assets, and creating risk-assessments. Use best-practices at every single layer + encryption.
3. **Reliability** - Test and scale the application so the application is available for customers. Includes automatic recovery, dynamic allocation, risk mitigations.
4. **Performance efficiency** - Use resources efficiently by experimenting often, and using more lightweight services like serverless options.
5. **Cost optimization** - Get the necessary resources using the least resources as possible via the cost explorers.
6. **Sustainability** - Minimize your environmental impact by maximizing the resources you have.