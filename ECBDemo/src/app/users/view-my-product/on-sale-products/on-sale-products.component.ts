import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ProductService} from '../../../shared/services/product/product.service';
import {ProductImageService} from '../../../shared/services/product/product-image.service';
import {OperationViewService} from '../../../shared/services/Operation/operation-view.service';
import {Product} from '../../../shared/models/product';
import {ProductImage} from '../../../shared/models/product-image';
import {ShelvesProduct} from '../../../shared/models/shelves-product';
import {OnShelvesService} from '../../../shared/services/Shelves/on-shelves.service';
import {User} from '../../../shared/models/user';
import {AuthService} from '../../../shared/services/auth.service';
import {OperationView} from '../../../shared/models/operation-view';
import {ModifyMyProductComponent} from './modify-my-product/modify-my-product.component';
import {MatDialog} from '@angular/material';
import {VisitHistoryService} from '../../../shared/services/Operation/visit-history.service';

@Component({
  selector: 'app-on-sale-products',
  templateUrl: './on-sale-products.component.html',
  styleUrls: ['./on-sale-products.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class OnSaleProductsComponent implements OnInit {
  show = true;
  empty = true;
  user: User;
  product: Product[];
  productImage: ProductImage[];
  shelvesProduct: ShelvesProduct[];
  operationView: OperationView[] = [];
  pid: number[] = []; // used to store product id which belong to this user. Then get image url by using this ids.

  constructor(
    private productService: ProductService,
    private productImageService: ProductImageService,
    private operationViewService: OperationViewService,
    private onShelveService: OnShelvesService,
    private authService: AuthService,
    public dialog: MatDialog,
    private vhs: VisitHistoryService
  ) { }

  ngOnInit() {
    // this.authService.checkLogin();
    this.authService.userSubject.subscribe( res => {
      this.user = res;
      if (this.user){
        this.loadShelvesProduct();
        this.loadOperationViews();
      }
    });

  }
  loadOperationViews() {
    this.operationViewService.getOperationViewBySellerUserId(this.user.id).subscribe( res => {
      if (res) {
        this.operationView = (res || []);
      }

    });
  }
  loadShelvesProduct() {
    this.onShelveService.getShelvesByUserId(this.user.id).subscribe( res => {
      this.shelvesProduct = res;
      if (res.length === 0) {
        this.empty = false;
      }
      this.shelvesProduct.map( sp => {
        this.pid.push(sp.productId);
      });
      this.loadProducts();
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
  accept(opV: OperationView) {
    opV.viewStatus = 1;
    this.vhs.deleteVisityHistoryByProductId(opV.productId).subscribe();
    this.show = false;
    this.operationViewService.upadateOperationView(opV).subscribe();
  }
  reject(opV: OperationView) {
    opV.viewStatus = 2;
    this.show = false;
    this.operationViewService.upadateOperationView(opV).subscribe();
  }
  viewed(opV: OperationView) {
    opV.viewStatus = 3;
    this.operationViewService.upadateOperationView(opV).subscribe();
  }
  openDialog(productTem: Product): void {
    const dialogRef = this.dialog.open(ModifyMyProductComponent, {
      minWidth: '500px',
      data: {product: productTem}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      location.reload();
    });
  }
}
