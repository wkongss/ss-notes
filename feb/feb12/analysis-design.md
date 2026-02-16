## Dynamic Test Analysis and Design

**Test Analysis** determines *what* to test while **Test Design** determines *how* to test a given test object.

### Test Techniques

These help determine analysis and designs of tests in a more systemic manner via the definition of test conditions, coverage items, and test data.

#### Black-Box Test Techniques

No reference to the internal test object structure, so behavioral tests remain independent on implementation. This separation allows for implementation-agnostic test cases.

Techniques include:
 - **Equivalence Partitioning** - Partition the input, output, config space (all relevant data) into equivalent non-empty and non-overlapping sets that should have equivalent behavior. 
     - **Valid partitions** are those which the specification of the test object state that it should handle. 
     - **Invalid partitions** are those that it should reject. 
     - The main idea is to reduce test cases by reducing the test space through identifying functionally-equivalent test cases.

 - **Boundary Value Analysis** - Test the boundaries of equivalence partitions (requires canonical ordering, thus only works for ordered partitions). Boundaries can include the minimum and maximum values of a valid partition.
    - 2-value BVA tests the boundary point and the point right outside of the boundary (outside neighbor). Ex. `x <= 10` would test both `10` and `11` as inputs.
    - 3-value BVA tests both neighbors. Ex. `x <= 10` would test both `9`, `10`, and `11` as inputs.

 - **Decision Table Testing** - Testing based on all conditions and the corresponding expected action. 
     - A full table contains every feasible combination of conditions. 
     - Rows delineate independent and dependent variables while columns delineate a unique combination of them. 
      - Values may be boolean values (T/F) or a range of inputs/outputs. Coverage is defined by the number of columns tested out of the total number number of columns.

 - **State Transition Testing** - Starts with a state table and state diagram which detail product states and the events that transition the product between states. Tables show states in rows and columns show events (usually also show invalid transitions). Test cases are then written based on these:
    - **All States Coverage** - all states are reached in test cases.
    - **Valid Transitions Coverage** (0-switch) - All valid transitions are exercised within test cases. Note that states may be reached multiple times.
    - **All Transitions Coverage** - All transitions, both valid and invalid are tested. Very costly and generally reserved for mission-critical features.

Generally, Valid Transitions is the industry standard as it is a superset of all states. 

#### White-Box Test Techniques

Opposite of black-box. Tests are dependent on internal implementation structure. As such, need to be created after the design or implementation of the test object itself.

Techniques include: 

 - **Statement Testing** - The test object code is divided into statements (i.e. an if-else statement). Statement testing then aims to test each of these statements at least once to achieve 100% coverage.
     - Does not explicitly test logic as each statement may have many different logical branches based on the output.

 - **Branch Testing** - Differs from statement testing by testing all conditional and non-conditional control sequences. This means testing every branch of control-flow statements like if-statements switch-statements, try-catch statements. Generally much harder to achieve 100% coverage for large projects and is a superset of statement testing.

Some techniques not discussed include neuron coverage and API testing.

White box testing allows for actual code coverage rather than only focusing on expected behavior and can thus find defects where black-box testing cannot. However, it cannot detect the omission of expected requirements and may break on major implementation detail changes.

#### Experience-based Test Techniques

Utilize the knowledge and experience of the testers themselves. Generally complementary to black/white box testing.

Techniques include:
 - **Error Guessing** - Anticipate common points of errors within a test object based on past application experience, developer tendancies, and adjacent application experience.
     - Can take the form of **fault testing** where errors such as invalid input, output, logic, or data are compiled and then test cases and written to expose them.

 - **Exploratory Testing** - Tests are designed, created, and executed as a tester learns about an object. Can be used to find faults
     - Can take the form of **session-based testing** where a tester forms a test charter of objectives and then explores the object in a set window. Generally very high-level and followed by a debriefing.
     - Generally best for low time allocation or few specifications.
 - **Checklist-Based Testing** - Coverage and test conditions are aggregated into a checklist (excluding automatic criteria). General items are phrased in a question relating to a specific requirement.

### Collaborative Testing

Collaborative-approaches are more of a defect preventative measure rather than defect detection measure.

#### User Story Writing

A user story is an expression of a desired feature or functionality of a product from the perspective of an end-user or stakeholder.

Contain three parts:
 - **Card** - The medium that contains the story (a written note, a GitHub issue, a customer support ticket)
 - **Conversation** - Any background context explaining how the product is being used.
 - **Confirmation** - The acceptance criteria to resolve the story.

Generally in the form of "As a [user role], I want [goal], so that [purpose]" with accompanying acceptance criteria.

User stories allows a greater view of different perspectives: business, development, and testing.

Generally, these user stories should be independent, negotiable, valuable, estimable, and small enough to be testable.

#### Acceptance Criteria

Acceptance criteria for user stories are the conditions in which a user story would be satisfied by the particular stakeholder.

Generally, these help:
 - Define the scope
 - Facilitate a consensus between the end-user and the team.
 - Describe both satisfactory and non-satisfactory conditions.
 - Create a basis for testing
 - Create a more accurate planning and timeline

Acceptance criteria usually looks like:
 - Given... When... Then... for BDD
 - Bullet or tabulated list: **rule-oriented**.

#### Acceptance Test-Driven Development

Prior to implementing the product that fulfills a user story, acceptance tests are designed and implemented.

This involves analyzing the user story and resolving ambiguities or defects, creating test cases based on the acceptance criteria, and finally executing the cases or examples.

Generally the flow is positive functionality -> negative functionality -> qualatative validation. For stakeholder-facing tests, they usually contain descriptive natural language.