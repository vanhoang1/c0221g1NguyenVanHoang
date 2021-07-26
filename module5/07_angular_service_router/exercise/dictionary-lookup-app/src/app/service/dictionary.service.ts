import { Injectable } from '@angular/core';
import {IWord} from '../i-word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionary: IWord[] = [
    {word: 'cat', mean: 'mèo'},
    {word: 'dog', mean: 'chó'},
    {word: 'banana', mean: 'chuối'},
    {word: 'ayame', mean: 'oni'}
    ];

  constructor() { }
  translate(word: string): IWord {
   return  this.dictionary.find(value => value.word === word);
  }
  getAll(): IWord[] {
    return this.dictionary;
  }
  findWord(keyword: string): IWord[] {
    return this.dictionary.filter(value => value.word.includes(keyword));
  }
}
