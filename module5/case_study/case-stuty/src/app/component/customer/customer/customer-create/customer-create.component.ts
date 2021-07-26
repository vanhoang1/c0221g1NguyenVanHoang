import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../../../model/entity/customer/customer';
import {CustomerType} from '../../../../model/entity/customer/customer-type';
import {CustomerService} from '../../../../model/service/customer/customer.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customer: Customer;
  customerForm: FormGroup;
  customerTypes: CustomerType[];
  constructor(private fb: FormBuilder, private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerForm = this.fb.group({
      id: [''],
      name: ['', Validators.required],
      birthDay: ['', Validators.required],
      idCard: ['', Validators.required],
      gender: [''],
      phone: ['', Validators.pattern('^\\(090\\)\\d{7}$|^(091)\\d{7}$|^(\\(84\\)\\+90)\\d{7}$|^(\\(84\\)\\+91)\\d{7}$')],
      maKhachHang: ['', Validators.pattern('^KH-\\d{4}$')],
      address: ['', Validators.required],
      email: ['', Validators.email],
      customerType: ['']
    });
    this.getAllCustomerType();
  }
  onSubmit() {
    if (this.customerForm.valid) {
     this.customer = new Customer(this.customerForm.value);
    }
  }
    changeCustomerType(id) {
      console.log(this.customerService.findCustomerTypeById(id));
      this.customer.customerType = this.customerService.findCustomerTypeById(id);
      console.log(this.customer);

    }
    getAllCustomerType() {
        this.customerTypes = this.customerService.getAllCustomerType();
    }
}
