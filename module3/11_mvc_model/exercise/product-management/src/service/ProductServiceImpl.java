package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private  static Map<Integer, Product> products;
    static {
        products= new HashMap<>();
        products.put(1,new Product(1,"Mì tôm",5000,"Hảo Hảo","aceCook"));
        products.put(2,new Product(2,"Nước",8000,"Sting","pessi"));
        products.put(3,new Product(3,"Trà",7000,"Boncha","uniben"));
        products.put(4,new Product(4,"Sách",17000,"java","abc"));
        products.put(5,new Product(5,"Máy tính",70000,"casio","xyz"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
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
}
