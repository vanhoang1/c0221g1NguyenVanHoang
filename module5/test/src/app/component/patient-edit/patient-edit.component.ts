import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PatientService} from '../../service/patient.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-patient-edit',
  templateUrl: './patient-edit.component.html',
  styleUrls: ['./patient-edit.component.css']
})
export class PatientEditComponent implements OnInit {
  form: FormGroup;
  id;
  constructor(private patientService: PatientService,
              private activatedRoute: ActivatedRoute,
              private fb: FormBuilder, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    this.id = paramMap.get('id');
    this.getPatient(this.id);
  }); }

  ngOnInit(): void {
    this.form = this.fb.group({
      medicalRecordId : [''],
      patientCode : [''],
      patientName : [''],
      hospitalizedDate : [''],
      hospitalDischargeDate : [''],
      reason : [''],
      treatments : [''],
      doctor : [''],
    });
  }

  private getPatient(id) {
    return this.patientService.findById(id).subscribe(patient => {
    this.form = this.fb.group({
      medicalRecordId : [patient.medicalRecordId],
      patientCode : [patient.patientCode],
      patientName : [patient.patientName, Validators.pattern('^[a-zA-Z]+$')],
      hospitalizedDate : [patient.hospitalizedDate, Validators.required],
      hospitalDischargeDate : [patient.hospitalDischargeDate, Validators.required],
      reason : [patient.reason, Validators.required],
      treatments : [patient.treatments, Validators.required],
      doctor : [patient.doctor, Validators.required],
      });
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const patient = this.form.value;
      this.patientService.update(patient, this.id).subscribe(
          value => {
            this.router.navigate(['']);
          }
        );
      console.log(patient);
    }
  }

  backToList() {
    this.router.navigate(['']);
  }
}

