import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ShelvesProduct} from '../../models/shelves-product';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OnShelvesService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }
  getAllShelvesData(): Observable<ShelvesProduct[]> {
    return this.http.get<ShelvesProduct[]>(`${this.AUTH_API_URL}/shelvesProducts`);
  }
  getShelvesByProductId(id: number): Observable<ShelvesProduct> {
    return this.http.get<ShelvesProduct>(`${this.AUTH_API_URL}/shelvesProducts/${id}`);
  }
  addShelvesProduct(shelveProduct: ShelvesProduct): Observable<{success: boolean}> {
    return this.http.post<{success: boolean}>( `${this.AUTH_API_URL}/shelvesProducts`, shelveProduct);
  }
  getShelvesByUserId(id: number): Observable<ShelvesProduct[]> {
    return this.http.get<ShelvesProduct[]>(`${this.AUTH_API_URL}/shelvesProducts/user/${id}`);
  }
  getRemainTimeByProductId(id: number): Observable<number> {
    return this.http.get<number>(`${this.AUTH_API_URL}/shelvesProducts/remainTime/${id}`);
  }
}
