import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {AuthService} from '../../shared/services/auth.service';
import {User} from '../../shared/models/user';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {
  displayedColumns: string[] = ['id', 'username', 'activated', 'onlineStatus', 'operations'];
  dataSource: MatTableDataSource<User>;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private authS: AuthService
  ) { }

  ngOnInit() {
    this.authS.getAllUsers().subscribe( u => {
      this.dataSource = new MatTableDataSource<User>(u);
      this.dataSource.paginator = this.paginator;
    });
    this.authS.checkOnlineNumber().subscribe( res => {
      console.log( res);
    });
  }
}

// export interface userShow {
//   id?: number;
//   username: string;
//   credits: number;
//   userDetailId: number;
//   name: string;
//   phone: string;
//   email: string;
//   address1: string;
//   address2: string;
//   city: string;
//   state: string;
//   zip: string;
//   image?: string;
// }


