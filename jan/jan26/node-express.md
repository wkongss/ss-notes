## REST APIs

See notes [here](../jan19/http-notes.md).

## Node

Node.js is a Javascript runtime that uses the V8 Javascript engine to run and execute code outside of a web browser. This is generally 

### NPM

Node.js comes with its own package manager called Node Package Manager or `npm` for short.

Create a node project with `npm init`. This will generate a `package.json` file for you.

 - Project information and dependencies stored in the **`package.json`** file.
    - Houses info such as project name, scripts (dev, build, test, production - run with `npm run script-name`), version, entry point, license, author, etc.
 - Project-specific packages are stored in the **`node_modules`** directory.

Similar to the Maven Repository, [npmjs](https://www.npmjs.com/) hosts remote packages that can be downloaded and used for your own project.

To do so, use `npm i` to populate your dependencies with everything in your `package.json` file. To add a new dependency, use `npm i package-name` to install it.
 - To install a dependency globally, use `npm i -g`
 - To uninstall a dependcy, use `npm un package-name`.

To run a script, use `npm run script-name`.

Once a package is installed, use either ESM imports:
```JS
import express from "express";
import { Button } from "react-bootstrap";
```

or CommonJS imports:
```JS
const express = require("express");
const { Button } = require("react-bootstrap");
```

You can also define your own exports in another file to be imported later. For ES6, simply use the `export` keyword:

```JS
export myFunc() {
    ...
}
```

For CommonJS, define the `module.exports` property at the bottom of your file:

```JS
function myFunc() {
    ...
}

module.exports = {
    myFunc: myFunc
};
```

Lastly, import the module from the file `path`.

To run a JS file, use `node file-name`.

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

### Handling HTTTP Requests

To create endpoints for Express, use your `app` object and then specify an endpoint with the HTTP method (i.e. `GET`) with the following function:

```JS
app.get("endpoint", (req, res) => {
    // Callback
});
```

You may also opt for `post`, `put`, `delete` methods.
 - The `endpoint` is the relative URL to respond to. Example: `/` responds to `https://mysite.com/` and `/aboutMe` would respond to `https://mysite.com/aboutMe`.
 - You then pass in a callback function that takes in the Request Object `req` and the pending Response object `res`.

Do whatever processing you need to do in the callback function and then send back a response:
```JS
app.get("/eightBall", (req, res) => {
    res.send("Answer unclear - ask again later.");
});
```