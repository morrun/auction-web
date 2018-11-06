import {Operation} from './operation';

export class OperationHistory {
  id?: number;
  operations: Operation;
  productId: number;
  operationDate?: Date;
  price: number;
}
