import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'usernamePipe'
})
export class UsernamePipePipe implements PipeTransform {

  transform(username: string): any {
    const index = username.split('').findIndex((a) => {
      return a === '@';
    });
    return username.slice(0,index);
  }

}
