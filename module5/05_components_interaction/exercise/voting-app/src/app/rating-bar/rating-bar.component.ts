import { Component, OnInit } from '@angular/core';
import {IRatingUnit} from '../irating-unit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  ratingBar: IRatingUnit[] = [] ;
  constructor() { }
  vote: number;
  ngOnInit(): void {
    for (let i = 1 ; i <= 10 ; i++) {
      const rating: IRatingUnit = {value : i, active : false };
      this.ratingBar.push(rating);
    }
  }
  changeColor(value: number) {
    this.vote = value;
    const  index = this.ratingBar.findIndex(r => r.value === value );
    for (let i = 0 ; i < 10 ; i++) {
      this.ratingBar[i].active = i <= index;
    }
  }
}
