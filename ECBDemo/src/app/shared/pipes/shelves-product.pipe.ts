import { Pipe, PipeTransform } from '@angular/core';
import {ShelvesProduct} from '../models/shelves-product';

@Pipe({
  name: 'shelvesProduct'
})
export class ShelvesProductPipe implements PipeTransform {

  transform(sps: ShelvesProduct[], id: number): any {
    let sp = sps.filter( tem => {
      return tem.productId === id;
    });
    if (!sp[0]) return null;
    return sp[0].shelves.type;
  }

}
