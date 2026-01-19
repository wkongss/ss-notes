## Web APIs

- The current web infrastructure is primarily built on HTTP (Hypertext Transfer Protocol). **Clients** send a request to a **Server**, which then in turn responds with a response.

### HTTP Requests

- The Hyptertext Transfer Protocol is a lightweight way of exchanging information between a client and server. This can include

![[figures/http-structure.png]]
- The general format of an HTTP request is the following:

1. A line stating foundational information including the request type and the HTTP version being used.
	- This is generally a GET, POST, PUT, or DELETE request.
	- HTTP versions such as 1.0, 1.1, 2.X, 3.X... big difference between 1.1 and 1.0 is the availability of the Keep-Alive option in the header to allow for re-use of a TCP handshake.
2. Request headers that include important metadata of the request including the content type, origin, etc.
3. The request body that might include a specified payload or additional information in regards to the request. Generally, this is limited to `PUT`, `POST`, and `PATCH` requests.

- The general format of an HTTP Response is as follows:

1. A line stating foundational information including the HTTP version and the response status code.
	- Each status code corresponds to a different outcome and may describe how the request was processed (i.e. 200 = OK)
2. A response header that inludes metadata such as the content type and length.
3. A response body that includes payload and other information. Status codes `201` CREATED and `204` NO CONTENT may omit this portion.

Reference: https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Overview

### HTTP Methods

These are action verbs that tell the general intent of what a request is trying to do.

- A `GET` request generally is used solely for retrieving information, and is generally the most common.
- A `POST` request is for the creation of new data.
- A `PUT` request is for the editing of existing data.
- A `DELETE` request is for the deltion of data.

There are more requests, but these are the most common. Some others you may see are:
 - `OPTION` - gets data in regards to what requests are available at the endpoint.
 - `HEAD` - gets only the metadata (header) from a GET request, omitting the body.
 - `PATCH` - Similar to a `PUT` request but generally on a much smaller scale.

Reference: https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods

### HTTP Response Codes

These signify a specific handling of an HTTP request and the leading digits 1-5 indicated a general outcome.
- **1XX** response codes indicate a purely informational response.
	- **100** CONTINUE - the client should continue what they are doing or ignore if their request has been completed.
	- **103** EARLY HINTS - the server is preparing a response, in the meantime, preload some resources so the client is ready.
- **2XX** response usually indicate a success.
	- **200** OK - indicates that everything went well and any transactions were successful.
	- **201** COMPLETED - indicates some resource transaction was completed, usually after a `PUT` or `POST`.
	- **204** NO CONTENT - indicates a transactional success, but there isn't really any body to send back.
- **3XX** response is a redirection, either for a temporary or permanent outage of the endpoint.
	- **301** MOVED PERMANENTLY - the endpoint requested has relocated to a new URL provided in the response body.
	- **307** TEMPORARY REDIRECT - the endpoint is temporarily relocated to the URL provided in the Location header.
	- **308** PERMANENT REDIRECT - the endpoint is permanently relocated to the URL provided in the Location header, and the request method cannot change.
- **4XX** response is an error that the client needs to resolve
	- **401** UNAUTHORIZED - response when the client does not provide authentication in the headers for a resource the requires authentication.
	- **403** FORBIDDEN - response when the client provides authentication, but the authentication is not at a high enough level to access the given resource. 
	- **404** NOT FOUND - the client is attempting to access a resource or endpoint that does not exist.
- **5XX** response is an error that the server needs to resolve
	- **500** INTERNAL SERVER ERROR - a general server error, generally given for obfuscational security reasons.
	- **504** GATEWAY TIMEOUT - the request timed out, could be due to heavy loads.

Reference: https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status

### RESTful APIs

 - RESTful (Representational State Transfer) APIs are web APIs that build off of HTTP requests. They take a request type, endpoint, and process it to return a response.

 - They have six main constraints in terms of behavioral principles:
1. **Uniform Interfaces** - Endpoints should have a unique identifier that a client is able to access via an HTTP request. The server should also provide descriptive metadata to the client.
2. **Client-Server Separation** - The client and server should be developed independently, but in parallel with one another. This decoupling allows for the abstraction of how the server operates (i.e. architecture). Client is generally treated as anonymous, and the client is only exposed to the server via the unifrom endpoints.
3. **Statelessness** - The server should treat each request the same way. This means no memory of state, so each request made to an endpoint needs to be complete with necessary resources such as authentication. The server itself does not handle persistant data - either transferred to the client or a backend database.
4. **Layered** - If a server is designed with multiple layers, they remain invisible to the client as they only have endpoints. These may include security, load balancing, sharded databases, etc. The client should only be able to access the frontloaded endpoint.
5. **Cacheability** - Responses should support a format the is able to be cached. This includes implementing things like staleness and more generally, cache control.
6. **Code on Demand** - The server should have the functionality to delegate server-side code onto. This is optional and generally considered bad practice due to the security risks it can bring.

### Best Practices

1. HTTP request type should dictate the action, URL should dictate the request target.
 - Do not conflate the two (i.e. putting action in URL as this is redundant).
 - It's okay to have multiple handlers for different request types at the same endpoint.
2. URLs should follow a logical hierarchal structure that increases in specificity going left to right.
 - Something like https://myapi.com/movies/123/release-info/year
3. API should support versioning, done directly within the URL.
 - Maintains backwards compatability.
 - Something like https://myapi.com/v1/movies/123/release-info/year
4. API should support filtering, done using query parameters in the form `?key=value`.
 - Something like https://myapi.com/v1/movies?release_year=2020
5. API should be documented including endpoints, allowed request methods, response structure, etc.
 - Example documentation tool: SwaggerHub.