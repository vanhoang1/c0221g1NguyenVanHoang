import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
 public numFist;
 public numSecond;
 public  result;
  constructor() { }

  ngOnInit(): void {
  }
  calculation(c){
    switch (c) {
      case '+': {
        this.result = this.numFist - -this.numSecond;
        break;
      }
      case '-': {
         this.result = this.numFist - this.numSecond;
         break;
      }
      case 'x': {
        this.result = this.numFist * this.numSecond;
        break;
      }
      case '/': {
        this.result = this.numFist / this.numSecond;
        break;
      }
    }
  }
}
