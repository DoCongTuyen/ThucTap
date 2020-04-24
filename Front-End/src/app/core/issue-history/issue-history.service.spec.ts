import { TestBed } from '@angular/core/testing';

import { IssueHistoryService } from './issue-history.service';

describe('IssueHistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IssueHistoryService = TestBed.get(IssueHistoryService);
    expect(service).toBeTruthy();
  });
});
