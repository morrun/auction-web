import { TestBed } from '@angular/core/testing';

import { OperationViewService } from './operation-view.service';

describe('OperationViewService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OperationViewService = TestBed.get(OperationViewService);
    expect(service).toBeTruthy();
  });
});
