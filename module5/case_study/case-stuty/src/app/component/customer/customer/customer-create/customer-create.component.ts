import {Component, OnInit, Inject} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../../../model/entity/customer/customer';
import {CustomerType} from '../../../../model/entity/customer/customer-type';
import {CustomerService} from '../../../../model/service/customer/customer.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customer!: Customer;
  customerForm: FormGroup;
  customerTypes: CustomerType[];
  title;
  constructor(private fb: FormBuilder, private customerService: CustomerService, public dialogRef: MatDialogRef<CustomerCreateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Customer) {
  }

  ngOnInit(): void {
    this.initCustomer();
    this.customerForm = this.fb.group({
      id: [this.customer.id],
      name: [this.customer.name, Validators.required],
      birthDay: [this.customer.birthDay, Validators.required],
      idCard: [this.customer.idCard, Validators.required],
      gender: [this.customer.gender],
      phone: [this.customer.phone, Validators.pattern('^\\(090\\)\\d{7}$|^(091)\\d{7}$|^(\\(84\\)\\+90)\\d{7}$|^(\\(84\\)\\+91)\\d{7}$')],
      maKhachHang: [this.customer.maKhachHang, Validators.pattern('^KH-\\d{4}$')],
      address: [this.customer.address, Validators.required],
      email: [this.customer.email, Validators.email],
      customerType: this.fb.group({id: [this.customer.customerType.id] , name: [this.customer.customerType.name] })
    });
    this.getAllCustomerType();
  }
  onSubmit() {
    if (this.customerForm.valid) {
     this.customer = this.customerForm.value;
     this.dialogRef.close(this.customer);
    }
  }
    getAllCustomerType() {
         this.customerService.getAllCustomerType().subscribe( result => {
           this.customerTypes = result;
         });
    }
  onNoClick(): void {
    this.dialogRef.close();
  }
  initCustomer() {
    if (this.data !== null) {
      this.customer = this.data;
      this.title = 'Edit';
    } else {
      this.customer = {
        id: '',
      name: '',
      birthDay: '',
      idCard: '',
      gender: '',
      phone: '',
      maKhachHang: '',
      address: '',
      email: '',
      customerType: {id: 1 , name: ''},
      };
      this.title = 'Create';
    }
  }
}
