import { Pipe, PipeTransform } from '@angular/core';
import {ProductType} from '../models/product-type';

@Pipe({
  name: 'productType'
})
export class ProductTypePipe implements PipeTransform {

  transform(pts: ProductType[], id: number): any {
    const pt = pts.filter( (p: ProductType) => {
      return p.id === id;
    });
    return pt[0].type;
  }

}
