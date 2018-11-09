import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {OperationHistory} from '../../models/operation-history';

@Injectable({
  providedIn: 'root'
})
export class BidOrBuyService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }

  addOperationService(oh: OperationHistory): Observable<any> {
    return this.http.post<any>(`${this.AUTH_API_URL}/operationsHistory`, oh);
  }
  getOperationsHistoryByProductId(id: number): Observable<OperationHistory[]> {
    return this.http.get<OperationHistory[]>(`${this.AUTH_API_URL}/operationsHistory/${id}`);
  }
}
