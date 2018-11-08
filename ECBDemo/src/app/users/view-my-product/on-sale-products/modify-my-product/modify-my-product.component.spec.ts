import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyMyProductComponent } from './modify-my-product.component';

describe('ModifyMyProductComponent', () => {
  let component: ModifyMyProductComponent;
  let fixture: ComponentFixture<ModifyMyProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyMyProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyMyProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
