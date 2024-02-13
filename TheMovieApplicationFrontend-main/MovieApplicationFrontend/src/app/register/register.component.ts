import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth-service/auth.service';
import { User } from 'src/app/User';
import { ToastService } from '../toast.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  successMessage: string = ""

  regForm!: FormGroup

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router, public toastService: ToastService) { }

  ngOnInit(): void {
    this.regForm = this.fb.group({
      'userName': new FormControl(null, Validators.required),
      'mobileNumber': new FormControl(null, [Validators.required, Validators.min(1000000000), Validators.max(9999999999)]),
      'userEmail': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)])
    })

  }

  registerSuccess() {
    this.toastService.show('Registered Successfully', { classname: 'bg-success text-light', delay: 2000 });
  }

  onSubmit(regForm: FormGroup) {
    this.authService.register(this.regForm.value).subscribe(
      data => {
        console.log(data);
        this.registerSuccess();
        // alert('Successfully Registered');
        this.ngOnInit();
      }
    );

  }

}
