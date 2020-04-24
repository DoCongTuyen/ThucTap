import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertUpdateIssueComponent } from './insert-update-issue.component';

describe('InsertUpdateIssueComponent', () => {
  let component: InsertUpdateIssueComponent;
  let fixture: ComponentFixture<InsertUpdateIssueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertUpdateIssueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertUpdateIssueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
