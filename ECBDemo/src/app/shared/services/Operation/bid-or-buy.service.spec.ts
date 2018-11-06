import { TestBed } from '@angular/core/testing';

import { BidOrBuyService } from './bid-or-buy.service';

describe('BidOrBuyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BidOrBuyService = TestBed.get(BidOrBuyService);
    expect(service).toBeTruthy();
  });
});
