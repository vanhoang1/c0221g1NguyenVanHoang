package model.service.impl;

import model.bean.exam.Product;
import model.repository.product.ProductRepository;
import model.service.api.Service;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements Service<Product> {
    ProductRepository productRepository= new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.getAll();
    }

    @Override
    public List<String> save(Product product) {
        List<String> list = findErr(product);
        if(list.size()==0)
            productRepository.insert(product);
        return list;
    }

    @Override
    public Product findById(int id) {
        return productRepository.get(id);
    }

    @Override
    public List<String> update(int id, Product product) {
        List<String> list = findErr(product);
        if(list.size()==0)
            productRepository.update(id,product);
        return list;
    }

    @Override
    public boolean remove(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> findByName(String search) {
        return productRepository.search(search);
    }

    @Override
    public List<String> findErr(Product product) {
        List<String> list = new ArrayList<>();
        return list;
    }
}
