import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../../shared/services/auth.service';
import {Router} from '@angular/router';
import {User} from '../../../shared/models/user';
import {UserShowService} from '../../../shared/services/user-show.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {

  err = false;
  changePasswordFormGroup: FormGroup;
  user: User;
  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private sh: UserShowService
  ) { }

  ngOnInit() {
    this.changePasswordFormGroup = this.fb.group({
      oldPassword: ['',[Validators.required]],
      passwordGroup: this.fb.group({
        password: '',
        confirm_password: ''
      },{validator:this.passwordValidator})
    });
    this.authService.userSubject.subscribe(res => {
      this.user = res;
    })
  }
  // Try to check password pair, but can't work!
  // oldPasswordValidator({value}: FormControl){
  //   console.log(value);
  //   this.authService.checkPassword(this.user.id, value ).subscribe(res => {
  //     if (!res) return {
  //         missMachPassword: true;
  //     };
  //   });
  //   return null;
  // }
  passwordValidator({value}:FormGroup) {
    const {password,confirm_password} = value;
    return password === confirm_password ? null:{passwordGroup: 'Passwords don\'t matchz!'};
  }

  onSubmit() {
    if (this.changePasswordFormGroup.valid) {
      const {oldPassword, passwordGroup: {password}} = this.changePasswordFormGroup.value;
      // this.authService.checkPassword(this.user.id,oldPassword).subscribe( res => {
      //   console.log(res);
      // })；
      this.authService.changePassword(this.user.id, password)
        .subscribe(res => {
          console.log(res);
          if (res.success) {
            this.sh.showHome = true;
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
