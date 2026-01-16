### Postgres

 - A server-based flavor of SQL that supports ACID transactions:
    - We can connect to a server using PgAdmin to view the schema and submit queries.

### Data Modeling

 - Representation of the data types (tables) and the relationship between the tables. Can be broken down into different forms:
    - **Conceptual Modeling**: the loosest forms - does not go into details about the types (no columns) and does not go into the type of relationship - only that a relationship exists. 
    - **Logical Modeling**: Generally demonstrated with an ERD (Entity Relational Diagram). Next step up, shows attributes, primary keys, foreign keys, and relationship type between tables (1:1, 1:M, M:M)
    - **Physical Modeling**: The last step in specificity - includes data types for each attribute. Usually represented with a DD (data diagram).

### Entities

 - In SQL, an entity is some real world concept that has its data modeled as a table.
    - Strong entities are able to be modeled without a foreign key - that is, its state does not depend on the state of other tables.
    - Their counterpart, weak entities, contain foreign keys, so it is dependent on other tables.

### Attributes

 - Each table has columns of attributes or pieces of data that describe the concept or entity. Example: Each person has a name with type TEXT.

### Keys

 - A candidate key is a set of attributes that are able to uniquely identify rows within a table.
   - Simple keys are just a single attribute - a simple key is trivially also always minimal. Composite keys, on the other hand, are a set of two or more columns that form a key - oftentimes used to model many-to-many relationships.
   - Each table *should* have at least one candidate key - the key made up of every attribute; however, this is oftentimes not minimal and a subset of these attributes can be used instead.

 - One candidate key (usually a minimal one) is selected as the primary key to uniquely identify each row in a table.

 - Some databases have default keys called surrogate keys (i.e. a `row_id`) that automatically increment for each record to ensure uniqueness.

 - A foreign key is a column (or columns in the case of composite keys) that stores the primary key of another table for querying. Can even be to the same table (i.e. employee table can house a manager column that references another employee).

### Entity Relationship Types

 - **1 to 1** - Each record of one table is associated with exactly one record of another table (bijective). Not very common since it's oftentimes easier to just have a single table sharing both attributes. Usually done out of sake of encapsulation / security (example: Person -- SS account).
  - Achieved by having a foreign key in each table.

 - **1 to Many** - Each record of one table is associated with any number of records of another table. 
  - This is achieved by having a foreign key in the "many table" (Credit Cards -E Transactions) that relates back to the "one table".

 - **Many to Many** - Each record of one table with any number of records of another table and vice versa. Example: A student can take many courses, and at the same time, each course can have many students enrolled.
  - Achieved by having a table in between that uses a composite key of the primary keys of both tables called a junction table - (Students -E Student_Course 3- Courses). Students and Courses are called lookup tables.

## Normalization

 - Sets of increasingly strict guarantees that prevent redundant data in database models.
   - Redundant data makes insertions, updates, and deletions more tedious (and possibly at greater risk of anomalies), though they may improve query speed.
      - Insertion anomaly: a valid record insertion is impossible or an invalid record insertion is possible.
      - Update anomaly: updating a record creates logical inconsistencies in the data.
      - Deletion anomaly: deletion of a record causes downstream unintended data loss.
   - Generally allow for better relational modeling and database extension.
   - Achieved by splitting data of a single table into separate tables.

### First Normal Form

  - Prevents duplicated primary key insertions - guarantee of atomicity.

  - Conditions:
   - Each table has a primary key that identifies each record.
   - Each column is of a single data type.
   - No repeated groups (each column contains a single unit of data).

### Second Normal Form

 - Prevents partial dependencies - guarantee of full dependency.

 - Conditions:
  - Already in 1NF
  - Every non-key attribute in a table must be dependent on the entirety of the primary key.

### Third Normal Form

 - Prevents transitive dependencies - guarantee of non-transitivity.

 - Conditions:
   - Already in 2NF
   - Every non-key attribute in a table isn't dependent on any other non-key attribute (every non-key attribute is dependent on the whole key, and nothing but the whole key).

## SQL

Generally, we want our SQL transactions to be follow ACID guidelines to ensure the integrity of the data within our database:

 - **Atomic** - Transactions should either fulfill completely or not at all (rolled back to the valid state before the transaction occurred). Partial transactions may violate data integrity and should never happen.
 - **Consistent** - Transactions should transport a valid database state to another valid database state.
 - **Isolated** - Transactions should act as if no other transactions are occurring. In the case of concurrency, some isolation guarantees may be relaxed.
 - **Durable** - As long as a transactional update to the database was successful, the new state should persist within the database even given an outage or failure.

Syntax notes [here](basics.sql).