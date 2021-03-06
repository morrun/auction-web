import {AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges, OnInit, ViewChild} from '@angular/core';
import {AuthService} from '../../shared/services/auth.service';
import {User} from '../../shared/models/user';
import {FormBuilder, FormGroup} from '@angular/forms';
import {UserDetail} from '../../shared/models/user-detail';
import {Router} from '@angular/router';
import {UserShowService} from '../../shared/services/user-show.service';
import {DialogChangePhotoComponent} from './dialog-change-photo/dialog-change-photo.component';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss']
})
export class UserInfoComponent implements OnInit, AfterContentInit {
  users: User;


  options: FormGroup;
  showFiller = false;
  @Input()
  showHome = true;
  havePro = false;


  userDetail: UserDetail = null;
  constructor(
    private authS: AuthService,
    private router: Router,
    fb: FormBuilder,
  public sh: UserShowService,
    public dialog: MatDialog,
    private userShow: UserShowService) {
    this.options = fb.group({
      bottom: 0,
      fixed: false,
      top: 0
    });
    this.sh.showHome = true;
  }

  ngOnInit(){
    this.authS.userSubject.subscribe((res: User) => {
      this.users = res;
    });
    this.authS.getUserDetail(this.users.id).subscribe(res => {
      if (res == null || res.id == null || res.id == undefined) {
        this.userDetail = new UserDetail();
        this.userDetail.image = null;
        this.userDetail.name = 'You Haven\'t input your profile';
        this.userDetail.email = 'XXXXXXXXX';
      } else {
        this.userDetail = res;
        this.userShow.userId = this.userDetail.userId;
        this.havePro = true;
      }

    });
  }
  ngAfterContentInit() {
    this.authS.getUserDetail(this.users.id).subscribe(res => {
      if (res == null || res.id == null || res.id == undefined) {
        this.userDetail = new UserDetail();
        this.userDetail.image = null;
        this.userDetail.name = 'You Haven\'t input your profile';
        this.userDetail.email = 'XXXXXXXXX';
      } else {
        this.userDetail = res;
        this.havePro = true;
      }

    });
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(DialogChangePhotoComponent, {
      minWidth: '250px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      location.reload();
      console.log('The dialog was closed');
    });
  }
}
