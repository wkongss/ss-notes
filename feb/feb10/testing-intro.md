## Testing

Testing is an important preventative measure to ensure software quality that would otherwise harm reputation, profits, or cause real-world injury.

In general, **software testing** covers the entire process of discovering and evaluating defects in software products (test objects in a testing environment). Includes both:
 - **Verification** (testing the object based on internal requirements specified).
 - **Validation** (testing the objected based on actual stakeholder expectations)

We can further subdivide testing into two groups:
 - **Static testing** - Preliminary testing that doesn't include actual test object execution. This is moreso a fault review and analysis of the object itself.
 - **Dynamic Testing** - Tests the object against test cases.

### Testing Objectives

Goal of testing is to:
 - Intake product requirements, use stories, and product information.
 - Check if they align with each other.
 - Simulate failures in order to find defects in the product.
 - Increase the confidence of higher quality software.
 - Ensure the product meets contractual and legal requirements.

The emphasis and which and what objectives are necessary is highly contextual based on what product is being tested including the risks and SDLC followed.

### Testing vs Debugging

These are two separate activities: testing involves triggering a failure (dynamic) or finding defects directly (static).

Then, **debugging** involves reproducing the feailure, diagonising the defect, and then fixing the defect for dynamic failures. For static failures, it is simply fixing the issue.

After debugging is complete, the patched product is then handed off to do additional testing to check if the problem was resolved.
 - This may also include **regression testing** to check if the fix broke other features.

### Testing Necessity

Testing helps detect defects in software. Here's why it's necessary:

 - Generally, it's cheaper in both time and money to fix problems earlier on. Frequent and focused testing allows us to do so.
 - Contributes to overall software lifecycle decision making by evaluating the quality of each stage.
 - Provide implicit user and stakeholder representation on project during the development lifecycle.
 - Could be a contractual or legal requirement.

### Testing vs. QA

Quality Assurance is focused on the overall process of development in terms of delivering a high-quality product. In general, this is a superset that involves PMs, Developers, Testers in decision-making.

Testing is a more product-focused and focused on rooting out defects.

### Errors, Defects, Failures, Root Causes

**Errors** are the underlying mistakes made by humans that cause defects. These include:
 - Miscommunication on product requirements
 - Product complexity
 - Personal inexperience

Defects then are mistakes in the software product (from top to bottom including tests, source code, documentation). These include:
 - Incorrect logic (in source or test code)
 - Incorrect documentation
 - Missing cases
 - Stale code that wasn't updated while dependent code was.

Failures are a mismatch in product performance and expected performance caused by errors. In general:
 - The product does not perform a function it is specified to perform.
 - The product performs a function that it is not specified to perform (allows for special characters in usernames)

Note that not all defects result in a failure, and not all failures are caused by defects (some may be caused by the environment or firmware).

Root causes of a failure are the underlying defect(s) that are the source of the failure.

### Principles of Testing

1. Testing only shows the presence of defects and not the absense of them. There is in general no way to prove the absence of defects - just increase the confidence of a product having fewer.

2. Except in trivial cases, it is impossible to exhaustively test a system. Instead, think of testing as a limited resource and prioritize resources on areas of high risk or high impact.

3. Test as early into the lifecycle as possible. This will generally decrease the cost of debugging (or even the cost to users if the product is in a production environment), especially as projects get more complex over time.

4. Defects are clustered - generally follow the Pareto Principle that 80% of issues are caused by 20% of defects. Look for the most prone components and make them a higher priority.

5. Tests become ineffective over time as a system evolves. Make sure tests are up-to-date or create new tests in order to compensate for lapses in coverage of the older tests.

6. Testing highly depends on the context of the product, environment, etc.

7. Testing does not end when requirements are met. There may be hidden constraints that users are looking for in a functional product. Continue with validating these to meet expectations.

### Testing Activities and Testware

While testing is highly context-dependent, there are still general procedures in how it is best practiced. The order and implmentation of these activities may vary based on SLDC (i.e. some may be more parallel with each other):

1. Planning - review and define objectives for testing and then choose approaches (technologies, testing objects) to handle these.

2. Monitoring and Control - Continously check the test activities and the fulfillment of the objectives laid out in the plan.

3. Analysis - Identify the testable features available and their testibility as well as the associated objectives with them. You may prioritize testing objects at this stage. The "What to test" question.

4. Design - After analysis, consider the test conditions and necessary **testware** or tooling necessary to to meet these conditions. Consider the techniques and testing environment. The "How to test" question.

5. Implementation - After designing tests, acquire the necessary testware and begin creating the manual and automated test scripts. Schedule the tests in an efficient manner and verify the correct environment and test suites are in place.

6. Execution - Run the tests implemented in the last step. Compare the test results with expected results and log the results. Preliminary root cause analysis may be performed or otherwise deferred to development team.

7. Completion - Resolve the anomolies or if any defects are unresolved, add to a todo list for the appropriate team. Generate a report in regards to the scope of activities and improvements made.

This process is inclusive of many factors, not just those involved with testing:

 - Stakeholder's needs and expectations must be incorporated at every part of the process.
 - The expertise and skills of the rest of the development team.
 - Business domain may better inform risks and regulations.
 - Technical constraints such as architecture and stack.
 - General resource constraints (scope, time, budget)
 - The methodlogy and lifecycle being maintained.

**Testware** is any output produced at any point during the process and can include:

 - Test plans, schedules, risk analysis (assessment, probabilitiy, impact, mitigation), entry and exit criteria, progress reports from the planning and monitoring stages.
 - Test conditions (criteria and constraints) from the analysis stage.
 - Test cases, charters, coverage from the test design stage.
 - Test scripts, suites, mocks, and environment setups from the implentation stage.
 - Logs and generated reports from the execution stage.
 - Holistic report (including learned lessons) and actionable items from the completion stage.

**Traceability** is the accurate association or link between test conditions, test cases, results, defects, and requirements. 

Maintaining accurate traceability helps organize priority lists and maintain up-to-date monitoring. 

It may also be used to re-assess decisions or create up-to-date progress analysis to communicate with stakeholders.

Testing Management roles are generally geared towards leadership that dictate the planning, monitor + control, and completion phases. This may be associated with the general development team or dedicated test managers.

Testing roles are genearlly more technical and are concerned with the anaylsis, design, implementation, and execution of tests.

### Fundamental Good Practices

 - Accurately apply testing and technical knowledge to ensure the effectiveness of tests.
 - Be thorough and methodical in terms throughout the entirety of the process.
 - Communicate and comprehend with all involved parties (team members, management, stakeholders), especially when deliverying bad news: "Fix this issue, pretty please!" - be objective, constructive and thoughtful in how you may be perceived.
 - Think critically and leverage domain experience.

Testers, along with the rest of the team, are there to create and ship a quality product. This ultimately necessitates everyone on the team, so they need to be able to collaborate effectively and communicate results and defects to the appropriate specialists.

Testing should be carried out with multiple levels of independence:
 - Low independence: test object author performs testing. While this ensures a high degree of familiarities, may also overlook coverage because of it.
 - Medium independence: test carried out by in-house testers.
 - High independence: test carried out by independent third-parties. Generally prevents knowledge-based biases but limited in scope due to lack of technical foundations.

Generally, use different levels of independence and perspectives to find different types of failures.