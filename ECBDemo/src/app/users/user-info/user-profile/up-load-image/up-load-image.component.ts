import { Component, OnInit } from '@angular/core';
import {MatBottomSheetRef} from '@angular/material';
import {UserProfileComponent} from '../user-profile.component';

@Component({
  selector: 'app-up-load-image',
  templateUrl: './up-load-image.component.html',
  styleUrls: ['./up-load-image.component.scss']
})
export class UpLoadImageComponent implements OnInit {
  selectedFill = null;
  constructor(private bottomSheetRef: MatBottomSheetRef<UserProfileComponent>) { }
  onFileSelected(event) {
    this.selectedFill = event.target.files[0];
    console.log(this.selectedFill);
  }
  ngOnInit() {
  }
  openLink(event: MouseEvent): void {
    this.bottomSheetRef.dismiss();
    event.preventDefault();
  }
}
