import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../../model/category';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  form: FormGroup;
  id;
  categorys: Category[] = [];

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private fb: FormBuilder, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    this.productService.getAllCategory().subscribe(value => {
      this.categorys = value;
    });
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
  }

  private getProduct(id) {
    return this.productService.findById(id).subscribe(product => {
      console.log(product);
      this.form = this.fb.group({
        name: [product.name],
        description: [product.description],
        date: [product.date],
        category: this.fb.group({
          id: [product.category.id],
          name: [product.category.name]
        })
      });
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const product = this.form.value;
      this.productService.findCategoryById(product.category.id).subscribe(value => {
        product.category = value;
        this.productService.update(product, this.id).subscribe(
          value1 => {
            this.router.navigate(['']);
          }
        );
      });
      console.log(product);
    }
  }
}
