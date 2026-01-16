-- Delete Tables with:
-- DROP TABLE table_name;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

-- Table creation using:
-- CREATE TABLE table_name (
-- 	attribute_name attribute_type constraints,
-- 	...
-- );

-- Example types:
--  - INT/INTEGER - whole numbers (32-bit signed integer)
--  - BIGINT - whole numbers (64-bit signed integer)
--  - DECIMAL(Figures left of decimal, figures right of decimal) - floats
--  - BOOLEAN/BOOL - true/false
--  - VARCHAR(length), TEXT - Strings, VARCHAR has a maximum length. Literal values should be in single quotes: 'example'
--  - SERIAL, auto-incrementing INT (useful for surrogate keys)
--  - TIME, TIMESTAMP - Times, can specify timezone
-- More here: https://www.postgresql.org/docs/current/datatype.html

-- Example constraints:
--  - PRIMARY KEY - declares an attribute to be a primary key (equivalent to: unique, not null)
--  - REFERENCES (table(attribute)) declares an attribute to be a foreign key
--    - Can also be defined with behavior such as ON DELETE CASCADE to declare what happens when primary key is deleted.
--  - CHECK (condition) - condition must be true
--  - NOT NULL - cannot be null
--  - UNIQUE - must be unique within the column
-- Reference: https://www.postgresql.org/docs/current/ddl-constraints.html

-- Example table creations:

CREATE TABLE IF NOT EXISTS departments (
	dep_id SERIAL PRIMARY KEY,
	dep_name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS employees (
	emp_id SERIAL PRIMARY KEY,
	emp_name TEXT NOT NULL,
	salary DECIMAL(10, 2)
);

-- Add records to a table with:
-- INSERT INTO table_name (column1, column2...)
-- VALUE
-- (attribute1, attribute2...);

-- For multiple insertions, use VALUES instead and separate records by commas:
-- INSERT INTO table_name (column1, column2...)
-- VALUES
-- (attribute1, attribute2...),
-- (attribute1, attribute2...),
-- (attribute1, attribute2...);

-- Example usage:

INSERT INTO departments (dep_name) 
VALUES 
	('HR'), 
	('Accounting'), 
	('Technology'), 
	('Sales'),
	('Marketing');

-- Delete data using the DELETE statement:
-- DELETE FROM table_name
-- WHERE (condition);

-- Example:
DELETE FROM departments
WHERE (dep_name = 'Marketing');

-- Can edit table schema with
-- ALTER TABLE table_name
-- ACTION

-- Example actions include:
  -- ADD COLUMN column_name
  -- DROP COLUMN column_name
  -- RENAME COLUMN old_name TO new_name
  -- ADD CONSTRAINT constraint

-- Example usage:

ALTER TABLE employees
ADD COLUMN
	department_id INT REFERENCES departments(dep_id);

-- ALTER TABLE employees
-- ADD CONSTRAINT
-- 	fk_employees_departments FOREIGN KEY (department_id) 
-- 	REFERENCES departments(dep_id);

-- ALTER TABLE employees
-- DROP COLUMN department_id;

INSERT INTO employees (emp_name, salary, department_id)
VALUES
	('John Doe', 65000.00, 1),
	('Jane Doe', 65000.01, 2),
	('Jake Doe', 300000.50, 3),
	('Jace Doe', 2.50, 3);

-- Edit table data using the UPDATE statement:
-- UPDATE table
-- SET attribute/column_name = new_value
-- WHERE (condition);

-- Example usage:
UPDATE employees
SET salary = 20000.50
WHERE (emp_name = 'Jace Doe');

-- Query data using the SELECT statement:
-- SELECT (columns) FROM table_name;

-- To select everything, use SELECT * FROM...

-- To filter queries, use the WHERE (condition) clause:
-- SELECT (columns) FROM table_name
-- WHERE (condition);
-- Conditions can include the binary operations AND, OR and unary operator NOT

-- To sort requests by a column, use ORDER BY.
--  - Defaults to ASC if not specified. For reverse order, use DESC:
-- SELECT (columns) FROM table_name
-- WHERE (condition);
-- ORDER BY (column1 ASC, column2 DESC)

-- You can alias tables and columns using the AS keyword:
-- SELECT FROM table_name as new_name

-- To combine multiple tables in queries, use JOINS:
-- Basic syntax: table_1 JOIN table_2 ON (condition)
-- The condition is usually a foreign key match on a primary key (table_1.fk = table_2.pk)

-- Different types of joins:
-- INNER JOIN/JOIN - takes the intersection of the two tables on the condition

-- LEFT OUTER JOIN/LEFT JOIN - takes all records in the left table (table_1) and appends applicable columns
-- of the right table that satisfy the condition. For records in the left table that do not have an associated
-- record in the right table have missing data and the corresponding joined columns set to NULL values

-- RIGHT OUTER JOIN/RIGHT JOIN - same as left join, but table order is reversed. Generally discouraged for
-- readability purposes as it's more natural to think of joining the second table to the first table.

-- FULL OUTER JOIN/FULL JOIN - the union of a LEFT JOIN and a RIGHT JOIN.

-- CROSS JOIN - matches every record in table_1 with every record in table_2. Creates a table of M x N records
-- if table_1 has length M and table_2 has length N. As every record is always joined, there is no ON (condition) 
-- statement for cross joins

-- You can join a table onto itself, called a SELF JOIN. This is usually done with an JOIN or LEFT JOIN.

-- Example usage

SELECT * FROM employees AS e
JOIN departments AS d
ON (e.department_id = d.dep_id)
ORDER BY e.salary DESC;

-- Set Operations are used to join two or more queries together.
--  - In order to do so, the queries must be of the same dimension (number of columns)
--  and type values (think of the records as a tuple).

-- SELECT columns1 FROM table1
-- WHERE condition1
-- SET OPERATOR
-- SELECT columns2 FROM table2
-- WHERE condition2

--  - query_1 UNION query_2 will return a new query result that contains all records from either query
--  with duplicates removed (similar in concept to a FULL JOIN)
--   - If you want to keep duplicate elements, use UNION ALL
-- - query_1 INTERSECT query_2 will return a new query result that contains the records that are in both
--   - queries with duplicates removed (similar in concept to an INNER JOIN).
--   - Similar to UNION, if you want to keep duplicates, use the ALL keyword.
-- - query_1 EXCEPT query_2 will return a new query result that contains the records in query_1 but not in
-- query_2
--   - Similar in concept to LEFT JOIN WHERE NOT NULL
--   - Can also use the MINUS keyword
--   - Can also use the ALL keyword
