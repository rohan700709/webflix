import { Component, OnInit, Input } from '@angular/core';
import { MovieFields } from '../MovieFields';
import { SharedService } from '../service/shared.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  constructor(private shared: SharedService) { }

  ngOnInit(): void {
    this.data = this.shared.getMessage()

  }


  posterPath = "https://image.tmdb.org/t/p/w300";
  backdropPath = "https://image.tmdb.org/t/p/original";
  data: MovieFields;

  getData() {
    this.data = this.shared.getMessage()
  }



}
