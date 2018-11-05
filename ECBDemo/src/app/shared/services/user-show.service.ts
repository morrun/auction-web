import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserShowService {
  showHome = true;
  userId: number;
  constructor() { }
}
