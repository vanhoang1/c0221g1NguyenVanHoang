import {Component, OnInit} from '@angular/core';

import {MatDialog} from '@angular/material/dialog';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {DeleteComponent} from '../delete/delete.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  config = {
    itemsPerPage: 5,
    currentPage: 1,
    totalItems: this.products.length
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

  constructor(private productService: ProductService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAll().subscribe(result => {
      this.products = result;
    });
  }

  onPageChange(event) {
    console.log(event);
    this.config.currentPage = event;
  }

  openDialog(type: string, element: any) {
    const dialogRef = this.dialog.open(DeleteComponent, {data: element});
    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.productService.remove(element.id).subscribe(value => {
          this.getAllProduct();
        });
      }
    });
  }

  search(value: string) {
    this.productService.search(value).subscribe(next => {
      console.log(next);
      this.products = next;
      }
    );
  }
}
