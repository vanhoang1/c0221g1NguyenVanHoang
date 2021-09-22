import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {QuestionService} from '../question.service';
import {User} from '../model/user';
import {LocalStorageService} from 'ngx-webstorage';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  u: User;
  constructor(private storage: LocalStorageService,
              public dialogRef: MatDialogRef<LoginComponent>,
              private questionService: QuestionService, private toastr: ToastrService) { }
  user;
  pass;
  ngOnInit(): void {
  }

  login() {
    this.u = {
      userName: this.user,
      password: this.pass
    };
    this.questionService.checkLogin(this.u).subscribe(value => {
      if (value != null) {
        this.storage.store('key', value);
        this.dialogRef.close();
      }else {
        this.toastr.error('sai tên hoặc mật khẩu', '')
      }
    });
  }
}
