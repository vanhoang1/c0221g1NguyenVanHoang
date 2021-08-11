import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductCreateComponent} from './component/product/product-create/product-create.component';
import {ProductComponent} from './component/product/product.component';
import {ProductEditComponent} from './component/product/product-edit/product-edit.component';
import {PatientComponent} from './component/patient/patient.component';
import {PatientCreateComponent} from './component/patient-create/patient-create.component';
import {PatientEditComponent} from './component/patient-edit/patient-edit.component';


const routes: Routes = [
  {
    path: '',
    component: PatientComponent
  },
  {
    path: 'patients/create',
    component: PatientCreateComponent
  },
  {
    path: 'patients/edit/:id',
    component: PatientEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
