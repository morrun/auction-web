import { Component, OnInit } from '@angular/core';
import {User} from '../../../shared/models/user';
import {AuthService} from '../../../shared/services/auth.service';
import {UpLoadImageComponent} from './up-load-image/up-load-image.component';
import {MatBottomSheet} from '@angular/material';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  user: User;
  options: FormGroup;
  constructor(
    private authS: AuthService,
    private bottomSheet: MatBottomSheet,
    fb: FormBuilder
  ) {
    this.options = fb.group({
      hideRequired: false,
      floatLabel: 'auto',
    });
  }
  openBottomSheet(): void {
    this.bottomSheet.open(UpLoadImageComponent);
  }
  ngOnInit() {}


}
