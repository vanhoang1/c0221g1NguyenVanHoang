package com.model.service;

import com.model.bean.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;
    static {
        products= new HashMap<>();
        products.put(1,new Product(1,"mi tom",1000,1,"hao hao"));
        products.put(2,new Product(2,"nuoc",2000,1,"sting"));
        products.put(3,new Product(3,"laptop",5000,1,"dell"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
      products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
       products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().contains(name)) {
               productList.add(entry.getValue());
            }
        }

        return  productList;
    }
}
