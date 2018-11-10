import {Component, OnInit, ViewChild} from '@angular/core';
import {AuthService} from '../../../shared/services/auth.service';
import {User} from '../../../shared/models/user';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-user-management-dialog',
  templateUrl: './user-management-dialog.component.html',
  styleUrls: ['./user-management-dialog.component.scss']
})
export class UserManagementDialogComponent implements OnInit {
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
