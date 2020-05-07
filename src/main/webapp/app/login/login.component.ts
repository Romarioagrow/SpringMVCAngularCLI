import {Component, isDevMode, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient, private router: Router) {}

  userCreatedSuccessfully: boolean = false;
  loginError: boolean = false;
  errorMessage: string = '';

  userObject: object = {}

  userInfo: object = {};
  username: string = '';
  password: string = '';
  auth: boolean = false;

  ngOnInit(): void {
    this.checkAuthentication();
  }

  createAdmin() {
    this.authApi('api/auth/createAdmin')
  }

  createUser() {
    this.authApi('api/auth/createUser')
  }

  checkAuth() {
    this.authApi('api/auth/checkAuth')
  }

  doLogin() {
    this.loginApi();
  }

  private loginApi() {
    this.loginError = false
    this.userCreatedSuccessfully = false

    const apiUrl = 'api/auth/login';
    let url = isDevMode() ? 'http://localhost:8080/app-cli/' + apiUrl : apiUrl
    console.log('authApi url: ' + url)

    const loginForm: object = {};
    loginForm['username'] = this.username;
    loginForm['password'] = this.password;

    this.http.post(url, loginForm,
      {
        observe: 'response',
        headers: {
          'Content-Type': 'application/json'
        }
      }).subscribe(
        response =>
      {
        const status = response.status
        console.log(status)

        switch (status) {
          case 202 : {
            /// this.router.navigate(['/admin']);
            window.location.href = 'admin'
            break;

          }
          case 200 : {
            /// this.router.navigate(['/user'])
            window.location.href = 'user'
            break;
          }
          default : {
            /// any error
            console.log('any error')
            this.loginError = true;
            this.errorMessage = response.statusText
            break;
          }
        }
      },
        err => {
          console.log('err error')
          this.loginError = true;
          this.errorMessage = 'Incorrect Credentials!'
        })
  }

  authApi(apiUrl) {
    console.log('authApi')
    this.loginError = false;

    let url = isDevMode() ? 'http://localhost:8080/app-cli/' + apiUrl : apiUrl
    console.log('authApi url: ' + url)

    this.http.post(url,{
      headers: {'Access-Control-Allow-Origin':'*'}
    }).subscribe(data => {
      console.log(data);

      if (data) {
        console.log(data)
        this.userCreatedSuccessfully = true;
        this.userInfo = data;
      }
      else
      {
        this.loginError = true
        this.errorMessage = 'NO USER!'
      }
    });
  }

  logout() {
    console.log('Logout')
    window.location.href = 'logout'
  }

  private checkAuthentication() {
    console.log('checkAuthentication')

    let apiUrl = 'api/auth/checkAuthentication'
    let url = isDevMode() ? 'http://localhost:8080/app-cli/' + apiUrl : apiUrl
    console.log('authApi url: ' + url)

    this.http.post(url,{
      headers: {'Access-Control-Allow-Origin':'*'}
    }).subscribe(data => {
      console.log(data);
      if (data) {
        this.auth = true
        this.userObject = data
      }
    });


  }
}
