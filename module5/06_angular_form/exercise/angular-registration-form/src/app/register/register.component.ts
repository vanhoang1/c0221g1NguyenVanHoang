import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../user';
import {checkMatchValidator} from './check-pass-confirm';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  userForm: FormGroup;
  constructor(private us: FormBuilder) { }

  ngOnInit(): void {
    this.userForm = this.us.group({
      email: ['', [Validators.email , Validators.required]],
      password: ['', [Validators.required, Validators.minLength(3)]],
      passwordConfirm : ['', [Validators.required, Validators.minLength(3)]],
      age: ['', Validators.min(18)],
      country: ['', Validators.required],
      gender: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]],
    }, {
      validators: checkMatchValidator('password', 'passwordConfirm')
    });
  }
  onSubmit() {
    if (this.userForm.valid) {
      this.user = new User(this.userForm.value);
      alert('đăng kí thành công \n' +
        'email:' + this.user.email + '\n' +
        'password:' + this.user.password + '\n' +
        'age:' + this.user.age + '\n' +
        'country:' + this.user.country + '\n' +
        'gender:' + this.user.gender + '\n' +
        'phone:' + this.user.phone );
    } else {
      alert('điền đầy đủ thông tin');
    }
  }
}
