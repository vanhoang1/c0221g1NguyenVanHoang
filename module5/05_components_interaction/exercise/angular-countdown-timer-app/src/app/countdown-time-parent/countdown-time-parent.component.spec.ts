import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimeParentComponent } from './countdown-time-parent.component';

describe('CountdownTimeParentComponent', () => {
  let component: CountdownTimeParentComponent;
  let fixture: ComponentFixture<CountdownTimeParentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimeParentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimeParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
