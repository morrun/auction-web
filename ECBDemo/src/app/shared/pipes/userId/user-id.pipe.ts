import { Pipe, PipeTransform } from '@angular/core';
import {UserDetail} from '../../models/user-detail';

@Pipe({
  name: 'userId'
})
export class UserIdPipe implements PipeTransform {

  transform(id: number, userDetail: UserDetail[]): any {

    let ud: UserDetail[] = [];
    if (userDetail)
      ud = userDetail.filter( u => {
      return u.userId === id;
    });
    if (ud[0] && ud[0].email) {
      return ud[0].email;
    }

  }

}
