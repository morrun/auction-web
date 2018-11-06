import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductImage} from '../../models/product-image';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductImageService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }

  getAllImage(): Observable<ProductImage[]> {
    return this.http.get<ProductImage[]>(`${this.AUTH_API_URL}/productImage`);
  }
  getImagesByProductId(id: number): Observable<ProductImage[]> {
    return this.http.get<ProductImage[]>(`${this.AUTH_API_URL}/productImage/${id}`);
  }
}
