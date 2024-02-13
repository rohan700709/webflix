import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovieList } from '../../MovieList';

@Injectable({
  providedIn: 'root'
})
export class TrendingService {

  private backendURL = "http://localhost:8083/movieService";

  popular = "/popular";
  upcoming = "/upcoming";
  nowPlaying = "/now_playing";
  trending = "/trending";
  toprated = "/top_rated";
  url = "https://api.themoviedb.org/3/movie/popular?api_key=f0b8ff1e014b06b9e1f05171ae747fbe&page=";

  constructor(private httpClient: HttpClient) { }

  getPopularMovies(): Observable<MovieList> {
    return this.httpClient.get<MovieList>(`${this.backendURL}${this.popular}`)
  }

  getUpcomingMovies(): Observable<MovieList> {
    return this.httpClient.get<MovieList>(`${this.backendURL}${this.upcoming}`)
  }

  getTopRatedMovies(): Observable<MovieList> {
    return this.httpClient.get<MovieList>(`${this.backendURL}${this.toprated}`)
  }

  getNowPlayingMovies(): Observable<MovieList> {
    return this.httpClient.get<MovieList>(`${this.backendURL}${this.nowPlaying}`)
  }

  getTrendingMovies(): Observable<MovieList> {
    return this.httpClient.get<MovieList>(`${this.backendURL}${this.trending}`)
  }

  getPagination(page: number): Observable<MovieList> {
    return this.httpClient.get<MovieList>(`${this.url}${page}`)
  }
}
