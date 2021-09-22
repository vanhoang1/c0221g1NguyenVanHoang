import {Component, OnInit} from '@angular/core';
import {Question} from '../model/question';
import {QuestionService} from '../question.service';

@Component({
  selector: 'app-list-question',
  templateUrl: './list-question.component.html',
  styleUrls: ['./list-question.component.css']
})
export class ListQuestionComponent implements OnInit {
  questions: Question[] = [];
  pages: Array<any> = [];
  page = 0;
  constructor(private questionService: QuestionService) {
  }

  ngOnInit(): void {
    this.getAllQuestion();
  }
  getAllQuestion() {
    this.questionService.getAllQuestions(this.page).subscribe(value => {
      this.questions = value.content;
      this.pages = new Array<any>(value.totalPages);
    });

  }

  del() {

  }

  previous() {

  }

  setPage(i: number) {

  }

  next() {

  }
}
