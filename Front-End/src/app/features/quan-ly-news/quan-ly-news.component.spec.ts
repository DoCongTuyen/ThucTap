import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuanLyNewsComponent } from './quan-ly-news.component';

describe('QuanLyNewsComponent', () => {
  let component: QuanLyNewsComponent;
  let fixture: ComponentFixture<QuanLyNewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuanLyNewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuanLyNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
