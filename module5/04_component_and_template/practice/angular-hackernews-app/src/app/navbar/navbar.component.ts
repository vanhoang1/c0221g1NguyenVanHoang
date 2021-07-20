import { Component, OnInit } from '@angular/core';
import {NavList} from '../nav-list';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  navLists: NavList[] = [{
    name: 'new',
    url: 'https://news.ycombinator.com/newest'
  }, {
    name: 'past',
    url: 'https://news.ycombinator.com/front'
  }, {
    name: 'ask',
    url: 'https://news.ycombinator.com/newcomments'
  }, {
    name: 'show',
    url: 'https://news.ycombinator.com/newcomments'
  }, {
    name: 'job',
    url: 'https://news.ycombinator.com/newcomments'
  }];
  constructor() { }

  ngOnInit(): void {
  }

}
