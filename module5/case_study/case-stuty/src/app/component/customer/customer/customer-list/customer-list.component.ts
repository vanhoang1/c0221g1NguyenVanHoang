import {AfterViewChecked, Component, DoCheck, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {CustomerService} from '../../../../model/service/customer/customer.service';
import {Customer} from '../../../../model/entity/customer/customer';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {CustomerCreateComponent} from '../customer-create/customer-create.component';
import {CustomerEditComponent} from '../customer-edit/customer-edit.component';
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];
  columndefs: any[] = ['id', 'name', 'birthDay', 'idCard', 'gender', 'phone', 'address', 'email', 'Type Of Customer', 'action'];
  dataSource: MatTableDataSource<Customer>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(  private customerService: CustomerService,
                public dialog: MatDialog) { }

  ngOnInit(): void {
   this.getAllCustomer();
  }
  getAllCustomer() {
    this.customerService.getAll().subscribe(result => {
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  openDialog(type: string, element: any) {
    switch (type) {
      case 'create': {
        const dialogRef = this.dialog.open(CustomerCreateComponent);
        dialogRef.afterClosed().subscribe(result => {
          if (typeof result !== 'undefined') {
            this.customerService.create(result.content).subscribe(value => {
              this.getAllCustomer();
            });
          }
        });
        break;
      }
      case 'update': {
        const dialogRef = this.dialog.open(CustomerCreateComponent, {data: element});
        dialogRef.afterClosed().subscribe(result => {
          if (typeof result !== 'undefined') {
            this.customerService.update(result, result.id).subscribe(value => {
              this.getAllCustomer();
            });
          }
        });
        break;
      }
      case 'delete': {
        const dialogRef = this.dialog.open(CustomerEditComponent, {data: element});
        dialogRef.afterClosed().subscribe((result: boolean) => {
          if (result) {
            this.customerService.remove(element.id).subscribe(value => {
              this.getAllCustomer();
            });
          }
        });
        break;
      }
    }
  }
  applyFilter(event) {
    const filterValue = event.target.value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
