import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../shared/services/auth.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  err = false;
  registerFormGroup: FormGroup;
  emailMessages = [
    { type: 'required', message: 'Email is required' },
    { type: 'pattern', message: 'Enter a valid email' }
  ];
  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit() {
    this.registerFormGroup = this.fb.group({
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
      ])),
      passwordGroup: this.fb.group({
        password: '',
        confirm_password: ''
      },{validator:this.passwordValidator})
    });
  }
  passwordValidator({value}:FormGroup) {
    const {password,confirm_password} = value;
    return password === confirm_password ? null:{passwordGroup: 'Passwords don\'t matchz!'};
  }

  onSubmit() {
    if (this.registerFormGroup.valid) {
      const {email, passwordGroup: {password}} = this.registerFormGroup.value;
      const username = email;

      const onlineStatus = 0;
      const activated: number = 0;
      const credits: number = 0;
      // const user: User = new User();
      this.authService.register({ username, password, onlineStatus, activated, credits})
        .subscribe(res => {
          if (res.success) {
            this.router.navigate(['/users/login']);
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
