// App.tsx
import { moviesApi } from "./apis/moviesApi.ts";

export default function App() {
    const { data: movies, refetch } = moviesApi.useFindAllMoviesQuery();

    // const [trigger, result] = movieApi.useLazyFindAllMoviesQuery();

    return (
        <>
            {movies?.map((e) => {
                return (<h3>{e.title}</h3>);
            })}
        </>
    );
}