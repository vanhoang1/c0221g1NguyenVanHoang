import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-rating-unit',
  templateUrl: './rating-unit.component.html',
  styleUrls: ['./rating-unit.component.css']
})
export class RatingUnitComponent implements OnInit {
  @Input() value: number;
  @Input() active: boolean;
  @Output() changeColor = new EventEmitter<number>();
  constructor() { }

  ngOnInit(): void {
  }
  changeColorByClick() {
   this.changeColor.emit(this.value);
  }
}
