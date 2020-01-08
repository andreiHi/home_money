import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginService} from '../../shared/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.form = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, [Validators.required, Validators.minLength(5)]),
      rememberMe: new FormControl(false)
    });
  }

  onSubmit() {
    this.loginService.login({
      email: this.form.get('email').value,
      password: this.form.get('password').value,
      rememberMe: this.form.get('rememberMe').value
    }).subscribe(data => console.log(data));
  }

  register() {

  }
}
