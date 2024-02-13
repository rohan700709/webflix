import { MovieFields } from "./MovieFields";
export class MovieList {
    page: number = 0;
    total_results: number = 0;
    total_pages: number = 0;
    movieList: MovieFields[];

    constructor(movieList: MovieFields[]) {
        this.movieList = movieList;
    }
}