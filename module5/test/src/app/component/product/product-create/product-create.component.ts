import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../../model/category';
import {ProductService} from '../../../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../../../model/product';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  form: FormGroup;
  categorys: Category[] = [];
  constructor(private fb: FormBuilder, private router: Router, private productService: ProductService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      id: [''],
      name: ['', Validators.required],
      description: [''],
      date: [''],
      category: this.fb.group({
        id: [''],
        name: ['']
      })
    });
    this.productService.getAllCategory().subscribe(value => {
      this.categorys = value;
    });
  }
  onSubmit() {
    if (this.form.valid) {
      const product = this.form.value;
      this.productService.findCategoryById(product.category.id).subscribe(value => {
        product.category = value;
        this.productService.create(product).subscribe(
          value1 => {
            this.router.navigate(['']);
          }
        );
      });
      console.log(product);
    }
  }
}
