import {CustomerType} from './customer-type';

export class Customer {
  public constructor(init?: Partial<Customer>) {
    Object.assign(this, init);
  }
  id?: number;
  name: string;
  birthDay: string;
  idCard: string;
  gender: string;
  phone: string;
  maKhachHang: string;
  address: string;
  email: string;
  customerType: CustomerType ;
}
