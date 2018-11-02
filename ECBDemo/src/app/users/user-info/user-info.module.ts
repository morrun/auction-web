import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UserInfoComponent} from './user-info.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

import {
  MatBottomSheetModule,
  MatButtonModule, MatCardModule,
  MatCheckboxModule,
  MatDividerModule, MatFormFieldModule,
  MatGridListModule, MatIconModule, MatInputModule, MatListModule,
  MatRadioModule, MatSelectModule,
  MatSidenav,
  MatSidenavModule
} from '@angular/material';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { UpLoadImageComponent } from './user-profile/up-load-image/up-load-image.component';
import { ModifyProfileComponent } from './modify-profile/modify-profile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import {FlexLayoutModule} from '@angular/flex-layout';


const routes: Routes = [
  {
    path: '',
    component: UserInfoComponent,
    children: [
      {
        path: 'user-profile',
        component: UserProfileComponent
      },
      {
        path: 'modify-profile',
        component: ModifyProfileComponent
      },
      {
        path: 'change-password',
        component: ChangePasswordComponent
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
    MatCardModule,
    FlexLayoutModule,
    FormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [UserProfileComponent, UserInfoComponent,UpLoadImageComponent, ModifyProfileComponent, ChangePasswordComponent],
  entryComponents: [UpLoadImageComponent]
})
export class UserInfoModule { }
