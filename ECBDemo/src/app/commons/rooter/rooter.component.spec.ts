import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RooterComponent } from './rooter.component';

describe('RooterComponent', () => {
  let component: RooterComponent;
  let fixture: ComponentFixture<RooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
