import { Component, OnInit } from '@angular/core';
import {NavList} from "../nav-list";
import {FooterList} from "../footer-list";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  footerLists: FooterList[] = [{
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
