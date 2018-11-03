import { Component, OnInit } from '@angular/core';
import {Product} from '../shared/models/product';
import {ProductService} from '../shared/services/product/product.service';
import {FormControl} from '@angular/forms';
import {ProductTypeService} from '../shared/services/product/product-type.service';
import {ProductType} from '../shared/models/product-type';
import {ProductS} from '../shared/models/product-s';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  productsShow: ProductS[];
  mode = new FormControl('over');
  productTypes: ProductType[];
  // MatPaginator Inputs
  length:number;
  pageSize:number = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  // MatPaginator Output
  activePageDataChunk = [];
  constructor(
    private ps: ProductService,
    private pts: ProductTypeService
  ) { }

  ngOnInit() {
    this.ps.getAllProducts()
      .subscribe( (res) => {
        this.products = res;
        this.length = res.length;
        this.activePageDataChunk = this.products.slice(0, this.pageSize);
      });
    this.pts.getAllProductTypes()
      .subscribe( res => {
        this.productTypes = res;
        this.productTypes.sort((a,b) => {
          return a.id - b.id;
        });
      });
  }
  // setPageSizeOptions(setPageSizeOptionsInput: string) {
  //   this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  // }
  onPageChanged(e) {
    let firstCut = e.pageIndex * e.pageSize;
    let secondCut = firstCut + e.pageSize;
    if (this.products == undefined || this.products == null) {return;}
    this.activePageDataChunk = this.products.slice(firstCut, secondCut);
  }

}
