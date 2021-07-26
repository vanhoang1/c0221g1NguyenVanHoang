import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DictionaryDetailPageComponent} from './dictionary-detail-page/dictionary-detail-page.component';
import {DictionaryPageComponent} from './component/dictionary-page/dictionary-page.component';


const routes: Routes = [
  {
    path: 'dictionary',
    component: DictionaryPageComponent,
    children: [{
      path: ':word',
      component: DictionaryDetailPageComponent
    }]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
