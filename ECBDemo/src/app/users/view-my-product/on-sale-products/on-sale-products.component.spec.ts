import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnSaleProductsComponent } from './on-sale-products.component';

describe('OnSaleProductsComponent', () => {
  let component: OnSaleProductsComponent;
  let fixture: ComponentFixture<OnSaleProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnSaleProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnSaleProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
