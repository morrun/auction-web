import {Component, OnInit, ViewChild} from '@angular/core';
import {AuthService} from '../../shared/services/auth.service';
import {User} from '../../shared/models/user';
import {MatSidenav} from '@angular/material/sidenav';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss']
})
export class UserInfoComponent implements OnInit {
  users: User;
  options: FormGroup;
  showFiller = false;
  showHome = true;
  constructor(
    private authS: AuthService,
    fb: FormBuilder) {
    this.options = fb.group({
      bottom: 0,
      fixed: false,
      top: 0
    });
  }

  ngOnInit(){
    this.authS.userSubject.subscribe((res: User) => {
      this.users = res;
    });
  }

}
