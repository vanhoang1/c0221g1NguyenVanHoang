import { Component, OnInit } from '@angular/core';
import {Patient} from '../../model/patient';
import {PatientService} from '../../service/patient.service';
import {ProductService} from '../../service/product.service';
import {MatDialog} from '@angular/material/dialog';
import {DeleteComponent} from '../delete/delete.component';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  patients: Patient[] = [];
  config = {
    itemsPerPage: 5,
    currentPage: 1,
    totalItems: this.patients.length
  };

  public maxSize = 7;
  public directionLinks = true;
  public autoHide = false;
  public responsive = true;
  public labels: any = {
    previousLabel: '<--',
    nextLabel: '-->',
    screenReaderPaginationLabel: 'Pagination',
    screenReaderPageLabel: 'page',
    screenReaderCurrentLabel: `You're on page`
  };

  constructor(private patientService: PatientService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllPatient();
  }
  getAllPatient() {
    this.patientService.getAll().subscribe(value => {
      this.patients = value;
    });
  }
  openDialog(type: string, element: any) {
    const dialogRef = this.dialog.open(DeleteComponent, {data: element});
    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.patientService.remove(element.id).subscribe(value => {
          console.log(value);
        });
      }
      this.getAllPatient();
    });
  }

  search(value: string) {
  }

  onPageChange(event) {
    this.config.currentPage = event;
  }
}
