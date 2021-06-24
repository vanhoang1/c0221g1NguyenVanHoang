package com.product.model.service;



import com.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable , String keyword);

    void save(Product product);

    Optional<Product> findById(int id);

    void remove(int id);

}
