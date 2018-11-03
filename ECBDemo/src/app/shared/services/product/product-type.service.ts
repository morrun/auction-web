import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductType} from '../../models/product-type';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }
  getAllProductTypes(): Observable<ProductType[]> {
    return this.http.get<ProductType[]>(`${this.AUTH_API_URL}/productTypes`);
  }
}
