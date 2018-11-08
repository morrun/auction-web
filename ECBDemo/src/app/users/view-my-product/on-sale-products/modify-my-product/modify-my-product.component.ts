import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {DialogProduct} from '../../../../shared/models/dialog-product';
import {ProductImageService} from '../../../../shared/services/product/product-image.service';
import {ProductService} from '../../../../shared/services/product/product.service';
import {ImageServiceService} from '../../../../shared/services/images/image-service.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductTypeService} from '../../../../shared/services/product/product-type.service';

import {ProductType} from '../../../../shared/models/product-type';

import {HttpEventType, HttpResponse} from '@angular/common/http';


@Component({
  selector: 'app-modify-my-product',
  templateUrl: './modify-my-product.component.html',
  styleUrls: ['./modify-my-product.component.scss']
})
export class ModifyMyProductComponent implements OnInit {

  productType: ProductType[];
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  result: string;
  nestedReactiveForm: any = FormGroup;
  constructor(
    public dialogRef: MatDialogRef<ModifyMyProductComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogProduct,
    private productImageService: ProductImageService,
    private productService: ProductService,
    private uploadService: ImageServiceService,
    private fb: FormBuilder,
    private pts: ProductTypeService) {
    this.nestedReactiveForm = this.fb.group({
      title: ['', [ Validators.maxLength(100)]],
      description: ['', [ Validators.maxLength(500)]],
      productTypeId: '',
      price: '',
      deadline: ''
    });
}

  ngOnInit() {
    this.pts.getAllProductTypes().subscribe( res => {
      this.productType = res;
    });
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
  upload() {
    this.progress.percentage = 0;
    for (let i = 0;i < this.selectedFiles.length; i ++) {
      this.currentFileUpload = this.selectedFiles.item(0);
      this.uploadService.pushFileToStorage(this.currentFileUpload, this.data.product.id ).subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress.percentage = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }
      });
    }
    this.selectedFiles = undefined;
  }

  onSubmit() {
    if ( this.nestedReactiveForm.valid) {
      const { title, description, productTypeId, price, deadline } = this.nestedReactiveForm.value;
      this.data.product.title = title;
      this.data.product.description = description;
      this.data.product.productTypeId = productTypeId;
      this.data.product.price = price;
      if (deadline)
      this.data.product.deadline = deadline.getFullYear() + '/' + deadline.getMonth() + '/' + deadline.getDate();
      this.productService.updateProduct(this.data.product.id, this.data.product).subscribe( res => {
        if (!this.selectedFiles){
          this.onNoClick();
        }
        if (res.success && this.selectedFiles){
          this.upload();
        }

      });
      // if (this.selectedFiles){
      //
      // } else {
      //   alert('Please provide some images!');
      // }
    }
  }
  onNoClick(): void {
    this.dialogRef.close();
  }

}
