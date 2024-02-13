
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieFields } from '../MovieFields';
import { MovieList } from '../MovieList';
import { BookmarkService } from '../service/bookmark-service/bookmark.service';
import { ToastService } from '../toast.service';

@Component({
  selector: 'app-bookmark',
  templateUrl: './bookmark.component.html',
  styleUrls: ['./bookmark.component.css']
})
export class BookmarkComponent implements OnInit {

  movieList = true;
  movieLists!: MovieList;
  IMG_URL = "https://image.tmdb.org/t/p/w500";
  movieDetails: any = [];

  movie: MovieFields;
  constructor(private bookmarkService: BookmarkService, private router: Router, public toastService: ToastService) { }

  ngOnInit(): void {

    this.getBookmark();
    // 
  }


  getBookmark() {

    const bookmarkName = "bookmark1";
    const userEmail = sessionStorage.getItem('userEmail');

    this.bookmarkService.getMovieFromBookmark(bookmarkName, userEmail).subscribe(
      response => {
        this.movieList = false;
        this.movieDetails = response;
        console.log(response);
        console.log(this.movieDetails);
      },
      error => {
        console.log(error);
      }
    )

  }

  deletedSuccess() {
    this.toastService.show('Deleted Successfully', { classname: 'bg-success text-light', delay: 2000 });
  }

  deleteBookmark(i: any) {

    this.movie = this.movieDetails[i];
    console.log(this.movieDetails[i]);
    const id = this.movie.id;
    const userEmail = sessionStorage.getItem('userEmail');
    console.log(userEmail);
    this.bookmarkService.deleteMovieFromBookmark(id, userEmail).subscribe(
      () => {
        this.movieList = false;

      },
      error => {
        console.log(error);
      }
    )
    this.deletedSuccess();
    window.location.reload();
    this.router.navigate(['/bookmark']);

  }

}
