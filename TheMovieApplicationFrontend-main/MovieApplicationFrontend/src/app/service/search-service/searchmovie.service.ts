import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { MovieList } from 'src/app/MovieList';

const httpOptions = {
  headers: new HttpHeaders({
    // 'Authorization':'f0b8ff1e014b06b9e1f05171ae747fbe'
  })
}

@Injectable({
  providedIn: 'root'
})
export class SearchmovieService {

  private backendURL = "http://localhost:8081/movieService/search";

  constructor(private http: HttpClient) { }

  getData(search: string): Observable<MovieList> {
    return this.http.get<MovieList>(`${this.backendURL}/${search}`);
  }

  handleError(error: any) {
    return throwError(error.message || "server error");
  }
}
