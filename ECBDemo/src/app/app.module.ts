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
import { ShelvesProductPipe } from './shared/pipes/shelves-product.pipe';
import { CounterofferProductsComponent } from './products/counteroffer-products/counteroffer-products.component';
import { AuctionProductsComponent } from './products/auction-products/auction-products.component';
import { ProductsDetailComponent } from './products/products-detail/products-detail.component';
import { SellProductsComponent } from './users/sell-products/sell-products.component';
import { ProductImagePipe } from './shared/pipes/product-image.pipe';
import { DialogForProductComponent } from './products/products-detail/dialog-for-product/dialog-for-product.component';
import { ViewMyProductComponent } from './users/view-my-product/view-my-product.component';

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
    ShelvesProductPipe,
    CounterofferProductsComponent,
    AuctionProductsComponent,
    ProductsDetailComponent,
    SellProductsComponent,
    ProductImagePipe,
    DialogForProductComponent,
    ViewMyProductComponent,
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
  bootstrap: [AppComponent],
  entryComponents: [DialogForProductComponent]
})
export class AppModule { }
