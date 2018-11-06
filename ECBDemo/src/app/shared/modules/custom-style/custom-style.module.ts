import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatBadgeModule,
  MatButtonModule, MatCardModule,
  MatCheckboxModule, MatDatepickerModule, MatDialogModule, MatDrawer, MatExpansionModule,
  MatIconModule,
  MatInputModule,
  MatListModule, MatMenuModule, MatNativeDateModule, MatPaginatorModule, MatRadioModule, MatSelectModule,
  MatSidenavModule, MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {CdkTableModule} from '@angular/cdk/table';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  imports: [
    CommonModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatDialogModule,
    MatSelectModule,
    MatBadgeModule,
    MatRadioModule,
    MatExpansionModule,
    MatDatepickerModule,
    CdkTableModule,
    FlexLayoutModule,
    MatMenuModule,
    MatNativeDateModule,
  ],
  exports: [
    MatButtonModule,
    MatCheckboxModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatDialogModule,
    MatSelectModule,
    MatBadgeModule,
    MatRadioModule,
    MatExpansionModule,
    CdkTableModule,
    FlexLayoutModule,
    MatPaginatorModule,
    MatMenuModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ]
})
export class CustomStyleModule { }
