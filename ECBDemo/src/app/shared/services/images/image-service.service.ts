import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageServiceService {
  public userImage: Blob;
  constructor() { }
}
