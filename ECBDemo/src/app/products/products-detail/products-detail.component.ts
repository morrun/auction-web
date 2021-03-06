import {Component, OnDestroy, OnInit} from '@angular/core';
import {Product} from '../../shared/models/product';
import {Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProductService} from '../../shared/services/product/product.service';
import {ProductImage} from '../../shared/models/product-image';
import {ProductType} from '../../shared/models/product-type';
import {ProductTypeService} from '../../shared/services/product/product-type.service';
import {OnShelvesService} from '../../shared/services/Shelves/on-shelves.service';
import {AuthService} from '../../shared/services/auth.service';
import {User} from '../../shared/models/user';
import {VisitHistoryService} from '../../shared/services/Operation/visit-history.service';
import {ProductImageService} from '../../shared/services/product/product-image.service';
import {DialogForProductComponent} from './dialog-for-product/dialog-for-product.component';
import {MatDialog} from '@angular/material';
import {OperationHistory} from '../../shared/models/operation-history';
import {BidOrBuyService} from '../../shared/services/Operation/bid-or-buy.service';
import {ShelvesProduct} from '../../shared/models/shelves-product';

@Component({
  selector: 'app-products-detail',
  templateUrl: './products-detail.component.html',
  styleUrls: ['./products-detail.component.scss']
})
export class ProductsDetailComponent implements OnInit, OnDestroy {
  day: number;
  hours: number;
  minutes: number;
  product: Product;
  productImage: ProductImage[];
  show: boolean;
  productType: ProductType;
  shelveProduct: ShelvesProduct;
  id = 0;
  sub: Subscription;
  user: User;
  operationH: OperationHistory[] = [];
  constructor(
    ar: ActivatedRoute,
    private ps: ProductService,
    private pts: ProductTypeService,
    private router: Router,
    private oss: OnShelvesService,
    private authS: AuthService,
    private visitHS: VisitHistoryService,
    private pis: ProductImageService,
    public dialog: MatDialog,
    private bob: BidOrBuyService
  ) {
    // this.id = +ar.snapshot.paramMap.get('id');
    this.sub = ar.paramMap
      .subscribe((params: ParamMap) => {
        this.id = +params.get('id');
        this.pis.getImagesByProductId(this.id).subscribe( res => {
          this.productImage = res;
        });
        this.ps.getProductsById(this.id)
          .subscribe( res => {
            this.product = res;
            this.pts.getProductByPId(this.product.productTypeId)
              .subscribe( res => {
                this.productType = res;
              });
          });
        this.bob.getOperationsHistoryByProductId(this.id).subscribe( res => {
          this.operationH = res;
          this.operationH.sort( (oh1, oh2) => {
            return oh2.price - oh1.price;
          });
        });
      });
    this.oss.getShelvesByProductId(this.id)
      .subscribe( res => {
        this.shelveProduct = res;
        if (this.shelveProduct && this.shelveProduct.shelves.type === 'SELL'){
          this.show = true;
        }
      });
    this.oss.getRemainTimeByProductId(this.id)
      .subscribe( res => {
        this.day = Math.floor(res / 24 / 60);
        res = res % (24 * 60);
        this.hours =Math.floor( res / 60);
        res = res % 60;
        this.minutes = res;
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
      this.openDialog();
      //do some negotiate login. May include operation and order table.
    }else {
      alert('Please login first!');
      this.router.navigate(['/users/login']);
    }
  }
  bidding() {
    if (this.user) {
      this.openDialog();
      //do some negotiate login. May include operation and order table.
    }else {
      alert("Please login first!");
      this.router.navigate(['/users/login']);
    }
  }
  openDialog(): void {
    let typeTem = this.show ? 'SELL': 'AUCTION';
    const dialogRef = this.dialog.open(DialogForProductComponent, {
      width: '250px',
      data: {productId: this.id, userId: this.user.id, type: typeTem}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
