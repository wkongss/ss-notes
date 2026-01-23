## Event-Driven Programming

Event-driven programming is a paradigm that is reactive to "events". The basic idea is that we create callback functions that handle these events when they occur. There are objects that are able to emit events. When an event is emitted, all "listeners" to that event are notified and a callback function is ran.

As an example, if you have a button on a web page, it may emit an `onClick` event whenever a user clicks it. A listener would then handle that `onClick` and perhaps perform an action.

## Ajax

In ye olden days without the `fetch` API, the premier way of creating JavaScript HTTP requests was using the Asynchronous JavaScript and XML (AJAX) API.

Nowadays, it is usually best practice to use the `fetch` API due to its support for promises and flexibility.

To get started, create an `XMLHTTPRequest` object (or `XHR` for short):

```JS
const req = new XMLHTTPRequest();
```

Then, attach a listener to the request to respond to when the state of the request changes in accordance to the XHR lifecycle:

```JS
function handleChange() {
    if (this.)
}

// Is called whenever the state changes
req.onreadystatechange = handleChange;
```

Alternatively, you can use dedicated functions for different stages or add a listener:
```JS
// Is called only when the state changes to LOAD
req.onload = handleLoad;

// Adds a listener that is called when state changes to LOAD
req.addEventListener("load", () => { ... });
```


### XHR Lifecycle

There are 5 stages of the lifecycle that can be checked using the `req.readyState` property:

 1. `UNSENT`, `readyState = 0`
 2. `OPENED`, `readyState = 1`
 3. `HEADERS RECEIVED`, `readyState = 2`
 4. `LOADING`, `readyState = 3`
 5. `DONE`, `readyState = 4`

The respective status codes can also be accessed using `XMLHTTPRequest.UNSENT, XMLHTTPRequest.OPENED, ...`

After the creation of your XHR, open a request using the `open` method:

```JS
req.open(method, location);
```

 - The `method` refers to the HTTP action verb (`GET`, `POST`, `PUT`, `DELETE`) as a string.
 - The `location` is the endpoint location you wish to send your request to, again as a string.
 - There are additional optional parameters `async` for blocking purposes, as well as `user` and `password` for authentication purposes.

Afterwards, send your request using the `send` method:

```JS
req.send();
```

 - You may optionally pass in a `body` parameter. This can include a payload of data you wish to send along with the request. Usually for `GET` requests, this is unecessary.

Reference: https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest_API/Using_XMLHttpRequest


## Fetch API

The `fetch()` API is now the preferred method of creating HTTP requests in modern browsers. It works by sending a request and returning a promise that can be handled on completion. 

It has a number of other advantages over XHR, including but not limited to: built-in CORS support, expanded authentication support, abortable requests, and promisified responses.

It's used as follows:

```JS
fetch(location, { config });
```

 - `location` is the URL that you want to send the HTTP request to.
 - `config` is an optional object that can be passed in to configure the request. Common configurations include:
    - `method` - used for changing the HTTP method used. Note that `fetch` by default uses a `GET` request if this isn't overwritten.
    - `body` - used for any other information you may want to include with the HTTP request. Note that this is always streamified, so it is consumed when an HTTP request is sent. That is - you can't send a message with a body twice.
    - `headers` - any HTTP request headers you may want to include with your request.

Reference: https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch