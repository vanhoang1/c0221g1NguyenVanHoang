import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../../service/dictionary.service';
import {IWord} from '../../i-word';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionary: IWord[] = [];
  keyword: string;
  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.dictionary = this.dictionaryService.getAll();
  }
  findWord(event) {
    this.keyword = event.target.value;
    this.dictionary = this.dictionaryService.findWord(this.keyword);
  }
}
