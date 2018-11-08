import { Component, OnInit } from '@angular/core';
import {ImageServiceService} from '../../shared/services/images/image-service.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../shared/models/product';
import {ProductService} from '../../shared/services/product/product.service';
import {formatDate} from '@angular/common';
import {ProductTypeService} from '../../shared/services/product/product-type.service';
import {ProductType} from '../../shared/models/product-type';
import {AuthService} from '../../shared/services/auth.service';
import {Router} from '@angular/router';
import {Alert} from 'selenium-webdriver';
import {ShelvesProduct} from '../../shared/models/shelves-product';
import {Shelves} from '../../shared/models/shelves';
import {OnShelvesService} from '../../shared/services/Shelves/on-shelves.service';

@Component({
  selector: 'app-sell-products',
  templateUrl: './sell-products.component.html',
  styleUrls: ['./sell-products.component.scss']
})
export class SellProductsComponent implements OnInit {
  userId: number;
  productId: number;
  productType: ProductType[];
  selectedFiles: FileList;
  shelveProduct: ShelvesProduct;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  result: string;

  nestedReactiveForm: any = FormGroup;
  constructor(
    private uploadService: ImageServiceService,
    private authS: AuthService,
    private fb: FormBuilder,
    private ps: ProductService,
    private pts: ProductTypeService,
    private osps: OnShelvesService,
    private router: Router) {
    this.nestedReactiveForm = this.fb.group({
      title: ['', [ Validators.required, Validators.maxLength(100)]],
      description: ['', [ Validators.maxLength(500)]],
      productTypeId: ['', [ Validators.required]],
      price: ['', [ Validators.required]],
      type: ['SELL',[Validators.required]],
      deadline: ''
    });
  }

  ngOnInit() {
    this.authS.userSubject.subscribe( res => {
      if (res) {
        this.userId = res.id;
      }
    });

    this.pts.getAllProductTypes().subscribe( res => {
      this.productType = res;
    });
    this.shelveProduct = new ShelvesProduct();
    this.shelveProduct.shelves = new Shelves();
    if (this.userId) {
      this.shelveProduct.shelves.userId = this.userId;
    }
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress.percentage = 0;
    for (let i = 0;i < this.selectedFiles.length; i ++) {
      this.currentFileUpload = this.selectedFiles.item(i);
      this.uploadService.pushFileToStorage(this.currentFileUpload, this.productId ).subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress.percentage = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }
      });
    }
    this.osps.addShelvesProduct(this.shelveProduct).subscribe();
    this.router.navigate(['/products']);
    this.selectedFiles = undefined;
  }
onSubmit() {
  if (!this.userId){
    alert( ' Please Login first!');
    this.router.navigate(['/users/login']);
  }
  if( this.nestedReactiveForm.valid) {
    const product = new Product();
    const { title, description, productTypeId, price, type, deadline } = this.nestedReactiveForm.value;
    product.title = title;
    product.description = description;
    product.productTypeId = productTypeId;
    product.price = price;
    this.shelveProduct.shelves.type = type;
    // console.log(deadline.getFullYear() + '-' + deadline.getMonth() + '-' + deadline.getDate());
    // formatDate(deadline, 'yyyy/mm/dd',  '');
    product.deadline = deadline.getFullYear() + '/' + deadline.getMonth() + '/' + deadline.getDate();
    // product.deadline = time;
    if (this.selectedFiles){
      this.ps.addProduct( product).subscribe( res => {
        this.productId = res;
        this.shelveProduct.productId = this.productId;
        this.upload();
      });
    } else {
      alert('Please provide some images!');
    }


  }
}
  // fileuploads( event: any) {
  //   const files = event.target.files;
  //   const control = this.nestedReactiveForm.controls['image'].controls;
  //   console.log(this.nestedReactiveForm);
  //   for (let i = 0;i < files.length; i ++) {
  //     const reader = new FileReader();
  //     reader.onload = (e) => {
  //       const base64 = reader.result + '';
  //
  //      control.push(this.fb.control(base64));
  //     };
  //     reader.readAsDataURL(files[i]);
  //   }
  //   event.srcElement.value = null;
  // }

}
