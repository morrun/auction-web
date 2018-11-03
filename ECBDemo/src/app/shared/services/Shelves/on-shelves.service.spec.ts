import { TestBed } from '@angular/core/testing';

import { OnShelvesService } from './on-shelves.service';

describe('OnShelvesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OnShelvesService = TestBed.get(OnShelvesService);
    expect(service).toBeTruthy();
  });
});
