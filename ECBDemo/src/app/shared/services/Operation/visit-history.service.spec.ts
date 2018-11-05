import { TestBed } from '@angular/core/testing';

import { VisitHistoryService } from './visit-history.service';

describe('VisitHistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VisitHistoryService = TestBed.get(VisitHistoryService);
    expect(service).toBeTruthy();
  });
});
