import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImageServiceService {
  userImage: File;
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(private http: HttpClient) { }

  pushFileToStorage(file: File,id: number): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('file', file);

    const req = new HttpRequest('POST', `${this.AUTH_API_URL}/productImage/${id}`, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }
  pushFileToUserStorage(file: File, id: number): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);

    const req = new HttpRequest('POST', `${this.AUTH_API_URL}/imageUser/${id}`, formdata, {
          reportProgress: true,
          responseType: 'text',
      withCredentials: true
        });
        return this.http.request(req);
    // return this.http.post<HttpEvent<{}>>(`${this.AUTH_API_URL}/userDetails/${id}`, formdata);
  }
}
