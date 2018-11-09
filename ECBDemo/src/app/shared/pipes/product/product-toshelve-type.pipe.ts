import { Pipe, PipeTransform } from '@angular/core';
import {ShelvesProduct} from '../../models/shelves-product';

@Pipe({
  name: 'productTOShelveType'
})
export class ProductTOShelveTypePipe implements PipeTransform {

  transform(id: number, shelvesProduct: ShelvesProduct[]): boolean {
    const sp = (shelvesProduct || []).filter( tsp => {
      return tsp.productId === id;
    });
    return sp[0].shelves.type === 'SELL';
  }

}
