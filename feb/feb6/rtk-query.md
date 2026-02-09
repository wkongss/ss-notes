### Redux Toolkit Query

This is a library and framework built around handling API calls that we've been manually calling the fetch API for. It organizes our calls into one place and provides accessors and mutators as well as a smart caching layer and automatically puts the data into the store.

### Creating APIs

The way we manage server calls and endpoints is uing the `API` object. To begin, we use `createAPI` and pass in an object with shape:
 - `reducerPath` - a name for our API (string)
 - `baseQuery` - a base URL for the endpoint. To get it, use the `fetchBaseQuery({ baseUrl: "..."})`
 - `endpoints` - a function that takes in a builder parameter and returns and object containing functions that correspond to each endpoint. Each field should have their value be the result of a `query` or `mutation` builder.

#### Building Queries

To build an endpoint URL, we use a `builder` to create complex classes. We can choose one of two builders:

`builder.query<resT, reqT>()`
 - Used for `GET` requests
 - Pass in the types for the response and the request as generics.
 - Within the function parameters, pass in an object with the field `query` set to the specific endpoint (after the `baseURL`). For the `baseURL` itself, use `""`.
 - Lastly, pass in an object with a `query` field defined as a function with any parameters matching the `reqT` such as a numeric `id` and returning the endpoint location after the base URL such as `/id/${id}`.

`builder.mutation<resT, reqT>()`
 - Used for `POST, PUT, DELETE` requests (anything that writes data)
 - Pass in the types for the response and the request as generics.
 - Within the function parameters, pass in an object with the field `query` set to the specific endpoint (after the `baseURL`). For the `baseURL` itself, use `""`.
 - Lastly, pass in an object with a `query` field defined as a function with any `parameters` of type `reqT`. Then, return an object with fields `url` for the endpoint URL, `method` for the HTTP method, and `body` for the HTTP body.

```TSX
import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import type { Movie } from "../types/Movies";

export const moviesApi = createApi({
    reducerPath: "movies",
    baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/movies/" }),
    endpoints: (builder) => ({
        findAllMovies: builder.query<Movie[], void>({
            query: () => ""
        }),

        findMovieById: builder.query<Movie, number>({
            query: (id) => `id/${id}`
        }),

        createMovie: builder.mutation<Movie, Movie>({
            query: (newMovie) => {
                return {
                    url: "",
                    method: "POST",
                    body: newMovie
                }
            }
        })
    })
});
```

To create the associated store to our API, we can use the `reducer` path and `reducer` property of our API.

We're also able to define middleware for things between the request creation and request sending. To do so, pass in another object with the middleware property set to a function that takes in a default middleware. Then, use the `concat` function to concatenate our middleware function to the API.

```TS
//store.ts
import { configureStore } from "@reduxjs/toolkit";
import { movieApi } from "./apis/movieApi.ts";

const store = createStore({
    reducer: {
        [movieApi.reducerPath]: movieApi.reducer
    },

    middleware: (default) => default().concat(movieApi.logger)
});
```

Similarly, we must then pass in this store to our provider near the root of our application. Alternatively, use the `ApiProvider` component instead to automatically set up a store if you don't want to manually do so yourself.

Lastly, to use our URL, we call the custom hooks that the API object creates for us. These will be of the form `use<Endpoint Name>Query` and `useLazy<Endpoint Name>Query`. The difference is that `use` will make the request on mount, but `useLazy` will only call the request once the `trigger` method is called.

Likewise, for Mutations, replace the `Query` at the end of the hook with `Mutation`. Note you will need to use the `unwarp` method to get the actual promise.

```TSX
// App.tsx
import { movieApi } from "./apis/movieApi.ts";

export default function App() {
    // Refetch with intelligently refetch data (either from cache) or by making a new request.
    const { data: movies, refetch } = movieApi.useFindAllMoviesQuery();

    // const [trigger, result] = movieApi.useLazyFindAllMoviesQuery();

    const [createMovie] = movieApi.useCreateMovieMutation();

    async function handleSubmit() {
        const data = await createMovie().unwrap();
    }

    return (
        <>
            {movies?.map((e) => {
                return (<h3>{e.title}</h3>);
            })}
        </>
    );
}
```