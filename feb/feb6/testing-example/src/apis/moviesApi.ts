import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import type { Movie } from "../types/Movies";

export const moviesApi = createApi({
    reducerPath: "movies",
    baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/movies" }),
    endpoints: (builder) => ({
        findAllMovies: builder.query<Movie[], void>({
            query: () => ""
        }),

        findMovieById: builder.query<Movie, number>({
            query: (id) => `/id/${id}`
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