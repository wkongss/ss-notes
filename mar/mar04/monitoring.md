## Monitoring

AWS offers certain services for monitoring both resource usage and activity logs:
### Amazon Cloudwatch

**Cloudwatch** is a service that provides a central dashboard that:
 - Provides realtime resource monitoring (updates in 5 minute intervals, 1 minute for enhanced tier) for instances
 - A central place to look at your metrics like usage, storage, bandwidth
 - Allows you to view any alerts you may have set up in regards to metrics (i.e. total resource usage flags/thresholds)

### Amazon Cloudtrail

**Cloudtrail** is a service that provides logs of action history that can be later audited if a root cause needs to be found.
 - Tracks user activities and API requests
	 - Includes the following: the event, the responsible user, the time, and the method (Console, CLI, SDK), and the result (access denied? request granted?)
 - Allows for smart filtering for troubleshooting
 - Reports unusual account activity
 - Activities are usually stored for about 90 days

### Amazon Trusted Advisor

**Trusted Advisor** is a service that automatically provides tips and guidance for improving your AWS application.

Can be implemented at all stages of deployment. The depth of the checks are based on the support plan the account is on.

Has checks based on six categories:
1. Cost optimization - Are we being resourceful with our money in terms of services used?
2. Performance - Do we have the right amount of compute for the job?
3. Security - Is our application secure?
4. Fault Tolerance - Is our application robust in case of outages?
5. Service Limits - Are we getting close to AWS' imposed limits?
6. Operational Excellence - Are we doing more things manually than we should?

Checks result in:
 - No problem found
 - A recommended investigation
 - A recommended action

