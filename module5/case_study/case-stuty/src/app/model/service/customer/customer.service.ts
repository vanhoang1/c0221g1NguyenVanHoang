import {Injectable} from '@angular/core';
import {CustomerType} from '../../entity/customer/customer-type';
import {Customer} from '../../entity/customer/customer';

import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
const API_URL = `${environment.apiUrl}`;
import {environment} from '../../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) {
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(`${API_URL}/customerTypes`);
  }

  findCustomerTypeById(id: number): Observable<CustomerType> {
    return this.http.get<CustomerType>(`${API_URL}/customerTypes/${id}`);
  }

  getAll(): Observable<Customer[]> {
   return  this.http.get<Customer[]>(API_URL + '/customers');
  }
  create(value): Observable<Customer[]> {
    return  this.http.post<Customer[]>(API_URL + '/customers', value);
  }
  update(value, id) {
    return  this.http.put<Customer[]>(`${API_URL}/customers/${id}`, value);
  }
  remove(id) {
   return this.http.delete<Customer[]>(`${API_URL}/customers/${id}`);
  }
}
