import {Component, Inject, OnInit} from '@angular/core';
import {ModifyMyProductComponent} from '../../on-sale-products/modify-my-product/modify-my-product.component';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {AuthService} from '../../../../shared/services/auth.service';
import {UserDetail} from '../../../../shared/models/user-detail';

@Component({
  selector: 'app-after-accept-price',
  templateUrl: './after-accept-price.component.html',
  styleUrls: ['./after-accept-price.component.scss']
})
export class AfterAcceptPriceComponent implements OnInit {
  userDetail: UserDetail = new UserDetail();
  constructor(
    public dialogRef: MatDialogRef<ModifyMyProductComponent>,
    @Inject(MAT_DIALOG_DATA) public data,
    private authS: AuthService
  ) { }

  ngOnInit() {
    this.authS.getUserDetail(this.data.sellerUserId).subscribe( res => {
      this.userDetail = res;
    });
  }
}
