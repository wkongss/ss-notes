## Express

Express is a widely-used packaged for setting up a back-end server and includes features such as a dedicated middleware ecosystem, endpoint handling, and configurable listening.

To install it into your project, use:

```bash
npm i express
```

Afterwards, import it and create an express app and listen on a port:

```JS
import express from "express";

const app = express();
const port = 8080;

app.listen(port, () => {
    // setup function
});
```

### Handling HTTP Requests

To create endpoints for Express, use your `app` object and then specify an endpoint with the HTTP method (i.e. `GET`) with the following function:

```JS
app.get("endpoint", (req, res) => {
    // Callback
});
```

You may also opt for `post`, `put`, `delete` methods:

```JS
app.post("endpoint", (req, res) => {
    ...
});

app.put("endpoint", (req, res) => {
    ...
});

app.delete("endpoint", (req, res) => {
    ...
});
```

 - The `endpoint` is the relative URL to respond to. Example: `/` responds to `https://mysite.com/` and `/aboutMe` would respond to `https://mysite.com/aboutMe`.
 - You then pass in a callback function that takes in the Request Object `req` and the pending Response object `res`.
    - The `req` object contains useful information about the request such as `req.headers` for headers and `req.body` for the request body.

Do whatever processing you need to do in the callback function and then send back a response:

```JS
app.get("/eightBall", (req, res) => {
    res.send("Answer unclear - ask again later.");
});
```

Send can take in many different parameters:
 - A Stream or Buffer (including a string)
 - A JSON literal or a JSON-ified object
 - Some HTML in the case of a webpage

Change the status code of your response using the `res.status()` method:

```JS
app.get("/eightBall", (req, res) => {
    res.status(200).send("Answer unclear - ask again later.");
});
```

Note that by default, it'll send a status of 200. Any 3 digit positive integer can be sent by default, though, it's generally advised to stick to the ones with well-defined meaning.

### Handling Request Payloads

Sometimes, a request, such as a `PUT` or `POST` request will contain a payload alongside its first line and headers. In order to actually process this payload, however, you need to let express know and process the type of body that is being sent. Most of the time, this will be in JSON (JavaScript Object Notation).

We do this by using what is called **middleware**, or hooks that act in between the request and our eventual response. To attach a piece of middleware, call the `app.use()` method:

```JS
const app = express();
app.use(express.json());
```

Here, we are using the `express.json()` middleware to process our body into JSON, which we can then receive in our handlers' `req.body`.

### Routing and Query Parameters

Express allows us to extract information directly from the URL.

#### Routing Parameters

We may want to include information within our URL for GET requests for example like `GET https://example.com/users/13` where 13 is our user ID. To handle these, define the endpoint like so:

```JS
app.get("/users/:id", (req, res) => {
    const { id } = req.params;
});
```

The routing parameter `id` is defined in the URL prefixed with a colon.
We can then access the `id` property to use in our handler with the `req.params` object.

#### Query Parameters

Sometimes, we have query parameters such as in the case with search results. They usually look something like this: `GET https://example.com/users?name=tom&username=tommyboy`

Here, the start of the query is denoted by `?` and each individual query is separated by an `&`.

Express automatically extracts these and we can access them using the `req.query` property of the Request object:

```JS
app.get("/users/", (req, res) => {
    const { name, username } = req.query;
});
```



### Endpoint Chaining

If we have multiple HTTP methods associated with a single endpoint, we can chain the handlers together with an `app.route()` method:

```JS
app.route("/example")
    .get((req, res) => {
        ...
    })
    .post((req, res) => {
        ...
    })
    .put((req, res) => {
        ...
    })
    .delete((req, res) => {
        ...
    });
```