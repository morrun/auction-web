import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterAcceptPriceComponent } from './after-accept-price.component';

describe('AfterAcceptPriceComponent', () => {
  let component: AfterAcceptPriceComponent;
  let fixture: ComponentFixture<AfterAcceptPriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterAcceptPriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterAcceptPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
