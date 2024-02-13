import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovieFields } from '../MovieFields';

@Injectable({
  providedIn: 'root'
})
export class MovieDetailsService {

  private backendURL = "http://localhost:8089/movieService";
  constructor(private httpClient: HttpClient) { }

  getMovieByID(id: number): Observable<MovieFields> {
    return this.httpClient.get<MovieFields>(`${this.backendURL}/${id}`)
  }

}
