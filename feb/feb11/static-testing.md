## Static Testing

Static testing involves the evaluation of work products without executing them. It includes both manual **inspection** such as reviews or automated **static analysis** with tools such as linters and spell checks.

In general, these improve qualitative aspects such as detecting static defects, readability, completeness, correctness, testability, and consistency.

Static analysis is generally available to anything that can be understood by a reviewer. This mainly only excludes things such as compiled or executable code.

### Use Cases

 - Static testing is generally preferred since the defects it finds are found earlier, directly, and are simpler and more direct.
 - Finds defects in non-executables such as documentation.
 - Finds non-dynamic-testable defects such as code styling, unreachable code. Can also include rare cases for test coverage.

Generally, the defects more associated with static testing include:
 - Requirement defects (inconsistency/ambiguity)
 - Overall design defects (bad database structure, non-modular design)
 - Things a compiler would catch like undefined variables, bad typing, and unreachable code.
 - Deviation from coding standars for readability/maintanability.
 - Obvious security vulnerabilities (buffer overflows, SQL injection).
 - Gaps in dynamic test coverage

Incorporating stakeholder feedback frequently in the process can help clear up misunderstandings and keep the team informed on updated project requirements.

### Static Review Process

Generally, performing static testing involves going through a certain implicit review process. If the test object is of sufficient scale, then this may need to be repeated multiple times.

Overall, these steps include:

 1. **Planning** - Define the scope, purpose, focus (characteristics), and exit criteria of the review. This may include necessary resources (info and time).
 2. **Initiation** - Prepare any necessary resources and ensure the work product is available to all reviewers. Reviewers should also be familiar with their individual and team responsibilities.
 3. **Individual Review** - Reviewers review their assigned scope and log identified anomalies, recommendations, and questions.
 4. **Analysis and Communication** - Analyze and discuss review logs from previous step with involved stakeholders and team members. Since not all anomalies are defects, disambiguate all anomalies during this step.
 5. **Fixing and Reporting** - Create defect reports for each found defect and address them. Submit a report once exit criteria is met.

Reviews have their special roles:
 - **Managers** decide what gets reviewed and allocates resources towards them.
 - **Authors** are the original work product creators who are responsible for fixing reported defects.
 - **Moderators** - run review meetings
 - **Scribe** - Records review information during a review meeting.
 - **Reviewer** - A project worker, subject matter expert, or stakeholder who reviews the work product.
 - **Review Leader** - Organizes the review operation itself

#### Review Types

 - **Informal Review** - Less structured and informal overview of the product to detect preliminary anomalies.
 - **Walkthrough** - A desmonstration by the product author to evaluate quality and provide education and generate suggestions.
 - **Technical Review** - A review focused on finding technical problems and generate improvements.
 - **Inspection** - A detailed and formal review following a structured process to find the maximum number of anomalies. Generally concludes with a report of findings. Done indepedently from the product author.

### Success Factors

 - Clear communication between authors, reviewers, stakeholders via meetings.
 - Clear and measurable entry/exit criteria. No participant evaluation.
 - Partition the product into chunks if applicable and choose appropriate review types and objectives for each.