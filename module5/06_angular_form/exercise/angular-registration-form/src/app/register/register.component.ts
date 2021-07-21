import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../user';

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
      email: this.us.control('', Validators.email),
      age: this.us.control('', Validators.min(1)),
      country: this.us.control(''),
      gender: this.us.control(''),
    });
  }
  onSubmit() {
    if (this.userForm.valid) {
      this.user = new User(this.userForm.value);
      console.log(this.user);
    }
  }
}
