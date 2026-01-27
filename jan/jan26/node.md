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
 - To install a dependency globally, use `npm i -g`. For example, we may want to add the package `nodemon` to all of our repositories to restart a server whenever a `.js` file changes.
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

#### Local Packages

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