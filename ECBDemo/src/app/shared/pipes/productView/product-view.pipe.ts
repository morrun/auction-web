import { Pipe, PipeTransform } from '@angular/core';
import {OperationView} from '../../models/operation-view';

@Pipe({
  name: 'productView'
})
export class ProductViewPipe implements PipeTransform {

  transform(id: number, operationView: OperationView[]): any {
    return operationView.filter( ov => {
      return ov.productId === id && ov.viewStatus === 0;
    });
  }

}
