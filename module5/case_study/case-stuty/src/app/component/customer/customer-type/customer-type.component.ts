import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CustomerService} from '../../../model/service/customer/customer.service';
import {CustomerType} from '../../../model/entity/customer/customer-type';

@Component({
  selector: 'app-customer-type',
  templateUrl: './customer-type.component.html',
  styleUrls: ['./customer-type.component.css']
})
export class CustomerTypeComponent implements OnInit {
  customerTypes: CustomerType[] = [{
    id: 1,
    name: 'silver'
  }, {
    id: 2,
    name: 'gold'
  }, {
    id: 3,
    name: 'platinum'
  }, {
    id: 4,
    name: 'diamond'
  }];
  @Input()
  customerTypeChoice: CustomerType;
  @Output() newItemEvent = new EventEmitter<CustomerType>();
  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }
  choice(element) {
    this.customerTypeChoice = element;
    this.newItemEvent.emit(this.customerTypeChoice);
    console.log(this.customerTypeChoice);
  }
}
