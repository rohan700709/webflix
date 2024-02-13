import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  helper = new JwtHelperService();
  role: string = '';
  constructor() { }

  ngOnInit(): void {

    this.roles();
  }

  loggedIn() {
    return localStorage.getItem('token');
  }

  logOut() {
    return localStorage.removeItem('token');
  }

  roles() {
    const token = localStorage.getItem('token')
    const decodedToken = this.helper.decodeToken(token);
    this.role = decodedToken.sub;
    console.log(this.role);
  }

}
