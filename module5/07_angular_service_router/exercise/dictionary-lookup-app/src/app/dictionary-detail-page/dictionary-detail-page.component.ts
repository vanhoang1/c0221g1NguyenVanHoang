import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {IWord} from '../i-word';
import {DictionaryService} from '../service/dictionary.service';

@Component({
  selector: 'app-dictionary-detail-page',
  templateUrl: './dictionary-detail-page.component.html',
  styleUrls: ['./dictionary-detail-page.component.css']
})
export class DictionaryDetailPageComponent implements OnInit {
  wordDetail: IWord;

  constructor(private activatedRoute: ActivatedRoute, private dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get('word');
      this.wordDetail = this.dictionaryService.translate(word);
    });
  }
}
