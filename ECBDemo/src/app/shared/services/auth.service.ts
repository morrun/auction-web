import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {BehaviorSubject, Observable, Subject, throwError} from 'rxjs';
import {User} from '../models/user';
import {catchError, map} from 'rxjs/internal/operators';
import {UserDetail} from '../models/user-detail';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  AUTH_API_URL = `${environment.API_URL}`;
  userSubject: Subject<User> = new BehaviorSubject<User>(null);
  status: boolean;
  constructor(
    private http: HttpClient
  ) {
    this.checkLogin();

  }

  checkLogin() {
    this.http.get(`${this.AUTH_API_URL}/checkLogin`, {withCredentials: true})
      .subscribe((res: {success: boolean, user: User}) => {
        if (res.success) {
          this.userSubject.next(res.user);
        }
      });
  }
  login(user: User): Observable<{success: boolean, user: User}> {
    const httpParams: HttpParams = new HttpParams()
      .append('username', user.username)
      .append('password', user.password);
    return this.http.post<{success: boolean, user: User}>(`${this.AUTH_API_URL}/login`, httpParams, {withCredentials: true})
      .pipe(
        map((res: {success: boolean, user: User}) => {
          this.userSubject.next(res.user);
          return res;
        })
      );
  }
  register(user: User): Observable<{success: boolean}> {
    return this.http.post<{success: boolean, user: User}>(`${this.AUTH_API_URL}/users`, user);
  }
  logout(): Observable<{success: boolean}> {
    return this.http.post<{success: boolean}>(`${this.AUTH_API_URL}/logout`, null, {withCredentials: true});
  }
  private handleError(error: HttpErrorResponse) {
    return throwError(`${error.error}`);
  }
  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.AUTH_API_URL}/users`);
  }
  updateUserDetail(userDetails: UserDetail): Observable<{success: boolean}>{
    return this.http.put<{success: boolean}>(`${this.AUTH_API_URL}/userDetails`, userDetails);
  }
  getUserDetail(id: number): Observable<UserDetail> {
    return this.http.get<UserDetail>(`${this.AUTH_API_URL}/userDetails/${id}`);
  }
  checkPassword(id: number, password: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.AUTH_API_URL}/users/${id}`, password,{withCredentials: true});
  }
  changePassword(id: number, password: string): Observable<{success: boolean}> {
    console.log(id, password);
    return this.http.post<{success: boolean}>(`${this.AUTH_API_URL}/users/changePassword/${id}`, password,{withCredentials: true});
  }
}
