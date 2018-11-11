import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {DialogData} from '../../../shared/models/dialog-data';
import {BidOrBuyService} from '../../../shared/services/Operation/bid-or-buy.service';
import {OperationHistory} from '../../../shared/models/operation-history';
import {Operation} from '../../../shared/models/operation';

@Component({
  selector: 'app-dialog-for-product',
  templateUrl: './dialog-for-product.component.html',
  styleUrls: ['./dialog-for-product.component.scss']
})
export class DialogForProductComponent implements OnInit {
  price: number;
  constructor(
    public dialogRef: MatDialogRef<DialogForProductComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private bob: BidOrBuyService) {}
  ngOnInit() {

  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  submit() {
    let oh = new OperationHistory();
    oh.operations = new Operation();
    oh.price = this.price;
    oh.productId = this.data.productId;
    oh.operations.type = this.data.type;
    oh.operations.userId = this.data.userId;
    this.bob.addOperationService(oh).subscribe();
    alert('The price you provide will be received by seller. Please wait for his/her response!');
    this.onNoClick();
  }

}
