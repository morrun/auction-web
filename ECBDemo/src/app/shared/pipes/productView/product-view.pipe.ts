import { Pipe, PipeTransform } from '@angular/core';
import {OperationView} from '../../models/operation-view';

@Pipe({
  name: 'productView',
  pure: false,
})
export class ProductViewPipe implements PipeTransform {

  transform(id: number, opView: OperationView[]): OperationView[] {
      return ( opView || []).filter( ov => {
        return ov.productId === id && ov.viewStatus === 0;
      });
  }

}
