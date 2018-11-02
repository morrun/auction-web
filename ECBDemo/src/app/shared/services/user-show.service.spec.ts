import { TestBed } from '@angular/core/testing';

import { UserShowService } from './user-show.service';

describe('UserShowService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserShowService = TestBed.get(UserShowService);
    expect(service).toBeTruthy();
  });
});
