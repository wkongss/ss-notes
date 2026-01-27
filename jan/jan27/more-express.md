### Model View Controller

The MVC paradigm is a design architecture where application functionality is separated into three distinct parts:
 - The `model` is the internal representation of data. This can be done through classes, raw JSON, or an ORM.
 - The `view` is the outwards facing display of data after any processing involved.
 - The `controller` links the two together by creating endpoints with express, for instance.

### Express Router

We can move a lot of the functionality out of our main server file by sending traffic to routers. We define routers in another file:

```JS
// example-router.js
import express from "express";

const router = express.Router();

router.get("/", (req, res) => {
    ...
});

export { router as exampleRouter };
```

We then hook the router in our main file with the `app.use(path (optional), router)`:

```JS
// server.js
import express from "express";
import { exampleRouter } from "./example-router.js";

const app = express();

app.use("/example", exampleRouter);
```

### Express Middleware

Middleware are hooks that run after your request has been received and parsed, but before your handlers create a response. We've already seen one example with `express.json()`.

We're also able to define our own middleware with routers: in a new file, create a new router and then pass a function into a `router.use()` method:

```JS
// example-middleware.js
import express from "express";

const router = express.Router();

router.use((req, res, next) => {
    ...
    next();
});

export { router as exampleMiddleware };
```

Process the `req` and `res` and then call the `next()` function to hand off the request and response to the next item in line. Note that you shouldn't use `res.send()` here as it'll reply to the request without touching the rest of your handlers. 

Afterwards, import it into your main file and add it to your middleware stack with `app.use()`.

### Dotenv

`dotenv` is a library that allows you to access your environment variables defined in a `.env` file. This is usually a better place to store your API keys/sensitive information compared to a plaintext file.

To start, download the `dotenv` library with `npm`:

```
npm i dotnev
```

Import it into the file you wish to access your environment variables from:

```JS
import "dotenv/config";
```

Within a `.env` file in the root of your project, declare any environment variables:

```env
API_KEY = abcdefg
```

Lastly, access them through your code via `process.env.VARNAME`:

```JS
const key = process.env.API_KEY;
```

### CORS

Cross-Origin-Resource-Sharing is a way for servers to restrict which clients are able to access its resources by restricting the origin (i.e. you only allow requests from your designated frontned site `https://foo.com`). This is done with the `Access-Control-Allow-Origin` header.

By default, Express doesn't include the header, so it only allows same-origin sharing. To allow for cross-origin sharing, use the `cors` middleware. Install it using `npm`:

```
npm i cors
```

Import it into your server file:
```JS
import cors from "cors";
```

Add it to your middleware stack with `app.use()`"

```JS
app.use(cors());
```

This will by default allow all cross-origin sharing. Restrict it by adding in a cors config dictionary with the `origin` property set to allowable URLs:

```JS
app.use(cors({
    origin: "http://127.0.0.1:5500"
}));
```