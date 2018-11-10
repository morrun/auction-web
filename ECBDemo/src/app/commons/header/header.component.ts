import {ChangeDetectorRef, Component, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from '../../shared/services/auth.service';
import {Router} from '@angular/router';
import {UserShowService} from '../../shared/services/user-show.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  show = false;
  isAdmin = false;
  constructor(
    public authService: AuthService,
    private router: Router,
    public sh: UserShowService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {

  }
  assignAdmin() {
    this.authService.checkRole().subscribe( res => {
     this.isAdmin = res;
    });
    //this.cdr.detectChanges();
  }
  ngOnDestroy() {
  }
  logout() {
    this.authService.logout()
      .subscribe((res: {success: true}) => {
        if (res.success) {
          this.router.navigate(['/home']);
          this.authService.userSubject.next(null);
        }
      });
    this.isAdmin = false;
  }

}
