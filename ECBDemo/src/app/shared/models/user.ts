import {UserDetail} from './user-detail';
import {UserType} from './user-type';

export class User {
  id?: number;
  username: string;
  password: string;
  onlineStatus: number;
  activated: number;
  credits: number;
  registeredDate?: Date;
}
