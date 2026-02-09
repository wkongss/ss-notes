export interface Movie {
    id: number,
    title: string,
    rating: number,
    director?: {
        firstName: string,
        lastName: string
    }
}