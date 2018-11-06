import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMyProductComponent } from './view-my-product.component';

describe('ViewMyProductComponent', () => {
  let component: ViewMyProductComponent;
  let fixture: ComponentFixture<ViewMyProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMyProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMyProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
