import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookmarkService {

  constructor(private httpClient : HttpClient) { }

  private addBookmarkURL : string = "http://localhost:8085/api/v1/bookmarkservice/";
  private a : string = "bookmark/";

   addMovieToBookmark(movie : any, userEmail: any) : Observable<Object>{
    return this.httpClient.post(this.addBookmarkURL+`${userEmail}`, movie);
  }

  getMovieFromBookmark(bookmarkName : String, userEmail : any) : Observable<Object>{
    return this.httpClient.get(this.addBookmarkURL+"bookmark/"+`${userEmail}`+"/"+`${bookmarkName}`);
  }

  deleteMovieFromBookmark(id : number, userEmail: any) : Observable<Object>{
    // return this.httpClient.delete(this.addBookmarkURL+"bookmark/"+`${userEmail}`, movie);
    return this.httpClient.delete(`${this.addBookmarkURL}${this.a}${userEmail}`+"/"+`${id}`);
  }
}

// @DeleteMapping("api/v1/bookmarkservice/bookmark/{userEmail}")
// public ResponseEntity<?> deleteBookmark(@RequestBody Movie movie, @PathVariable String userEmail)
