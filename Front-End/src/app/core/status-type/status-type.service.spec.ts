import { TestBed } from '@angular/core/testing';

import { StatusTypeService } from './status-type.service';

describe('StatusTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StatusTypeService = TestBed.get(StatusTypeService);
    expect(service).toBeTruthy();
  });
});
