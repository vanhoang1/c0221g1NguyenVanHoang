import { Injectable } from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Question} from './model/question';
import {QuestionType} from './model/question-type';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Question[]> {
    return this.http.get<Question[]>(API_URL + '/questions');
  }

  getAllQuestionType(): Observable<QuestionType[]> {
    return this.http.get<QuestionType[]>(API_URL + '/questions/questionType');
  }

  getQuestionTypeById(id): Observable<QuestionType> {
    return this.http.get<QuestionType>(`${API_URL}/questions/questionType/${id}`);
  }

  getById(id): Observable<Question> {
    return this.http.get<Question>(`${API_URL}/questions/${id}`);
  }

  create(value): Observable<Question> {
    return this.http.post<Question>(API_URL + '/questions', value);
  }
  update(value, id) {
    return  this.http.put<Question>(`${API_URL}/questions/${id}`, value);
  }
  getAllQuestions(page: number): Observable<any> {
    return this.http.get<any>(API_URL + '/questions?page=' + page);
  }

  delete(id): Observable<any> {
    return this.http.delete<Question>(`${API_URL}/questions/${id}`);
  }
}
