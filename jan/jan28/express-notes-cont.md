Uh... you can make handling requests `async` with promises, I guess.
You can also link multiple APIs together using this with fetch calls.

### Separation of Concerns - Express

The standard MVC model separates the roles of different parts of the fullstack application with the model (internal data representation), view (user-facing display), and controllers (the link between the two).

Express applications, however, generally have an even more well-defined separation with the entire HTTP lifecycle looking something like this:

`Request -> Router + Middleware -> Controller -> Service -> Repository -> DB`

Then, we propagate back up with:

`DB -> Repository -> Service -> Controller -> Response`

Note that the database is isolated from the MVC model and considered an external system.

 - The Router's function is solely to define the endpoints (and associated methods) available.
 - Middleware simply intercepts the request before processing (i.e. batch adding a header to the response).
 - The Controller then accepts each endpoint and calls services to generate the appropriate response and send it afterwards.
 - The Service handles all of the business logic in terms needed to create the response.
 - The Repository is an intermediary between the application and the database, actually making the database calls and converting it into the internal representation (the model) of the backend.

Sometimes in applications, the services aren't robust enough to warrant their own partition, so they may be combined with the repository layer.