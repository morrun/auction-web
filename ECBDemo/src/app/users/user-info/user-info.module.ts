import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UserInfoComponent} from './user-info.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {
  MatBottomSheetModule,
  MatButtonModule,
  MatCheckboxModule,
  MatDividerModule, MatFormFieldModule,
  MatGridListModule, MatIconModule, MatInputModule, MatListModule,
  MatRadioModule, MatSelectModule,
  MatSidenav,
  MatSidenavModule
} from '@angular/material';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import { UpLoadImageComponent } from './user-profile/up-load-image/up-load-image.component';

const routes: Routes = [
  {
    path: '',
    component: UserInfoComponent,
    children: [
      {
        path: 'user-profile',
        component: UserProfileComponent
      }
    ]
  }
];
@NgModule({
  imports: [
    CommonModule,
    MatSidenavModule,
    MatButtonModule,
    MatDividerModule,
    MatGridListModule,
    MatBottomSheetModule,
    MatListModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatRadioModule,
    MatSelectModule,
    MatIconModule,
    ReactiveFormsModule,
    MatInputModule,
    RouterModule.forChild(routes)
  ],
  declarations: [UserProfileComponent, UserInfoComponent,UpLoadImageComponent],
  entryComponents: [UpLoadImageComponent]
})
export class UserInfoModule { }
