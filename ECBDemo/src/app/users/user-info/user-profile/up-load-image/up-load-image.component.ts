import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MatBottomSheetRef} from '@angular/material';
import {UserProfileComponent} from '../user-profile.component';
import {ImageServiceService} from '../../../../shared/services/images/image-service.service';

@Component({
  selector: 'app-up-load-image',
  templateUrl: './up-load-image.component.html',
  styleUrls: ['./up-load-image.component.scss']
})
export class UpLoadImageComponent implements OnInit {


  constructor(
    private bottomSheetRef: MatBottomSheetRef<UserProfileComponent>,
    private imageService: ImageServiceService
  ) { }
  onFileSelected(event) {
    this.imageService.userImage = event.target.files[0];

  }
  ngOnInit() {
  }
  openLink(event: MouseEvent): void {
    this.bottomSheetRef.dismiss();
    event.preventDefault();
  }
}
