import type { Movie } from "../types/Movies";

interface MovieProps {
    movie: Movie
}

export default function Movie({ movie }: MovieProps) {
    return (
        <>
            <h2>{movie.title}</h2>
            <h4>{`Rating: ${movie.rating}`}</h4>
            <h4>{`Director: ${movie?.director?.firstName} ${movie?.director?.lastName}`}</h4>
            <hr />
        </>
    )
}