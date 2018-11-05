import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogChangePhotoComponent } from './dialog-change-photo.component';

describe('DialogChangePhotoComponent', () => {
  let component: DialogChangePhotoComponent;
  let fixture: ComponentFixture<DialogChangePhotoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogChangePhotoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogChangePhotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
