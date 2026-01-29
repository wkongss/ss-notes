## Mongoose

Mongoose is a JavaScript library that offers a layer of abstraction over a MongoDB database.

More formally, it's an Object Document Model (ODM) and provides functionality such as:
 - Modeling collection data structure within your application
 - Providing a little bit of data validation with said data structure (i.e. necessitating required fields and unique)
 - Provides out-of-the-box query abstraction and builders

Mongoose is not the database itself; instead, it connects to your database using:

```JS
import mongoose from "mongoose";

mongoose.connect(dbURL)
```

Your database URL usually looks something like:
```
mongodb://127.0.0.1:27017/dbname
```

This is usually stored in your `.env` file and may vary based on production vs. development environments.

### Schemas

The core of Mongoose modeling are schemas, which dictate the structure of your documents within a collection.

To start, define a schema with:

```JS
import { Schema, Types } from "mongoose";

const exampleSchema = new Schema({
    field1: Number,
    field2: {
        type: Number,
        required: true,
        unique: true
    }
    ...
});
```

Define the type that each field should be. You may also additionally specify parameters such as `required`, `unique`, or `default` though they have defaults if not provided. Mongoose will enforce these structures during runtime when trying to create a document for the database.

If you want to specify an array, use `[type]` like `[Number]` for an array of numbers.
To specify an ObjectId, use `Types.ObjectId`.

A list of valid schema types can be found here:
https://mongoosejs.com/docs/schematypes.html

Afterwards, map your schema onto a collection with:
```JS
const Example = mongoose.model("Example", exampleSchema, "examples");
```

The arguments in order are:
 - **Model name** (string) - The name associated with your model.
 - **Schema** (schema) - The schema to map to your model.
 - **Collection name** (string?) - The collection to map to your model. By default, this is your lowercase model name pluralized, but can be explicitly set here.

Afterwards, you're able to instantiate objects of this model:

```JS
const ex = new Example({ field2: 123 });
```

This instance can then be written to your collection using the `save()` method:

```JS
ex.save();
```

Note that this is a promise, so needs to be awaited if later code depends on the object being written.

#### Schema Functions

Schemas can be extended with methods, static methods, and helpers. These can be useful to specify database operations.

Assign a method to your schema using the `methods` property like so:

```JS
exampleSchema.methods.exampleMethod = () => { console.log("Example"); };
```

Static methods can also be set with the `statics` property:

```JS
exampleSchema.statics.exampleStaticMethod = () => { console.log("Static example"); };
```

These can be particularly useful if you wish to define common custom queries not included within the standard querying methods.

Query helpers are defined with the `query` property and can then be used to chain queries:

```JS
exampleSchema.query.byFieldTwo = function(fieldVal) {
    return this.where({ fieldTwo: fieldVal });
}

// Chain like so:
Example.find().byFieldTwo(3)
```

Be wary of using arrow functions with the `this` keyword as they don't capture the context unlike a normal `function()` definition.

### Built-in Functions

Mongoose models come with built-in ways of performing basic CRUD operations:

#### Querying

Use the `Model.find()` method to look up the entirety of the collection. You may also pass in a query object as an argument such as `{ $gt: 3 }` to filter your search. 

Alternatively, you may filter your search by chaining additional parameters such as 
- `.where()`
- `.gt()`
- `lt()`

#### Insertion

Use `Model.create()` to create a single document and `Model.insertMany()` to insert an array of documents.

#### Updating

Use `Model.updateOne()` or `Model.updateMany()` to update.

Pass in a `filter` query first followed by the update you want to perform.

#### Deleting

Use `Model.deleteOne()` or `Model.deleteMany()` to delete documents. They both take a single argument of a filter object.

Reference: https://mongoosejs.com/docs/models.html