import { describe, vi, test, type Mock, beforeEach } from "vitest";
import { mockMoviesList } from "../tests/mocks/movies.mocks";
import { moviesApi } from "../apis/moviesApi";
import { render } from "@testing-library/react";
import App from "../App.tsx";

// Mock API calls in the components we're trying to test
// by telling Vitest to spoof/intercept them and return them with
// desired values
vi.mock("../apis/movieApi", () => {
    return {
        moviesApi: {
            useFindAllMoviesQuery: vi.fn(), // <- blank function
            useCreateMovieMutation: vi.fn()
        }
    }
});

describe("App Component", () => {
    beforeEach(() => {
        (moviesApi.useFindAllMoviesQuery as Mock).mockReturnValue({
            data: mockMoviesList,
            refetch: vi.fn()
        });
        
        (moviesApi.useCreateMovieMutation as Mock).mockReturnValue([
            vi.fn()
        ]);

    });

    test("renders movies from API", () => {
        render(<App />, )
    });
});