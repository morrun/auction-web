import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {User} from '../../../shared/models/user';
import {AuthService} from '../../../shared/services/auth.service';
import {UpLoadImageComponent} from './up-load-image/up-load-image.component';
import {MatBottomSheet} from '@angular/material';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UserDetail} from '../../../shared/models/user-detail';
import {Router} from '@angular/router';
import {ImageServiceService} from '../../../shared/services/images/image-service.service';
import {UserShowService} from '../../../shared/services/user-show.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit, OnChanges {
  userDetail: UserDetail;
  info: FormGroup;
  err = false;
  imageToShow: any;
  constructor(
    private authS: AuthService,
    private bottomSheet: MatBottomSheet,
    private fb: FormBuilder,
    private router: Router,
    private imageService: ImageServiceService,
    private sh: UserShowService
  ) {}
  openBottomSheet(): void {
    this.bottomSheet.open(UpLoadImageComponent);
    this.createImageFromBlob(this.imageService.userImage);
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
  createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener('load', () => {
      this.imageToShow = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }
  ngOnChanges() {

  }
  onSubmit(){
    if (this.info.valid) {
      const { uname, phone,address1, address2, city, state, zip} = this.info.value;
      if (this.userDetail == null)
      this.userDetail = new UserDetail();
      //this.user.image = this.imageToShow;
      this.authS.userSubject.subscribe(res => {
        this.userDetail.userId = res.id;
        this.userDetail.email = res.username;
      });
      this.userDetail.name = uname;
      this.userDetail.phone = phone;
      this.userDetail.address1 = address1;
      this.userDetail.address2 = address2;
      this.userDetail.city = city;
      this.userDetail.state = state;
      this.userDetail.zip = zip;
      this.authS.updateUserDetail(this.userDetail)
        .subscribe(res => {

          if (res.success) {
           this.sh.showHome = true;
            this.router.navigate(['/home']);
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
