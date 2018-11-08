import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'emailTrans'
})
export class EmailTransPipe implements PipeTransform {

  transform(email: string): any {
    let index = 0;
    if (email) {
      index = email.split('').findIndex((a) => {
        return a === '@';
      });
    }
    if (email) {
      return email.slice(0,index/2) + '***';
    }

  }

}
