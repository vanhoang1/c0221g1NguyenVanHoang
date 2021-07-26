import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import {Product} from '../../model/product';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: Product;
  productForm: FormGroup;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.product = this.productService.getProductById(Number(id));
      this.productForm = this.formBuilder.group({
        id: [this.product.id],
        name: [this.product.name],
        price: [this.product.price],
        description: [this.product.description]
      });
    });
  }

  submit() {
    const product = this.productForm.value;
    product.id = this.product.id;
    this.productService.updateProduct(product);
    this.productForm.reset(this.productForm.value);
    this.router.navigate(['/product/list']);
  }

  cancel(): void {
    // Navigate back to the product list
    this.router.navigate(['/product/list']);
  }
}
