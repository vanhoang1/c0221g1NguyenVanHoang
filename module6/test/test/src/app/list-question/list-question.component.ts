import {Component, OnInit} from '@angular/core';
import {Question} from '../model/question';
import {QuestionService} from '../question.service';
import Swal from 'sweetalert2';
import {LoginComponent} from '../login/login.component';
import {MatDialog} from '@angular/material/dialog';
@Component({
  selector: 'app-list-question',
  templateUrl: './list-question.component.html',
  styleUrls: ['./list-question.component.css']
})
export class ListQuestionComponent implements OnInit {
  questions: Question[] = [];
  pages: Array<any> = [];
  page = 0;
  constructor(private questionService: QuestionService,
              public dialog: MatDialog) {
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

  del(id) {
    Swal.fire({
      title: 'Bạn có muốn xóa không',
      text: 'ok xóa',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Ok',
      cancelButtonText: 'Không'
    }).then((result) => {
      if (result.isConfirmed) {
        this.questionService.delete(id).subscribe(value => {
          this.ngOnInit();
        });
      }
    });
  }

  previous() {
    if (this.page === 0) {
      this.page = 0;
    } else {
      this.page = this.page - 1;
      this.getAllQuestion();
    }
  }

  setPage(i: number) {
    this.page = i;
    this.getAllQuestion();
  }

  next() {
    if (this.page > this.pages.length - 2) {
      // this.page = this.pages.length - 1;
    } else {
      this.page = this.page + 1;
      this.getAllQuestion();
    }
  }

  login() {
    const dialogRef = this.dialog.open(LoginComponent, {
      autoFocus: false,
      maxHeight: '90vh',
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }
}
