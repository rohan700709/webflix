import { Injectable } from '@angular/core';
import { MovieFields } from '../MovieFields';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  movieFields: MovieFields;
  constructor() { }

  setMessage(data: MovieFields) {
    this.movieFields = data;
  }

  getMessage() {
    return this.movieFields;
  }
}
