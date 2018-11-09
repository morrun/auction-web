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
import { OnSaleProductsComponent } from './users/view-my-product/on-sale-products/on-sale-products.component';
import { ProductViewPipe } from './shared/pipes/productView/product-view.pipe';
import { WantToBuyComponent } from './users/view-my-product/want-to-buy/want-to-buy.component';
import { UserIdPipe } from './shared/pipes/userId/user-id.pipe';
import { EmailTransPipe } from './shared/pipes/userId/email-trans.pipe';
import { ProductIdToTitlePipe } from './shared/pipes/product/product-id-to-title.pipe';
import {ModifyMyProductComponent} from './users/view-my-product/on-sale-products/modify-my-product/modify-my-product.component';
import { AfterAcceptPriceComponent } from './users/view-my-product/want-to-buy/after-accept-price/after-accept-price.component';
import { SoldProductComponent } from './users/view-my-product/sold-product/sold-product.component';
import { SoldProductPipe } from './shared/pipes/productView/sold-product.pipe';
import { ReloadDialogComponent } from './users/view-my-product/sold-product/reload-dialog/reload-dialog.component';
import { ProductTOShelveTypePipe } from './shared/pipes/product/product-toshelve-type.pipe';

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
    OnSaleProductsComponent,
    ProductViewPipe,
    WantToBuyComponent,
    UserIdPipe,
    EmailTransPipe,
    ProductIdToTitlePipe,
    ModifyMyProductComponent,
    AfterAcceptPriceComponent,
    SoldProductComponent,
    SoldProductPipe,
    ReloadDialogComponent,
    ProductTOShelveTypePipe,
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
  entryComponents: [ReloadDialogComponent, AfterAcceptPriceComponent, ModifyMyProductComponent, DialogForProductComponent]
})
export class AppModule { }
