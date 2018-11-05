import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuctionProductsComponent } from './auction-products.component';

describe('AuctionProductsComponent', () => {
  let component: AuctionProductsComponent;
  let fixture: ComponentFixture<AuctionProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuctionProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuctionProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
