import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../../User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  
  constructor(private httpClient : HttpClient) { }
  private registerURL : string = "http://localhost:8084/api/v1/user";
  private loginURL : string = "http://localhost:8086/login";

  


  register(user : User) : Observable<Object>{
    return this.httpClient.post(this.registerURL, user);
  }
 

  generateToken(tokenvalue : any): Observable<Object>{
    return this.httpClient.post(this.loginURL, tokenvalue);
  } 

  loginUser(token: any){
    
    localStorage.setItem("token", token)
    return true;
  }

 



  logout(){

    localStorage.removeItem('token')
    return true;
  }


}

