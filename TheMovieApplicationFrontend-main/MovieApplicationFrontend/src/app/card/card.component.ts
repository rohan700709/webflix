import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { error } from 'protractor';
import { DialogForPlaylistComponent } from '../dialog-for-playlist/dialog-for-playlist.component';
import { MovieFields } from '../MovieFields';
import { MovieList } from '../MovieList';
import { BookmarkService } from '../service/bookmark-service/bookmark.service';
import { MovieDetailsService } from '../service/movie-details.service';
import { PlaylistServiceService } from '../service/playlist-service/playlist-service.service';
import { SearchmovieService } from '../service/search-service/searchmovie.service';
import { SharedService } from '../service/shared.service';
import { TrendingService } from '../service/trending-service/trending.service';
import { ToastService } from '../toast.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  constructor(private trendingService: TrendingService, private playlistService: PlaylistServiceService, private shared: SharedService,
    private bookmarkService: BookmarkService, public dialog: MatDialog, private router: Router, private searchMovieService: SearchmovieService, private movieDetails: MovieDetailsService, public toastService: ToastService) { }

  listOfPlaylistName: any;
  playlistName: any;
  movieLists!: MovieList;
  movieFields!: MovieFields;

  showFiller = false;
  page = 4;
  api = "f0b8ff1e014b06b9e1f05171ae747fbe"
  pCount = 0;
  ngOnInit(): void {
    this.getTrending();
  }



  search: string;

  IMG_URL = "https://image.tmdb.org/t/p/w500";
  backdrop = "https://image.tmdb.org/t/p/original"

  searchMovies() {
    this.searchMovieService.getData(this.search).subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists)
    }, (error) => {
      console.log(error);

    })
  }

  getMovieById(i: any) {
    console.log(i)

    const tempList = this.movieLists.movieList;
    this.movieFields = tempList[i];
    console.log(this.movieFields.id);

    this.movieDetails.getMovieByID(this.movieFields.id).subscribe(data => {
      this.movieFields = data;
      console.log(this.movieFields);
    })
    this.shared.setMessage(this.movieFields);
  }
  showSuccess() {
    this.toastService.show('Added Successfully', { classname: 'bg-success text-light', delay: 2000 });
  }

  addBookmark(i: any) {

    console.log(i);

    const tempList = this.movieLists.movieList;
    const movie = tempList[i];

    const userEmail = sessionStorage.getItem('userEmail');

    this.bookmarkService.addMovieToBookmark(movie, userEmail).subscribe(

      response => {
        console.log("response " + response);
      },

      error => {
        console.log("error" + error);
      }
    );
    this.router.navigate(['/bookmark'])
      .then(() => {
        // window.location.reload();
      })

    this.showSuccess()

  }


  getTrending() {
    this.trendingService.getTrendingMovies().subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    });
  }
  getNowPlaying() {
    this.trendingService.getNowPlayingMovies().subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    });
  }

  getPopular() {
    this.trendingService.getPopularMovies().subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    });
  }

  getUpcoming() {
    this.trendingService.getUpcomingMovies().subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    });
  }

  getTopRated() {
    this.trendingService.getTopRatedMovies().subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    });
  }

  getColor(vote: any) {
    if (vote >= 8) {
      return 'green'
    }
    else if (vote >= 5) {
      return 'orange'
    }
    else {
      return 'red'
    }
  }


  addPlaylist(playlistName: any, i: any) {
    console.log(playlistName);

    const tempList = this.movieLists.movieList;
    const movie = tempList[i];

    const userEmail = sessionStorage.getItem('userEmail');


    this.playlistService.addMovieToPlaylist(movie, userEmail, playlistName).subscribe(

      response => {
        console.log("response " + response);
      },

      error => {
        console.log("error");
      }
    );
    // this.router.navigate(['playlist'])
    //   .then(() => {
    //     window.location.reload();
    //   })
  }


  pageOne() {
    this.pCount = 1;
    this.trendingService.getPagination(this.pCount).subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    })
  };
  pageTwo() {
    this.pCount = 2;
    this.trendingService.getPagination(this.pCount).subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    })
  };
  pageThree() {
    this.pCount = 3;
    this.trendingService.getPagination(this.pCount).subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    })
  };
  pageFour() {
    this.pCount = 4;
    this.trendingService.getPagination(this.pCount).subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    })
  };
  pageFive() {
    this.pCount = 5;
    this.trendingService.getPagination(this.pCount).subscribe(data => {
      this.movieLists = data;
      console.log(this.movieLists);
    })
  };


  openDialog(movie: any) {
    var playlist: any[]
    const dialogRef = this.dialog.open(DialogForPlaylistComponent, {
      width: "350px",
      height: "250px",
      data: movie,

    })

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.playlistName = result;
    });

  }


  addToPlaylist(i: any) {

    const tempList = this.movieLists.movieList;
    const movie = tempList[i];
    this.openDialog(movie);

  }

  loggedIn() {
    return localStorage.getItem('token');
  }


}
