import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListQuestionComponent } from './list-question/list-question.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {ToastrModule} from 'ngx-toastr';
import {FormBuilder, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    ListQuestionComponent,
    CreateQuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDialogModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [FormBuilder, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
