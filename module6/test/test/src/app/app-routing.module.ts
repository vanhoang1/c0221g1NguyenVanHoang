import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListQuestionComponent} from './list-question/list-question.component';
import {CreateQuestionComponent} from './create-question/create-question.component';
import {AuthGuard} from './service/auth/auth.guard.service';
import {AdminAuthService} from './service/auth/admin-auth.service';


const routes: Routes = [ {
  path: '', component: ListQuestionComponent
}, {
  path: 'create', component: CreateQuestionComponent, canActivate : [AuthGuard]
}, {
  path: 'edit/:id', component: CreateQuestionComponent, canActivate : [AdminAuthService]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
