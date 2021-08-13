import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Patient} from '../model/patient';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Patient[]> {
    return  this.http.get<Patient[]>(API_URL + '/patients');
  }
  findById(id): Observable<Patient>  {
    return this.http.get<Patient>(`${API_URL}/patients/${id}`);
  }
  create(value): Observable<Patient[]> {
    return  this.http.post<Patient[]>(API_URL + '/patients', value);
  }
  update(value, id) {
    return  this.http.put<Patient[]>(`${API_URL}/patients/${id}`, value);
  }
  remove(id): Observable<boolean>  {
    return this.http.delete<boolean>(`${API_URL}/patients/${id}`);
  }
}
