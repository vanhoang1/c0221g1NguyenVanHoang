import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {QuestionService} from '../question.service';
import {ToastrService} from 'ngx-toastr';
import {Question} from '../model/question';
import {QuestionType} from '../model/question-type';
import {User} from '../model/user';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {
  userCreate: User = {
    userId: 1,
    userName: 'Hoàng'
  };
  userUpdate: User = {
    userId: 1,
    userName: 'Hoàng'
  };
  typeQ = 'create';
  formQuestion: FormGroup;
  question: Question = {
    questionId: '',
    questionTitle: '',
    questionContent: '',
    questionAnswer: '',
    dateQuestion: '',
    questionType: {
      questionTypeId: ''
    },
    userCreated: {
      userId: ''
    },
    userFeedBack: {
      userId: ''
    },
    status: '',
    flag: '',
  };
  questionTypes: QuestionType[] = [];

  constructor(private fb: FormBuilder,
              private datePipe: DatePipe,
              public dialog: MatDialog,
              private router: Router,
              private route: ActivatedRoute,
              private questionService: QuestionService,
              private toastr: ToastrService,
              private el: ElementRef) {
  }

  ngOnInit(): void {
    this.getAllType();
    this.initForm();
    this.getQuestion();
  }

  get currentDate() {
    return this.datePipe.transform(new Date(), 'yyyy-MM-dd');
  }

  getQuestion() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id != null) {
      this.typeQ = 'edit';
      this.questionService.getById(id).subscribe(value => {
        this.userCreated.get('userId').setValue(value.userCreated.userId);
        this.questionTitle.setValue(value.questionTitle);
        this.questionId.setValue(value.questionId);
        this.questionContent.setValue(value.questionContent);
        this.questionAnswer.setValue(value.questionAnswer);
        this.userFeedBack.get('userId').setValue(this.userUpdate.userId);
      });
    } else {
      this.userUpdate = {
        userId: '',
        userName: ''
      };
      this.userCreated.get('userId').setValue(this.userCreate.userId);
      this.userFeedBack.get('userId').setValue(this.userUpdate.userId);
    }
  }
  get userCreated() {
    return this.formQuestion.get('userCreated');
  }
  get userFeedBack() {
    return this.formQuestion.get('userFeedBack');
  }
  get questionTitle() {
    return this.formQuestion.get('questionTitle');
  }
  get questionContent() {
    return this.formQuestion.get('questionContent');
  }
  get questionAnswer() {
    return this.formQuestion.get('questionAnswer');
  }
  get questionType() {
    return this.formQuestion.get('questionType');
  }
  get dateQuestion() {
    return this.formQuestion.get('dateQuestion');
  }
  get questionId() {
    return this.formQuestion.get('questionId');
  }
  initForm() {
    const newsWriteDay = this.currentDate;
    this.formQuestion = this.fb.group({
      questionId: [''],
      questionTitle: [''],
      questionContent: [''],
      questionAnswer: [''],
      dateQuestion: [newsWriteDay],
      questionType: this.fb.group({
        questionTypeId: ['']
      }),
      userCreated: this.fb.group({
        userId: ['']
      }),
      userFeedBack: this.fb.group({
        userId: ['']
      }),
      status: [''],
      flag: [''],
    });
  }

  getAllType() {
    this.questionService.getAllQuestionType().subscribe(value => {
      this.questionTypes = value;
    });
  }
  save() {
    if( this.typeQ === 'create') {
      this.questionService.create(this.formQuestion.value).subscribe(value => {
        this.toastr.success(' thành công', 'Thành công');
        this.router.navigateByUrl('');
      });
    }else {
      this.questionService.update(this.formQuestion.value, this.formQuestion.value.questionId).subscribe(value => {
        this.toastr.success(' thành công', 'Thành công');
        this.router.navigateByUrl('');
      });
    }

  }
}
