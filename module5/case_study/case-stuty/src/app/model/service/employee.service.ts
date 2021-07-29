import {Injectable} from '@angular/core';
import {Employee} from '../entity/employee/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employees: Employee[] = [{
    id: 1,
    name: 'Hoàng',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }, {
    id: 2,
    name: 'Minh',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }, {
    id: 3,
    name: 'Tâm',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }, {
    id: 4,
    name: 'Trang',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }, {
    id: 5,
    name: 'Thảo',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }, {
    id: 6,
    name: 'Long',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }, {
    id: 7,
    name: 'Bình',
    position: {id: 1, name: 'Nhân Viên'},
    education: {id: 1, name: 'Đại Học'},
    division: {id: 1, name: 'Sale'},
    birthDay: '1996-02-08',
    idCard: '123431',
    salary: '55555',
    phone: '(090)12332112',
    address: 'Đà Nẵng',
    email: 'abc@gmail.com'
  }];

  constructor() {
  }

  getAllEmployee() {
    return this.employees;
  }
}
