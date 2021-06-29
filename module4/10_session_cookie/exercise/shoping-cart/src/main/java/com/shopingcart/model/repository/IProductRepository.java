package com.shopingcart.model.repository;

import com.shopingcart.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
