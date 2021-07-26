import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryDetailPageComponent } from './dictionary-detail-page.component';

describe('DictionaryDetailPageComponent', () => {
  let component: DictionaryDetailPageComponent;
  let fixture: ComponentFixture<DictionaryDetailPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionaryDetailPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryDetailPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
