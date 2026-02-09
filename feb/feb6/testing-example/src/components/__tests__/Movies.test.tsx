import { render, screen } from "@testing-library/react";
import { describe, test, it, expect } from "vitest";
import { mockMovie, noDirectorMockMovie } from "../../tests/mocks/movies.mocks";
import Movie from "../Movie.tsx";

// Creates a test suite under a given name
// (i.e.) unit tests pertaining to a specific component
describe("Movies Component", () => {
    // Within our callback, use either test() or it()
    // to write tests.

    // Syntax: test(name, callback), it(name, callback)
    //
    test("elegantly handle movies without directors", () => {
        // Renders the component with mock data 
        render(<Movie movie={noDirectorMockMovie} />);
        
        expect(screen.getByText("Avatar"))
            .toBeInTheDocument();
    
        expect(screen.getByText("8"))
            .toBeInTheDocument();
    
        expect(screen.getByText("James Cameron"))
            .toBeInTheDocument();
    });
    
    // Generally used to describe behavior
    it("renders movie details", () => {
        render(<Movie movie={mockMovie} />);
        
        // Use expect() to create assertions
        expect(screen.getByText("Avatar"))
            .toBeInTheDocument();

        expect(screen.getByText("8"))
            .toBeInTheDocument();

        // expect(screen.getByText("James Cameron"))
        //     .tobe()
;
            
            // Paired with matchers of toBe/toHave/toThrow to read as natural language:
            // You expect X toBe Y
        });

        // Snapshots allow you to create a snapshot of the overall document at some point of time and compare it
        // to a some other 

        it("matches snapshot", () => {
                const { asFragment } = render(<Movie movie={mockMovie} />

                // Tests to match snapshot - if one doesn't exist, generates one
                expect(asFragment()).toMatchSnapshot().
            );
        });

    });