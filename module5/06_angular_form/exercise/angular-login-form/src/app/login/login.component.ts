import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user: User = new User({email: 'abc@gmail.com' , password: '123'});
  userForm: FormGroup;
  constructor(private us: FormBuilder) { }

  ngOnInit(): void {
    this.userForm = this.us.group({
      email: ['', [Validators.email , Validators.required]],
      password: ['', Validators.required]
    });
  }
  onSubmit() {
    if (this.userForm.valid) {
      if (this.userForm.value.email === this.user.email && this.userForm.value.password === this.user.password ) {
        alert('bạn đăng nhập thành công');
      } else {
        alert('sai password hoặc email \n nhập đúng \n email : abc@gmail.com \n password: 123');
      }
    } else {
        alert('các trường phải đúng định dạng');
    }
  }
}
