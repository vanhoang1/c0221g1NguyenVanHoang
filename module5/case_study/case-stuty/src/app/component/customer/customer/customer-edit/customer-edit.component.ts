import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  name;
  constructor( @Inject(MAT_DIALOG_DATA) private data: any,
               private dialogRef: MatDialogRef<CustomerEditComponent>) { }

  ngOnInit(): void {
    this.name = this.data.name;
  }
  onConfirmClick(): void {
    this.dialogRef.close(true);
  }
}
