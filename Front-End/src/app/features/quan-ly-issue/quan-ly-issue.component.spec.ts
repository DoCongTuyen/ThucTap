import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuanLyIssueComponent } from './quan-ly-issue.component';

describe('QuanLyIssueComponent', () => {
  let component: QuanLyIssueComponent;
  let fixture: ComponentFixture<QuanLyIssueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuanLyIssueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuanLyIssueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
