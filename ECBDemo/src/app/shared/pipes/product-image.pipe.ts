import { Pipe, PipeTransform } from '@angular/core';
import {ProductImage} from '../models/product-image';

@Pipe({
  name: 'productImage'
})
export class ProductImagePipe implements PipeTransform {

  transform(id: number, productImage: ProductImage[]): any {
    const result = productImage.filter( pi => {
      return pi.productId === id;
    });
    return result;
  }

}
