import { Component, OnInit } from '@angular/core';
import {Product} from '../shared/models/product';
import {ProductService} from '../shared/services/product/product.service';
import {FormControl} from '@angular/forms';
import {PageEvent} from '@angular/material';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  mode = new FormControl('over');
  panelOpenState = false;

  // MatPaginator Inputs
  length:number;
  datasource = [];
  pageSize:number = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  // MatPaginator Output
  pageEvent: PageEvent;
  activePageDataChunk = [];
  constructor(
    private ps: ProductService
  ) { }

  ngOnInit() {
    this.ps.getAllProducts()
      .subscribe( (res) => {
        this.products = res;
        this.length = res.length;
        this.activePageDataChunk = this.products.slice(0, this.pageSize);
      });
  }
  setPageSizeOptions(setPageSizeOptionsInput: string) {
    this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  }
  onPageChanged(e) {
    console.log(this.length);
    let firstCut = e.pageIndex * e.pageSize;
    let secondCut = firstCut + e.pageSize;
    if (this.products == undefined || this.products == null) {return;}
    this.activePageDataChunk = this.products.slice(firstCut, secondCut);
  }

}
