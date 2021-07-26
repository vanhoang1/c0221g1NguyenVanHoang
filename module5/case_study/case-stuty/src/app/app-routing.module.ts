import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/home/home/home.component';
import {CustomerComponent} from './component/customer/customer/customer.component';
import {CustomerListComponent} from './component/customer/customer/customer-list/customer-list.component';
import {CustomerCreateComponent} from "./component/customer/customer/customer-create/customer-create.component";


const routes: Routes = [{
  path: '',
  component: HomeComponent,
  children: [{
    path: 'home',
    component: HomeComponent
  }]
}, {
  path: 'customers',
  component: CustomerComponent,
  children: [{
    path: '',
    component: CustomerListComponent
  }, {
    path: 'create',
    component: CustomerCreateComponent
  }]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
