import { TestBed } from '@angular/core/testing';

import { VdpService } from './vdp.service';

describe('VdpService', () => {
  let service: VdpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VdpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
