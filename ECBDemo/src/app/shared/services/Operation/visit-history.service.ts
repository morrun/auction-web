import { Injectable } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VisitHistory} from '../../models/visit-history';
import {Visitation} from '../../models/visitation';

@Injectable({
  providedIn: 'root'
})
export class VisitHistoryService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }
  getAllVisitHistory(): Observable<VisitHistory[]> {
    return this.http.get<VisitHistory[]>(`${this.AUTH_API_URL}/visitHistory`);
  }
  addVisitHistory(productId: number, userId: number): Observable<{success: boolean}> {
    let vh: VisitHistory = new VisitHistory();
    vh.visitation = new Visitation();
    vh.productId = productId;
    vh.visitation.userId = userId;
    return this.http.post<{success: boolean}>(`${this.AUTH_API_URL}/visitHistory`, vh);
  }
}
