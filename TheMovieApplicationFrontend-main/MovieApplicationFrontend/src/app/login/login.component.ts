import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { AuthService } from 'src/app/service/auth-service/auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ActivatedRoute, Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { error } from 'protractor';
import { ToastService } from '../toast.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  successMessage: string = "";
  loginForm!: FormGroup;
  role: string = "";
  helper = new JwtHelperService();
  email: string = "";

  alertify: any;
  constructor(public toastService: ToastService, private fb: FormBuilder, private route: ActivatedRoute, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      'userEmail': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(5)])
    })
  }


  credentials = {

    userEmail: '',
    password: ''
  }

  loginSuccess() {
    this.toastService.show('Login Successfully', { classname: 'bg-success text-light', delay: 2000 });
  }
  onSubmit() {

    this.credentials.userEmail = this.loginForm.value.userEmail;
    this.credentials.password = this.loginForm.value.password;

    sessionStorage.setItem('userEmail', this.credentials.userEmail);

    this.authService.generateToken(this.credentials).subscribe((response: any) => {
      console.log(response);

      if (response.token) {
        // alert('Login successful');
        this.loginSuccess();
        console.log(response.token);
        this.authService.loginUser(response.token);
        const decodedToken = this.helper.decodeToken(response.token);
        this.role = decodedToken.sub;
        console.log(this.role);
        this.email = decodedToken.jti;     // for user email
        console.log(this.email);
        if (this.role == 'User') {
          console.log("In user page");
          this.router.navigate(['']);
        }
        else {
          console.log("admin");
          this.router.navigate(['admin-profile'])
            .then(() => {
              location.reload();
            })
        }
      }
    },
      error => {
        alert("Please check your credential");
        this.ngOnInit();
      })
  }


}
