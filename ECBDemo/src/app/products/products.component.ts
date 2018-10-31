import { Component, OnInit } from '@angular/core';
import {Product} from '../shared/models/product';
import {ProductService} from '../shared/services/product/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  constructor(
    private ps: ProductService
  ) { }

  ngOnInit() {
    this.ps.getAllProducts().subscribe( (res) => {
      this.products = res;
    });
  }

}
