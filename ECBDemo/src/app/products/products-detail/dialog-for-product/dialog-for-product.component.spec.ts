import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogForProductComponent } from './dialog-for-product.component';

describe('DialogForProductComponent', () => {
  let component: DialogForProductComponent;
  let fixture: ComponentFixture<DialogForProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogForProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogForProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
