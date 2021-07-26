import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdown-time-parent',
  templateUrl: './countdown-time-parent.component.html',
  styleUrls: ['./countdown-time-parent.component.css']
})
export class CountdownTimeParentComponent implements OnInit {
  timeOut: number;
  timeIn: number;
  constructor() { }

  ngOnInit(): void {
  }
  outTime(value) {
    this.timeOut = value;
  }
}
