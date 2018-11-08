import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {DialogReloadProduct} from '../../../../shared/models/dialog-reload-product';

@Component({
  selector: 'app-reload-dialog',
  templateUrl: './reload-dialog.component.html',
  styleUrls: ['./reload-dialog.component.scss']
})
export class ReloadDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ReloadDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogReloadProduct
  ) { }

  ngOnInit() {
    this.data.type = 'SELL';
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
  codeChange() {
    this.data.code = 1;
  }
}
