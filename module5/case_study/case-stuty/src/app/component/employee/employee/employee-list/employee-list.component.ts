import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {Employee} from '../../../../model/entity/employee/employee';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Router} from '@angular/router';
import {CustomerService} from '../../../../model/service/customer/customer.service';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeService} from '../../../../model/service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[];
  columndefs: any[] = ['id', 'name', 'position', 'education', 'division', 'birthDay', 'idCard', 'salary'];
  dataSource: MatTableDataSource<Employee>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private router: Router, private employeeService: EmployeeService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.employees = this.employeeService.getAllEmployee();
    this.dataSource = new MatTableDataSource(this.employees);
    setTimeout(() => this.dataSource.paginator = this.paginator);
    setTimeout(() => this.dataSource.sort = this.sort);
  }
  openDialog(param: string, value) {

  }

  applyFilter(event) {
    const filterValue = event.target.value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
