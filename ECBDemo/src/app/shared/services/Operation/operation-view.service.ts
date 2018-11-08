import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {OperationView} from '../../models/operation-view';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OperationViewService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }
  getOperationViewBySellerUserId(id: number): Observable<OperationView[]> {
    return this.http.get<OperationView[]>(`${this.AUTH_API_URL}/operationViews/seller/${id}`);
  }
  upadateOperationView(opV: OperationView): Observable<{success: boolean}> {
    return this.http.put<{success: boolean}>(`${this.AUTH_API_URL}/operationViews/seller`,opV, {withCredentials: true});
  }
  getOperationViewByBuyerUserId(id: number): Observable<OperationView[]> {
    return this.http.get<OperationView[]>(`${this.AUTH_API_URL}/operationViews/seller/${id}`);
  }
}
