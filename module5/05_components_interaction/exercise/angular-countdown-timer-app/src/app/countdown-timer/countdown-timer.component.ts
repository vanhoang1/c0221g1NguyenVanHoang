import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  @Input() timeCount;
  count = 0;
  id ;
  @Output() countdownTime = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  startCount() {
    if (this.count === 0) {
      this.count = this.timeCount;
    }
    this.countTime();
  }
  stopCount() {
   clearInterval(this.id);
  }
  resetCount() {
    this.count = this.timeCount;
    this.startCount();
  }
  outTime() {
    if (this.count !== 0) {
    this.countdownTime.emit(this.count);
    this.count--;
    } else {
      this.countdownTime.emit('Time out');
      this.stopCount();
      clearInterval(this.id);
    }
  }
  countTime() {
    this.id = setInterval(() => {
        this.outTime();
      }, 1000);
  }
}
