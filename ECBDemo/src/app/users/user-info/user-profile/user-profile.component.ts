import { Component, OnInit } from '@angular/core';
import {User} from '../../../shared/models/user';
import {AuthService} from '../../../shared/services/auth.service';
import {UpLoadImageComponent} from './up-load-image/up-load-image.component';
import {MatBottomSheet} from '@angular/material';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UserDetail} from '../../../shared/models/user-detail';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  user: User;
  info: FormGroup;
  err = false;
  constructor(
    private authS: AuthService,
    private bottomSheet: MatBottomSheet,
    private fb: FormBuilder,
    private router: Router
  ) {}
  openBottomSheet(): void {
    this.bottomSheet.open(UpLoadImageComponent);
  }
  ngOnInit() {
    this.info = this.fb.group({
      uname: ['',[Validators.required, Validators.minLength(5), Validators.maxLength(30)]],
      phone: ['',[Validators.required, Validators.pattern('^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$')]],
      address1: '',
      address2: '',
      city: ['',[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      state: ['',[Validators.required,Validators.minLength(2), Validators.maxLength(15)]],
      zip: ['', [Validators.required, Validators.pattern('^\\d{5}(?:[-\\s]\\d{4})?$')]]
    });
  }
  onSubmit(){
    if (this.info.valid) {
      const { uname, phone,address1, address2, city, state, zip} = this.info.value;
      this.authS.userSubject.subscribe( (res) => {
        this.user = res;
      })
      this.user.userDetail = new UserDetail();
      this.user.userDetail.name = uname;
      this.user.userDetail.phone = phone;
      this.user.userDetail.address1 = address1;
      this.user.userDetail.address2 = address2;
      this.user.userDetail.city = city;
      this.user.userDetail.state = state;
      this.user.userDetail.zip = zip;
      this.authS.updateUsers(this.user)
        .subscribe(res => {
          if (res.success) {
            this.router.navigate(['/users/user-profile']);
          } else {
            // show error text.
          }
        }, (err) => { // error handling
          this.err = true;
        });
    } else {
      return false;
    }
  }

}
