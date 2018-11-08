import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ProductsComponent} from './products/products.component';
import {LoginComponent} from './users/login/login.component';
import {RegisterComponent} from './users/register/register.component';
import {CounterofferProductsComponent} from './products/counteroffer-products/counteroffer-products.component';
import {AuctionProductsComponent} from './products/auction-products/auction-products.component';
import {ProductsDetailComponent} from './products/products-detail/products-detail.component';
import {SellProductsComponent} from './users/sell-products/sell-products.component';
import {ViewMyProductComponent} from './users/view-my-product/view-my-product.component';


const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'products',
    component: ProductsComponent,
  },
  {
    path: 'counterofferProducts',
    component: CounterofferProductsComponent
  },
  {
    path: 'auctionProducts',
    component: AuctionProductsComponent
  },
  {
    path: 'users',
    children: [
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'register',
        component: RegisterComponent
      }
    ]
  },
  {
    path: 'user-info',
    loadChildren: '../app/users/user-info/user-info.module#UserInfoModule'
  },
  {
    path: 'product-detail/:id',
    component: ProductsDetailComponent
  },
  {
    path: 'sell-products',
    component: SellProductsComponent
  },
  {
    path: 'view-my-product',
    component: ViewMyProductComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
