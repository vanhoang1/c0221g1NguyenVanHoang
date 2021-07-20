import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color;
  constructor() { }

  ngOnInit(): void {
  }
  showColor(e){
    this.color = e.target.value;
  }
}
