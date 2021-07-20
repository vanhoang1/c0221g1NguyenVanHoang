import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  count = 0;
  id ;
  constructor() { }

  ngOnInit(): void {
  }
  startCount() {
    this.id = setInterval(() => {
    this.countTime();
    } , 1000);
  }
  countTime() {
    this.count++;
  }
  stopCount() {
    clearInterval(this.id);
  }
  resetCount() {
    this.count = 0;
  }
}
