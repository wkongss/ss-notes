### NoSQL

 - Stands for Not Only SQL, breaking away from the structured data and relational approach of SQL implementations.
 - Instead of storing items in tables with rows of records, databases like MongoDB or Firebase have no set schema and are operate on a looser idea of a collection of related pieces of data called documents. These documents are generally stored in a JSON (technically BSON) format with key (attribute) value (data) pairs.
   - An advantage of this is nesting, so you can directly store complex types like objects or simple data structures like arrays.
   - Non-relational and no schema meaning data doesn't necessarily have to adhere to a certain structure if such a feature is necessary for your application.
   - Example: a shopping website might have tags/categories for each product it sells. For SQL, you would have a `products_tags` table. In NoSQL, it'd be easier to have a tags: `[tag1, tag2, ...]` portion directly stored under the document for the product.
 - This isn't always better - there are tradeoffs in terms of data integrity (NoSQL's flexibility means you generally have to validate data within your code instead of relying on structural guarantees from SQL) but in exchange, you achieve greater flexibility in that regard.

### MongoDB

 - One of the most popular NoSQL database implementations is MongoDB. Requires a local or remote server to run.
 - Can be managed with Mongo Atlas in the cloud or locally on your own server with the community edition.
 - Each record has a uniquely-identifying object ID that sort of acts as a primary key (and therefore can be used as a foreign key). In order to use this, wrap it in the `ObjectId()` type.

 - Once a server is spun up, either access it via the GUI (Compass) or the `mongosh`.
    - Use `show dbs` to bring up a list of all databases.

    - To create a db, do `use db_name`. This will also swap the current database you're working on.

    - Within a db, use `show collections` to bring up a list of all the collections within the database.

    - To add a collection, swap to the database and use `db.createCollection("collection_name")`.

#### Insertions

-  To add a document to a collection, use:
	- `db.collection_name.insertOne({ k1: v1, k2: { k3: v3 } ... })`.
- You can also insert multiple records with:
	- `db.collection_name.insertMany([{ obj1 }, { obj2 }, ... ])`

#### Querying

- Perform a simple query by using `db.collection_name.find()` to bring up the records in the collection. Results can then be filtered using query predicates denoted by the `$` character:

```MongoDB
// Filters results such that only those with key: value show up.
db.collection_name.find({
	key: value
})

// Filters results such that those only with key >= value show up.
db.collection_name.find({
	key: { $gt: value }
})

// Limits the number of results that show up in a query:
db.collection_name.find({
	...
}).limit(limit_num)

// Sorts the results based on a document attribute:
// value of 1 for asc, value of -1 for desc.
db.collection_name.find({
	...
}).sort({ attribute_name: 1 })
```


- There's plenty of other constraints, all of which are denoted with the special `$` character:
	- `$gt`, `$lt`, `$gte`, `$lte`, `$neq`: $>, <, \geq, \leq, \neq$ respectively.
	- `$in: [arr]` and `$nin: [arr]`: check if the value matches any value in the array.
	- `$not`, `$and: [arr]`, `$or: [arr]`, `$nor`: implements the respective logic operators
    - Reference: https://www.mongodb.com/docs/manual/reference/mql/query-predicates/

- To reference nested values like `{ k : { nested : v } }`, use dot notation with quotes: `"k.nested"`.
#### Updates and Deletions

Of course, you can still use the same query predicates with updates and deletes.

```MongoDB
// Updates one document based on a match on a constraint (k-v match), then sets 
// the new value. Can update all matches instead with updateMany.
db.collection_name.updateOne({
	key: value,
	$set: { key_to_update: new_value }
})

// Deletes one document based on a constraint (k-v match), then sets the new value
// Can delete all matches instead with deleteMany
db.collection_name.deleteOne({
	key: value,
})
```

Aggregate data:

- Data aggregation is one of the most powerful tools within MongoDB, allowing us to create complex queries that reference different collections (similar to JOINs).
	- Aggregations can be very complex and involve entire pipelines. A very simple aggregation pipeline would be something like:

```MongoDB
db.collection_name.aggregate([
	// Filter results
	$match: { constraint },
	// perform a left outer join on a foreign key
	$lookup: {
		from: lookup_collection_name,
		localField: foreign_key
		foreignField: primary_key of lookup_collection
		as: new_field_name
	}
])
```

- `$match` filters our first collection on the constraint.
- We then append the results from the `$lookup` on the match and return the result.
- Reference: https://www.mongodb.com/docs/manual/aggregation/

Note that within your application, MongoDB is oftentimes accessed via some sort of wrapper and that these functions may vary - these are simply how to use the mongo shell.