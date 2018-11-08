import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {ObjectUnsubscribedError, Observable} from 'rxjs';
import {Product} from '../../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.AUTH_API_URL}/products`);
  }

  getProductsByIdList(id: number[]): Observable<Product[]> {
    return this.http.post<Product[]>(`${this.AUTH_API_URL}/products-list`,id);
  }
  getProductsById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.AUTH_API_URL}/products/${id}`);
  }
  addProduct( product: Product): Observable<number> {
    return this.http.post<number>(`${this.AUTH_API_URL}/products`, product);
  }
  updateProduct(id: number, product: Product): Observable<{success: boolean}> {
    return this.http.put<{success: boolean}>(`${this.AUTH_API_URL}/products/${id}`, product,{withCredentials: true});
  }
}
