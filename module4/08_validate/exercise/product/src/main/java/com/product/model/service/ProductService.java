package com.product.model.service;

import com.product.model.entity.Product;
import com.product.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private   final IProductRepository productRepository;
    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Page<Product> findAll(Pageable pageable, String keyword) {
        return productRepository.findAllByNameContaining('%'+keyword+'%',pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }


    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

}
