import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header/header.component';
import { HomeComponent } from './component/home/home/home.component';
import { CustomerComponent } from './component/customer/customer/customer.component';
import { EmployeeComponent } from './component/employee/employee/employee.component';
import { CustomerTypeComponent } from './component/customer/customer-type/customer-type.component';
import { CustomerListComponent } from './component/customer/customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './component/customer/customer/customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './component/customer/customer/customer-create/customer-create.component';
import { EmployeeEditComponent } from './component/employee/employee/employee-edit/employee-edit.component';
import { EmployeeListComponent } from './component/employee/employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './component/employee/employee/employee-create/employee-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CustomerComponent,
    EmployeeComponent,
    CustomerTypeComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerCreateComponent,
    EmployeeEditComponent,
    EmployeeListComponent,
    EmployeeCreateComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }