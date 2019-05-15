import { TestBed } from '@angular/core/testing';

import { CigarrillosService } from './cigarrillos.service';

describe('CigarrillosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CigarrillosService = TestBed.get(CigarrillosService);
    expect(service).toBeTruthy();
  });
});
