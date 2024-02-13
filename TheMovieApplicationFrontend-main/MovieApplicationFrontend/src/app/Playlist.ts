import { MovieList } from "./MovieList";

export class Playlist{
    playlistId : number = 0;;
    playlistName :String = "";
    movieList : MovieList[];

    constructor(movieList: MovieList[]) {
        this.movieList = movieList;
    }
}