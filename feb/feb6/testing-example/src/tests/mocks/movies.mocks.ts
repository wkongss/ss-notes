import type { Movie } from "../../types/Movies.ts";

export const mockMoviesList: Movie[] = [
    {
        id: 2,
        title: "Shawshank Redemption",
        rating: 9,
        director: {
            firstName: "Frank",
            lastName: "Darabont"
        }
    },
    {
        id: 3,
        title: "The Room",
        rating: 2,
        director: {
            firstName: "Tommy",
            lastName: "Wise-O"
        }
    }
];

export const mockMovie: Movie = {
    id: 1,
    title: "Avatar",
    rating: 8,
    director: {
        firstName: "James",
        lastName: "Cameron"
    },
};

export const noDirectorMockMovie: Movie = {
    id: 1,
    title: "Avatar",
    rating: 8,
};