import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../../../model/customer/customer';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customer: Customer;
  customerForm: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.customerForm = this.fb.group({
      id: [''],
      name: ['', Validators.required],
      birthDay: ['', Validators.required],
      idCard: [''],
      gender: [''],
      phone: [''],
      maKhachHang: [''],
      address: [''],
      email: [''],
    });
  }
  onSubmit() {
    if (this.customerForm.valid) {
     this.customer = new Customer(this.customerForm.value);
    }}
}
