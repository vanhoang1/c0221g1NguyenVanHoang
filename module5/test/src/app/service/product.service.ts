import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {environment} from '../../environments/environment';
import {Category} from '../model/category';
const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Product[]> {
    return  this.http.get<Product[]>(API_URL + '/products');
  }
  findById(id): Observable<Product>  {
    return this.http.get<Product>(`${API_URL}/products/${id}`);
  }
  create(value): Observable<Product[]> {
    return  this.http.post<Product[]>(API_URL + '/products', value);
  }
  update(value, id) {
    return  this.http.put<Product[]>(`${API_URL}/products/${id}`, value);
  }
  remove(id) {
    return this.http.delete<Product[]>(`${API_URL}/products/${id}`);
  }
  search(keyword): Observable<Product[]>  {
    return  this.http.get<Product[]>(`${API_URL}/products?q=${keyword}`);
  }
  getAllCategory(): Observable<Category[]> {
    return  this.http.get<Category[]>(API_URL + '/categorys');
  }
  findCategoryById(id): Observable<Category> {
    return  this.http.get<Category>(`${API_URL}/categorys/${id}`);
  }
}
