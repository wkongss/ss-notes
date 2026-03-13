## Waterfall Model

The **Waterfall Model** is a sequential SDLC where each previous step must be completed until

1. **Requirements** - Flesh out project scope, goals, expectations with a **business requirements document** (BRD).
2. **Analysis** - Analyze the requirements and develop an outline of behaviors. Can be done in **unified markup language** (UML).
3. **Design** - Design the solution to meet requirements and expectations. What do we need to implement? How do we implement it? Includes sketches such as ERDs.
4. **Development, Testing, Deployment** - Implement and test the solution. Once completed, deploy it to production.
5. **Maintenance** - Maintain the current system with updates and patches, or choose to sunset it.

Due to the sequential nature, it needs very rigid requirements or else any change in requirements may reset sequential progress.
 - Still, any change goes through **impact analysis** to determine how much needs to be redone to implement a change. Needs to balance the triple constraints: budget, time, and scope.

## Agile

Methodology based off of the **Agile Manifesto**, which emphasizes flexibility and agility when faced with moving requirements. In particular:
 - Individuals and interactions over processes and tools
 - Working software over documentation
 - Customer collaboration over contracts
 - Responding to change over following rigid plans

In practice, this involves breaking down the overall development cycle into smaller ones where key goals and objectives are reached. This usually involves the implementation of **user stories**, or a description of a desired feature from the perspective of a stakeholder.

### Scrum

Scrum is an implementation of Agile that revolves around breaking tasks into 2-4 week **sprints**.

A **product owner** (representative from the client) fills a **product backlog** of features that they want implemented. A **Scrum master** adjacent to the development team then facilitates the completion of 

#### Scrum Ceremonies

 - **Sprint Planning Meeting** - used to decide what from the product backlog gets put onto the sprint backlog for the current iteration. Involves PO, SM, development team, and includes analysis of priorities and expected complexity.
    - Complexity is typically managed through **story pointing** via estimating the time it'd take. Common approaches are Fibonacci (based off of numbers) and poker (based off of playing card ranks) until a consensus is reached.
 - **Daily Standups** - brief meeting at the beginning of the day where everyone discusses what they did the previous day, what they plan on working on, and any blockers that the scrum master needs to resolve.
 - **Retrospectives** - at the end of a sprint, discuss what went well, what went poorly, and what should be maintained/scrapped for future iterations.

A **burndown chart** shows the total work remaining for the sprint.
On the contrary, a **burnup chart** shows the total work completed during the sprint.
