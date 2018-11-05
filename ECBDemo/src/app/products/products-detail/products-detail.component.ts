import { Component, OnInit } from '@angular/core';
import {Product} from '../../shared/models/product';
import {Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProductService} from '../../shared/services/product/product.service';
import {ProductImage} from '../../shared/models/product-image';
import {ProductType} from '../../shared/models/product-type';
import {ProductTypeService} from '../../shared/services/product/product-type.service';
import {ShelvesProduct} from '../../shared/models/shelves-product';
import {OnShelvesService} from '../../shared/services/Shelves/on-shelves.service';
import {AuthService} from '../../shared/services/auth.service';
import {User} from '../../shared/models/user';
import {VisitHistoryService} from '../../shared/services/Operation/visit-history.service';

@Component({
  selector: 'app-products-detail',
  templateUrl: './products-detail.component.html',
  styleUrls: ['./products-detail.component.scss']
})
export class ProductsDetailComponent implements OnInit {
  product: Product;
  productImage: ProductImage[];
  show: boolean;
  productType: ProductType;
  shelveProduct; ShelvesProduct;
  id = 0;
  sub: Subscription;
  user: User;
  constructor(
    ar: ActivatedRoute,
    private ps: ProductService,
    private pts: ProductTypeService,
    private router: Router,
    private oss: OnShelvesService,
    private authS: AuthService,
    private visitHS: VisitHistoryService
  ) {
    // this.id = +ar.snapshot.paramMap.get('id');
    this.sub = ar.paramMap
      .subscribe((params: ParamMap) => {
        this.id = +params.get('id');
        this.ps.getProductsById(this.id)
          .subscribe( res => {
            this.product = res;
            this.pts.getProductByPId(this.product.productTypeId)
              .subscribe( res => {
                this.productType = res;
              });
          });
      });
    this.oss.getShelvesByProductId(this.id)
      .subscribe( res => {
        this.shelveProduct = res;
        if (this.shelveProduct.shelves.type === 'SELL'){
          this.show = true;
        }
      });

  }
  ngOnInit() {
    this.authS.checkLogin();
    this.authS.userSubject.subscribe( res => {
      this.user = res;
      if (this.user) {
        if (this.id) {
          this.visitHS.addVisitHistory(this.id, this.user.id).subscribe();
        }

      }
    });

  }
  negotiate() {
    if (this.user) {
      //do some negotiate login. May include operation and order table.
    }else {
      this.router.navigate(['/users/login']);
    }
  }
  bidding() {

  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
