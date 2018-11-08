import { Pipe, PipeTransform } from '@angular/core';
import {Product} from '../../models/product';

@Pipe({
  name: 'productIdToTitle'
})
export class ProductIdToTitlePipe implements PipeTransform {

  transform(id: number, product: Product[]): any {
    let productRes: Product[] = [];
    if (product){
      productRes = product.filter( p => {
        return p.id === id;
      });
    }
    if (productRes[0] && productRes[0].title) {
      return productRes[0].title;
    }

  }

}
