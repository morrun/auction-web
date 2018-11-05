import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UserInfoComponent} from './user-info.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

import {
  MatBottomSheetModule,
  MatButtonModule, MatCardModule,
  MatCheckboxModule, MatDialogModule,
  MatDividerModule, MatFormFieldModule,
  MatGridListModule, MatIconModule, MatInputModule, MatListModule,
  MatRadioModule, MatSelectModule,
  MatSidenav,
  MatSidenavModule
} from '@angular/material';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ModifyProfileComponent } from './modify-profile/modify-profile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import { DialogChangePhotoComponent } from './dialog-change-photo/dialog-change-photo.component';


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
    MatDialogModule,
    RouterModule.forChild(routes)
  ],
  declarations: [UserProfileComponent, UserInfoComponent, ModifyProfileComponent, ChangePasswordComponent, DialogChangePhotoComponent],
  entryComponents:[DialogChangePhotoComponent]
})
export class UserInfoModule { }
