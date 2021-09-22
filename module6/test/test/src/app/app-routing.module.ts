import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListQuestionComponent} from './list-question/list-question.component';
import {CreateQuestionComponent} from './create-question/create-question.component';


const routes: Routes = [ {
  path: '', component: ListQuestionComponent
}, {
  path: 'create', component: CreateQuestionComponent
}, {
  path: 'edit/:id', component: CreateQuestionComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
