import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PlaylistServiceService } from '../service/playlist-service/playlist-service.service';

@Component({
  selector: 'app-dialog-for-playlist',
  templateUrl: './dialog-for-playlist.component.html',
  styleUrls: ['./dialog-for-playlist.component.css']
})
export class DialogForPlaylistComponent implements OnInit {

  value : boolean = false;
  constructor(@Inject(MAT_DIALOG_DATA) public data : any,
  private dialogRef: MatDialogRef<DialogForPlaylistComponent>, private playlistService : PlaylistServiceService,
  private router : Router)  { }

  playlist : any = this.data;
  listOfPlaylistName : any;

  newPlaylist : string;

  ngOnInit(): void {
    this.getPlaylist();
  }


  createPlaylist(){
    this.value= true;
  }

  addNewPlaylist(){
    const userEmail = sessionStorage.getItem('userEmail');
    console.log(userEmail);
    this.playlistService.createNewPlaylist(userEmail,this.newPlaylist).subscribe(
      response=>{
        console.log(response);
        this.ngOnInit();
      },
      error=>{
        console.log(error);
      }
    )
  }

   getPlaylist() {
    
    const userEmail = sessionStorage.getItem('userEmail');
    console.log(userEmail);

    this.playlistService.getPlaylistName(userEmail).subscribe(
      response => {
        console.log(response);
        this.listOfPlaylistName = response;
        console.log(response);
     },
      error => {
        console.log(error);
      }
    )

    

}


addToPlaylist(i : any){
  const userEmail = sessionStorage.getItem('userEmail');

const playlistName = this.listOfPlaylistName[i];

    this.playlistService.addMovieToPlaylist(this.data, userEmail, playlistName).subscribe(

      response => {
        console.log("response " + response);
        this.router.navigate(['playlist'])
        .then(() => {
        window.location.reload();
      })
      },

      error => {
        console.log("error");
      }
    );
    


  }
}