import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../service/user-service/user.service';
import { User } from '../User';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  isDisplay = false;
  userData!: FormGroup;
  constructor(private userService : UserService, private fb:FormBuilder) { }

  user : User;
  ngOnInit(): void {
    this.getUserDetails();
    this.userData=this.fb.group({
      'userName': new FormControl(null,Validators.required),
      'password': new FormControl(null,Validators.required)

    })
  }
  
  toggleDisplay() {
    this.isDisplay = !this.isDisplay;
  }

  getUserDetails(){
    const userEmail = sessionStorage.getItem('userEmail');

    this.userService.getUser(userEmail).subscribe(
      response=>{
        this.user=response;
        console.log(response);
      },
      error=>{
        console.log(error);
      }
    )
  }

  onSubmit(userData:FormGroup){
    const userEmail = sessionStorage.getItem('userEmail');
    this.userService.updateUser(this.user, userEmail).subscribe(
      data=>{
         alert("Updated Successfully");
         this.ngOnInit();
      }, error=>console.log(error));
 
   }
}
