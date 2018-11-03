import { Component, OnInit } from '@angular/core';
import {Product} from '../shared/models/product';
import {ProductService} from '../shared/services/product/product.service';
import {FormControl} from '@angular/forms';
import {ProductTypeService} from '../shared/services/product/product-type.service';
import {ProductType} from '../shared/models/product-type';
import {ProductS} from '../shared/models/product-s';
import {ShelvesProduct} from '../shared/models/shelves-product';
import {OnShelvesService} from '../shared/services/Shelves/on-shelves.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  // The properites belwo is used for filter
  selectedValue: string;
  min: number;
  max: number;
  typeFilter: string;
  // This is used for display the products
  products: Product[];
  showProducts: Product[];
  shelvesP: ShelvesProduct[];

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
    private oss: OnShelvesService
  ) { }

  ngOnInit() {
    // this.ps.getAllProducts()
    //   .subscribe( (res) => {
    //     this.products = res;
    //     this.length = res.length;
    //     this.activePageDataChunk = this.products.slice(0, this.pageSize);
    //   });
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
          if (pid)
          pid.push(s.productId);
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
