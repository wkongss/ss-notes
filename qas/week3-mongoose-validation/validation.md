## Mongoose Validation

Mongoose with its Schema data structures, is able to perform automatic preliminary validation before saving documents into the database using a `.pre("save")` hook. This is automatically inserted before other `.pre("save")` hooks as well.

Validation acts as middleware between the call to save a document (done implicitly with static queries like `create` and `updateOne`) and the actual writing to the database.

If validation succeeds, the document is written to Mongo; if it doesn't, Mongoose will throw a ValidationError object.

Mongoose will automatically validate the following properties if specified:

 - `required` - if set to `true`, checks if the property is defined before the data is written.
 - `Number` types can validate that they are within a `min` and `max` field.
 - `String` types can validate based on a matching values in an array with `enum`, a regular expression with `match`, and having a length within `minLength` and `maxLength`.

You can also write custom validators by including the `validate` property within your schema field definitions:

```JS
const mySchema = new Schema({
    field: {
        type: Number,
        validate: {
            validator: (f) => { ... },
            message: "Failed!"
        }
    }
});
```

The property should define a `validator` function that takes in a parameter to validate and returns a boolean value: `true` if it passes validation and `false` otherwise.

You may also optionally include a message for the `ValidationError` if validation does not succeed.

This message can then be accessed using the thrown error's `error.errors.<field_name>.message` property.

While mongoose will only automatically validate structure before a database write, you can manually validate an instantiated document with the `document.validate()` for a promise-based validation or `document.validateSync()` for synchronous validation.

Reference: https://mongoosejs.com/docs/validation.html