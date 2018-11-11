import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {FormControl} from '@angular/forms';
import {OnShelvesService} from '../../shared/services/Shelves/on-shelves.service';
import {ProductType} from '../../shared/models/product-type';
import {ProductService} from '../../shared/services/product/product.service';
import {ShelvesProduct} from '../../shared/models/shelves-product';
import {Product} from '../../shared/models/product';
import {ProductTypeService} from '../../shared/services/product/product-type.service';
import {ProductImage} from '../../shared/models/product-image';
import {ProductImageService} from '../../shared/services/product/product-image.service';

@Component({
  selector: 'app-counteroffer-products',
  templateUrl: './counteroffer-products.component.html',
  styleUrls: ['./counteroffer-products.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class CounterofferProductsComponent implements OnInit {
  // The properites belwo is used for filter
  selectedValue: string;
  min: number;
  max: number;
  typeFilter: string;
  // This is used for display the products
  products: Product[];
  showProducts: Product[];
  shelvesP: ShelvesProduct[];

  productImage: ProductImage[];
  productTypes: ProductType[];


  // MatPaginator Inputs
  length:number;
  pageSize:number = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  mode = new FormControl('over');
  // MatPaginator Output
  activePageDataChunk = [];
  constructor(
    private ps: ProductService,
    private pts: ProductTypeService,
    private oss: OnShelvesService,
    private pis: ProductImageService
  ) { }

  ngOnInit() {
    // this.ps.getAllProducts()
    //   .subscribe( (res) => {
    //     this.products = res;
    //     this.length = res.length;
    //     this.activePageDataChunk = this.products.slice(0, this.pageSize);
    //   });
    this.pis.getAllImage().subscribe( res => {
      this.productImage = res;
    });
    this.pts.getAllProductTypes()
      .subscribe( res => {
        this.productTypes = res;
        this.productTypes.sort((a,b) => {
          return a.id - b.id;
        });
      });
    this.oss.getAllShelvesData()
      .subscribe( res => {
        this.shelvesP = res;
        let pid: number[] = [];
        this.shelvesP.forEach( s => {
           if (pid && s.shelves.type === 'SELL') {
             pid.push(s.productId);
           }
        });
        this.getAllOnShelvesProduct(pid);
      });
  }
  getAllOnShelvesProduct(pid: number[]) {
    this.ps.getProductsByIdList(pid).subscribe( res => {
      this.products = res;
      this.showProducts = this.products;
      this.assignLengthAndChunk();
    });
  }
  onPageChanged(e) {
    let firstCut = e.pageIndex * e.pageSize;
    let secondCut = firstCut + e.pageSize;
    if (this.products == undefined || this.products == null) {return;}
    this.activePageDataChunk = this.products.slice(firstCut, secondCut);
  }
  changeView() {
    if (!this.selectedValue || this.selectedValue === 'All'){
      this.showAll();
    } else {
      const tid = this.productTypes.find( tem => {
        return tem.type === this.selectedValue;
      }).id;
      const cmin = this.min ? this.min : Number.MIN_VALUE;
      const cmax = this.max ? this.max : Number.MAX_VALUE;
      this.showProducts= this.products.filter( p => {
        return p.productTypeId === tid && p.price > cmin && p.price < cmax;
      });
    }
    this.assignLengthAndChunk();
  }
  showAll() {
    const cmin = this.min ? this.min : Number.MIN_VALUE;
    const cmax = this.max ? this.max : Number.MAX_VALUE;
    this.showProducts = this.products.filter( p => {
      return p.price > cmin && p.price < cmax;
    });
    this.assignLengthAndChunk();
  }
  assignLengthAndChunk() {
    this.length = this.showProducts.length;
    this.activePageDataChunk = this.showProducts.slice(0, this.pageSize);
  }
  modifyViewByMin() {
    this.changeView();
    if (!this.min && !this.max) {

    }else {
      const cmin = this.min ? this.min : Number.MIN_VALUE;
      const cmax = this.max ? this.max : Number.MAX_VALUE;
      this.showProducts= this.showProducts.filter( p => {
        return p.price > cmin && p.price < cmax;
      });
      this.assignLengthAndChunk();
    }

  }
  restoreMin() {
    this.min = null;
    this.changeView();
  }
  restoreMax() {
    this.max = null;
    this.changeView();
  }
}
