import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieFields } from '../MovieFields';
import { MovieList } from '../MovieList';
import { PlaylistServiceService } from '../service/playlist-service/playlist-service.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  listOfPlaylistName : any=[];
  movieList = true;
  movieLists!: MovieList;
  IMG_URL = "https://image.tmdb.org/t/p/w500";
  movieDetails : any=[];
  playlistName : string='';
  movie : MovieFields;
  constructor(private playlistService : PlaylistServiceService, private router : Router) { }

  ngOnInit(): void {

    this.getPlaylistNames();
  }

  deleteMovie(i : any){

    this.movie = this.movieDetails[i];
    console.log(this.playlistName);
    const id = this.movie.id;
    console.log(id);

    const userEmail = sessionStorage.getItem('userEmail');
    this.playlistService.deleteMovieFromPlaylist(this.playlistName, userEmail, id).subscribe(
      response=>{
        console.log(response);
        alert("successfully deleted");
        this.router.navigate(['/playlist'])
        .then(() => {
          window.location.reload();
        })
      },
      error=>{
        console.log(error);
        this.router.navigate(['/playlist'])
        .then(() => {
          window.location.reload();
        })
      }
    )

  }
  getMovieDetails(e : any){

    console.log("27");
    console.log(e);
    // const playlistName = this.listOfPlaylistName[e];
    
    const userEmail = sessionStorage.getItem('userEmail');

    this.playlistService.getMovie(e, userEmail).subscribe(
      response=>{
        console.log(response);
        this.movieList = false;
        this.movieDetails=response;
        console.log(response);
        console.log(this.movieDetails);
      },
      error=>{
        console.log(error);
      }
    );
    
  
  }

  getPlaylistNames(){
    this.playlistService.getPlaylistName(sessionStorage.getItem('userEmail')).subscribe(
      response => {
        this.listOfPlaylistName = response;
        console.log(response);
     },
      error => {
        return error;
      }
    )
  }

  deletePlaylistFromList(){
    console.log(this.playlistName);
    const userEmail = sessionStorage.getItem('userEmail');
    this.playlistService.deletePlaylist(this.playlistName,userEmail).subscribe(
      response=>{
        alert("successfully deleted");
        this.router.navigate(['/playlist'])
        .then(() => {
          window.location.reload();
        })

      },
      error=>{
        console.log(error);
        this.router.navigate(['/playlist'])
        .then(() => {
          window.location.reload();
        })
      }
     
      
    )
  }



  
 



}
