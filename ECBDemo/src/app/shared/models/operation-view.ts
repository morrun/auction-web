export class OperationView {
  id?: number;
  sellerUserId: number;
  sellerUserName: string;
  buyerUserId: number;
  buyerUserName: string;
  originalPrice: number;
  nowPrice: number;
  viewStatus?: number;
  productId: number;
  operationDate: Date;
}
