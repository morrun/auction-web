import { Component, OnInit } from '@angular/core';
import {ShelvesProduct} from '../../../shared/models/shelves-product';
import {Product} from '../../../shared/models/product';
import {User} from '../../../shared/models/user';
import {OperationView} from '../../../shared/models/operation-view';
import {ProductImage} from '../../../shared/models/product-image';
import {AuthService} from '../../../shared/services/auth.service';
import {OnShelvesService} from '../../../shared/services/Shelves/on-shelves.service';
import {ProductService} from '../../../shared/services/product/product.service';
import {MatDialog} from '@angular/material';
import {OperationViewService} from '../../../shared/services/Operation/operation-view.service';
import {ProductImageService} from '../../../shared/services/product/product-image.service';
import {ReloadDialogComponent} from './reload-dialog/reload-dialog.component';
import {Shelves} from '../../../shared/models/shelves';
import {DialogReloadProduct} from '../../../shared/models/dialog-reload-product';

@Component({
  selector: 'app-sold-product',
  templateUrl: './sold-product.component.html',
  styleUrls: ['./sold-product.component.scss']
})
export class SoldProductComponent implements OnInit {
  show = true;
  user: User;
  product: Product[];
  productImage: ProductImage[];
  operationView: OperationView[] = [];
  pid: number[] = []; // used to store product id which belong to this user. Then get image url by using this ids.
  constructor(
    private productService: ProductService,
    private productImageService: ProductImageService,
    private operationViewService: OperationViewService,
    private onShelveService: OnShelvesService,
    private authService: AuthService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    // this.authService.checkLogin();
    this.authService.userSubject.subscribe( res => {
      this.user = res;
      if (this.user){
        this.loadOperationViews();
      }
    });
  }
  loadOperationViews() {
    this.operationViewService.getOperationViewBySellerUserId(this.user.id).subscribe( res => {
      if (res) {
        const temOV: OperationView[] = res.filter( ov => {
          return ov.viewStatus === 1;
        });
        this.operationView = temOV;
        temOV.map( ov => {
          this.pid.push(ov.productId);
        });
        this.loadProducts();
      }
    });
  }
  loadProducts() {
    this.productService.getProductsByIdList(this.pid).subscribe( res => {
      this.product = res;
      this.loadProductsImages();
    });
  }
  loadProductsImages() {
    this.productImageService.getImagesByProductIdList(this.pid).subscribe( res => {
      this.productImage = res;
    });
  }
  openDialog( id: number): void {
    const dialogRef = this.dialog.open(ReloadDialogComponent, {
      width: '400px',
      data: {code: 0}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      const dialogReload: DialogReloadProduct = result;
      if (dialogReload.code === 1) {
        const shelvesProduct = new ShelvesProduct();
        shelvesProduct.productId = id;
        shelvesProduct.shelves = new Shelves();
        shelvesProduct.shelves.userId = this.user.id;
        shelvesProduct.shelves.type = dialogReload.type;
        this.onShelveService.addShelvesProduct(shelvesProduct).subscribe();
        this.operationViewService.deleteOperationViewByProductId(shelvesProduct.productId).subscribe();
      }
    });
  }
}
