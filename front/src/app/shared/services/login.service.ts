import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({providedIn: 'root'})
export class LoginService {

  constructor(private http: HttpClient) {
  }

  login(credentials): Observable<any> {
    console.log(credentials);
    const data = {
      email: credentials.email,
      password: credentials.password,
      rememberMe: credentials.rememberMe
    };
    return this.http.post('api/authenticate', data, {observe: 'response'})
      .pipe(
        map(response => response.body));
  }
}
