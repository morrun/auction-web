import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CounterofferProductsComponent } from './counteroffer-products.component';

describe('CounterofferProductsComponent', () => {
  let component: CounterofferProductsComponent;
  let fixture: ComponentFixture<CounterofferProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CounterofferProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CounterofferProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
