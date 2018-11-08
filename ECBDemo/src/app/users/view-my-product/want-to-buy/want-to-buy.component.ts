import { Component, OnInit } from '@angular/core';
import {OperationViewService} from '../../../shared/services/Operation/operation-view.service';
import {AuthService} from '../../../shared/services/auth.service';
import {ProductService} from '../../../shared/services/product/product.service';
import {ProductImageService} from '../../../shared/services/product/product-image.service';
import {OnShelvesService} from '../../../shared/services/Shelves/on-shelves.service';
import {User} from '../../../shared/models/user';
import {ShelvesProduct} from '../../../shared/models/shelves-product';
import {OperationView} from '../../../shared/models/operation-view';
import {Product} from '../../../shared/models/product';
import {ProductImage} from '../../../shared/models/product-image';
import {UserDetail} from '../../../shared/models/user-detail';

@Component({
  selector: 'app-want-to-buy',
  templateUrl: './want-to-buy.component.html',
  styleUrls: ['./want-to-buy.component.scss']
})
export class WantToBuyComponent implements OnInit {
  show = true;

  user: User;
  product: Product[];
  operationView: OperationView[] = [];
  useD: UserDetail[];
  pid: number[] = []; // used to store product id which belong to this user. Then get image url by using this ids.
  uid: number[] = [];
  constructor(
    private productService: ProductService,
    private operationViewService: OperationViewService,
    private authService: AuthService,
  ) { }

  ngOnInit() {
    this.authService.userSubject.subscribe( res => {
      this.user = res;
      if (this.user){
        this.loadOperationViews();
      }
    });
  }
  loadOperationViews() {
    this.operationViewService.getOperationViewBySellerUserId(this.user.id).subscribe( res => {
      this.operationView = res;
      this.operationView.map( ov => {
        this.pid.push(ov.productId);
        this.uid.push(ov.sellerUserId);
      });
      this.loadProductView();
      this.loadUserDetailView();
    });
  }
  loadProductView() {
    this.productService.getProductsByIdList(this.pid).subscribe( res => {
      this.product = res;
    });
  }
  loadUserDetailView() {
    this.authService.getUseDetailByUserIds(this.uid).subscribe( res => {
      this.useD  = res;
    });
  }
}
