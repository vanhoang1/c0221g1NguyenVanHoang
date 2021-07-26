import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit(): void {
  }
  create() {
    this.router.navigate(['/customers/create']);
  }
}
