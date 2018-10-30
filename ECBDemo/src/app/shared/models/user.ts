import {UserDetail} from './user-detail';

export class User {
  id?: number;
  username: string;
  password: string;
  image?: Blob;
  onlineStatus: number;
  activated: number;
  credits: number;
  registeredDate: Date;
  userDetail?: UserDetail;
}
