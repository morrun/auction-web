import { Component, OnInit } from '@angular/core';
import {UserDetail} from '../../../shared/models/user-detail';
import {MatBottomSheet} from '@angular/material';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';

import {AuthService} from '../../../shared/services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-modify-profile',
  templateUrl: './modify-profile.component.html',
  styleUrls: ['./modify-profile.component.scss']
})
export class ModifyProfileComponent implements OnInit {
  id: number;
  userDetail: UserDetail;
  info: FormGroup;
  err = false;
  constructor(
    private authS: AuthService,
    private bottomSheet: MatBottomSheet,
    private fb: FormBuilder,
    private router: Router
  ) {
    this.authS.userSubject.subscribe(res => {
      this.id = res.id;
    })
    this.authS.getUserDetail(this.id).subscribe( res => {
      this.userDetail = res;
    })
  }

  ngOnInit() {
    this.info = this.fb.group({
      uname: ['',[Validators.minLength(5), Validators.maxLength(30)]],
      phone: ['',[Validators.pattern('^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$')]],
      address1: '',
      address2: '',
      city: ['',[Validators.minLength(3), Validators.maxLength(20)]],
      state: ['',[Validators.minLength(2), Validators.maxLength(15)]],
      zip: ['', [Validators.pattern('^\\d{5}(?:[-\\s]\\d{4})?$')]]
    });
  }

  onSubmit(){
    if (this.info.valid) {
      const { uname, phone, address1, address2, city, state, zip} = this.info.value;
      // if (this.userDetail == null)
      //   this.userDetail = new UserDetail();
      // this.authS.userSubject.subscribe(res => {
      //   this.userDetail.userId = res.id;
      //   this.userDetail.email = res.username;
      // });
      if (uname) {
        this.userDetail.name = uname;
      }

      if (phone){
        this.userDetail.phone = phone;
      }

      if (address1){
        this.userDetail.address1 = address1;
      }
      if (address2){
        this.userDetail.address2 = address2;
      }
      if (city){
        this.userDetail.city = city;
      }
      if (state){
        this.userDetail.state = state;
      }
      if (zip){
        this.userDetail.zip = zip;
      }

      this.authS.updateUserDetail(this.userDetail)
        .subscribe(res => {
          if (res.success) {
            this.router.navigate(['/user-info']);
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
