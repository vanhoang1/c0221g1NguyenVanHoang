import { Injectable } from '@angular/core';
import {CustomerType} from '../../entity/customer/customer-type';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customerTypes: CustomerType[] = [{
    id: 1,
    name: 'silver'
  }, {
    id: 2,
    name: 'gold'
  }, {
    id: 3,
    name: 'platinum'
  }, {
    id: 4,
    name: 'diamond'
  }];
  constructor() { }
  getAllCustomerType(): CustomerType[]  {
    return this.customerTypes;
  }
  findCustomerTypeById(id: number): CustomerType {
    return this.customerTypes.find(value => value.id === id);
  }
}
