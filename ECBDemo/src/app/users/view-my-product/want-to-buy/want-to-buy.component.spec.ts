import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WantToBuyComponent } from './want-to-buy.component';

describe('WantToBuyComponent', () => {
  let component: WantToBuyComponent;
  let fixture: ComponentFixture<WantToBuyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WantToBuyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WantToBuyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
