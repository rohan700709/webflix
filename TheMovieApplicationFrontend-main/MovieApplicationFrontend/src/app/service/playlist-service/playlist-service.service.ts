import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { url } from 'inspector';
import { Observable } from 'rxjs';
import { MovieFields } from 'src/app/MovieFields';
import { MovieList } from 'src/app/MovieList';
import { Playlist } from 'src/app/Playlist';
import { User } from 'src/app/User';

@Injectable({
  providedIn: 'root'
})
export class PlaylistServiceService {

  constructor(private httpClient: HttpClient) { }

  private addPlaylistURL: string = "http://localhost:8082/api/v1/playlistservice/";

  addMovieToPlaylist(movie: any, userEmail: any, playlistName: any): Observable<Object> {
    return this.httpClient.post(this.addPlaylistURL + `${userEmail}` + '/' + `${playlistName}`, movie);
  }

  getMovie(playlistName: String, userEmail: any): Observable<Object> {
    return this.httpClient.get(this.addPlaylistURL + "playlist/" + `${userEmail}` + "/" + `${playlistName}`);
  }

  getPlaylistName(userEmail: any): Observable<Object> {
    return this.httpClient.get(this.addPlaylistURL + "playlist/" + `${userEmail}`);
  }

  createNewPlaylist(userEmail: any, playlistName: any): Observable<any> {
    return this.httpClient.post(this.addPlaylistURL + 'createNewPlaylist/' + `${userEmail}`, playlistName);

  }

  deletePlaylist(playlistName: any, userEmail: any): Observable<Object> {
    return this.httpClient.delete(this.addPlaylistURL + "playlist/" + `${userEmail}` + "/" + `${playlistName}`);
  }

  deleteMovieFromPlaylist(playlistName: any, userEmail: any, id: any): Observable<Object> {
    return this.httpClient.delete(this.addPlaylistURL + "movie/" + `${userEmail}` + "/" + `${playlistName}` + "/" + `${id}`);
  }

  getPlaylistCount(userEmail: any): Observable<number> {
    return this.httpClient.get<number>(this.addPlaylistURL + "playlist/count/" + `${userEmail}`);
  }


}
