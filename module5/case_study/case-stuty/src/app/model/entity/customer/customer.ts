import {CustomerType} from './customer-type';

export interface Customer {
  id?;
  name?;
  birthDay?;
  idCard?;
  gender?;
  phone?;
  maKhachHang?;
  address?;
  email?;
  customerType?: CustomerType ;
}
