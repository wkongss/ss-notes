## Software Development Lifecycle

An SLDC is the abstract representation of how a particular software product is developed from both a logical and chronological perspective.

Some SLDCs are more sequential (waterfall, V), some are iterative (spiral), and some are incremental.

The way we test our product can greatly differ based on the model and methodologies. This can include:
 - Acceptance test-driven (ATDD)
 - Behavior-driven (BDD)
 - Domain-driven (DDD)
 - Extreme Programming (XP)
 - Feature-driven (FDD)
 - Test-driven (TDD)

 - and Kanban, Lean IT, Scrum, etc.

These impact the scope and timing of tests, the level of detail, the general approach, the amount of automation involved, and the responsibilities of testers.

Most generally: sequential models have a lot of prerequisites before a dynamically-testable model is created, so it is reserved only for later phases.

Iterative development models create working prototypes throughout product development, so static and dynamic testing can be done frequently + ability to perform regression testing.

Agile methodologies are fast and lightweight, meaning fast and lightweight test techniques (automation + regression) are also favored.

### General Good Practices

Regardless of which SDLC model, keep in mind:

 - Every software development activity should have a corresponding test activity, ensuring quality control at every stage.
 - Each level of testing should have different and specialized test objectives.
 - Analysis and design of a test level begins at the corresponding development level to provide early testing.
 - Review of work products is done as soon as possible so defects are caught as early as possible.

### Early Testing Paradigms

**Test-Driven Development**
 - Tests (general component or unit tests) are written before the corresponding product is produced.
 - A product is then created to satisfy the tests.
 - Both the tests and product may be simoultaneously refactored to adjust to stakeholder needs.

**Acceptance Test-Driven Development**
 - Tests are written specifically from the acceptance critera from stakeholders.
 - Tests are written prior to development to ensure a passing product meets the critera (i.e. a specified feature is in place and functional)

**Behavior-Driven Development**
 - Intended Product behavior is first defined in natural language.
 - Then, these product behaviors are translated into executable tests to be verified.

### DevOps

DevOps is the approach of combining software development and IT operations as a joint venture to achieve a common goal. 

This can include cultural and information exchange between certain teams, such as feedback, team autonomy, tools used, and pipelines like **Continuous Integration** (CI) and **Continuous Delivery** (CD).

Having a well-managed DevOps structure allows for:
 - Faster feedback turnaround on code quality.
 - CI encourages shift left (earlier) testing.
 - Increasing automation (CI/CD) + more stable testing environments and less manual testing.
 - Less regression errors due to increased automated regression tests.

Tradeoffs include:
 - Requires the active maintenance and establishment of a DevOps pipeline including automated CI/CD.
 - Automated testing and deployment requires additional resources.
 - Still requires manual testing.

### Shift Left

Another name for the idea of early testing - not waiting for a product to be complete to perform tests; rather - plan and write what is possible given the constraints.

Common practices include:
 - Review specifications in conjunction with the testing team.
 - Write tests before product code is written.
 - Use CI/CD for fast feedback with automated component tests.
 - Provide static analysis when available to prepare the product for later dynamic testing.
 - Designate testing requirements and perform the non-functional testing as early as possible.

Generally, this is good practice since although it comes with a higher upfront cost, it makes up for it with time/resources saved by catching defects earlier.

### Retrospectives

At the end of a project milestone, there is generally a discussion called a retrospective to go over:
 - The successful portions of the period and how to continue.
 - The unsuccessful portions and how to improve.

These are generally included in the test record and help with:
 - Increasing quality of testware.
 - Increasing the relationship between development and testing teams.
 - Increasing the quality of test bases via increased communication of requirements.

## Test Levels and Types

During various stages of the SDLC, certain scopes and focuses of tests may be more appropriate than others. It's important to choose the correct level(s) and type(s) for each process.

### Levels

The Testing Level pertains to the scope of what is being tested and generally include specific SDLC-dependent entry ane exit criteria, test objects and objectives, test bases, defects and failures, and approaches.

Basic levels include:

 - **Component/Unit Testing** - Tests each component in isolation instead of within an interconnected system.
 - **Component Integration Testing** - Tests the interactions between components. General integration strategies include bottom-up, top-down, or big-bang.
 - **System Testing** - Tests overall behavior of the entire product or system and includes end-to-end tests and holistic quality characteristic tests. May include subsystem simulation and be performed by an independent team.
 - **System Integration Testing** - Tests the way a product interfaces with various other systems or external services.
 - **Acceptance Testing** - Tests the fulfillment of business requirements and would ideally be performed by user stakeholders. In general, tests the readiness for deployment. Includes:
    - User acceptance
    - Operational acceptance
    - Contractual acceptance
    - Regulatory acceptance
    - Alpha, Beta testing.

### Types

Testing Types organize the methodology and how we actually perform tests.

These include:

 - **Functional Testing** - Tests the completeness, correctness, and appropriateness of the behavior of the test object and how it aligns with objectives.
 - **Non-functional Testing** - Tests less logical but more qualitative aspects of a test object including:
    - Efficiency and performance
    - Compatability
    - Interactivity and Usability
    - Reliability
    - Security
    - Maintainability
    - Portability/Flexibility
    - Safety
 - **Black-box Testing** - Involves developing tests without knowledge of the internal structure of the test object - treating it as a black box.
 - **White-box Testing** - Involves developing tests in relation to the internal structure of the test object - tests the specific implementation (code, architecture).

### Confirmation + Regression Testing

When the Test -> Debugging stage has been completed, we often want to verify the defect has been removed.

**Confirmation Testing** tests if the failures caused by the defect have been fixed. Can include executing the previous tests or writing new tests to adapt to the solution implemented.

**Regression Testing** tests that there are no other side effects caused by the implemented change to the test object. In the case of complex systems, these may extend beyond the scope of the test object itself.

Because of the frequency that regression tests are ran, they're oftentimes automated.

### Maintenance Testing

Software maintenance is also a part of the SDLC and requires testing, whether it be planned patches, hotfixes, sunsetting/retirement, or migrations (i.e. to a new version or new architecture).

The scope of testing depends on the risk assessment, size of the current system, and size of the change.

