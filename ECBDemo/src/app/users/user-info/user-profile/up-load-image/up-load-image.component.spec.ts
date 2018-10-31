import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpLoadImageComponent } from './up-load-image.component';

describe('UpLoadImageComponent', () => {
  let component: UpLoadImageComponent;
  let fixture: ComponentFixture<UpLoadImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpLoadImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpLoadImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
