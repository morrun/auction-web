import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CustomStyleModule} from './shared/modules/custom-style/custom-style.module';
import { HeaderComponent } from './commons/header/header.component';
import { RooterComponent } from './commons/rooter/rooter.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { DropdownDirective } from './shared/directives/dropdown.directive';
import { LoginComponent } from './users/login/login.component';
import { RegisterComponent } from './users/register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UsernamePipePipe } from './shared/pipes/username-pipe.pipe';
import { ProductTypePipe } from './shared/pipes/product-type.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RooterComponent,
    HomeComponent,
    ProductsComponent,
    DropdownDirective,
    LoginComponent,
    RegisterComponent,
    UsernamePipePipe,
    ProductTypePipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomStyleModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
