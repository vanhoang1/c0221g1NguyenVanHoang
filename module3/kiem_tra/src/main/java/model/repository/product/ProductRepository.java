package model.repository.product;

import model.bean.exam.Category;
import model.bean.exam.Product;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository extends BaseRepository<Product> {
    CategogyRepository categogyRepository = new CategogyRepository();
    public ProductRepository() {
        this.SELECT_ALL="SELECT * FROM exam.product;";
        this.SELECT="SELECT * FROM exam.product Where id_product = ?";
        this.INSERT="INSERT INTO `exam`.`product` (`name_product`, `price`, `amount`, `color`, `description`, `id_category`) VALUES (?, ?, ?, ?, ?, ?);";
        this.UPDATE="UPDATE `exam`.`product` SET `name_product` = ?, `price` = ?, `amount` = ?, `color` = ?, `description` = ?, `id_category` = ? WHERE (`id_product` = ?);";
        this.DEL="DELETE FROM `exam`.`product` WHERE (`id_product` = ?);";
        this.FIND = "SELECT * FROM product WHERE (`name_product` LIKE ?);";
        this.ID=7;
    }

    @Override
    public Product get(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            String name =resultSet.getString("name_product");
            double price =resultSet.getDouble("price");
            int amount= resultSet.getInt("amount");
            String color= resultSet.getString("color");
            String description= resultSet.getString("description");
            int idCategory= resultSet.getInt("id_category");
            Category category = categogyRepository.get(idCategory);
            return  new Product(id,name,price,amount,color,description,category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Product product, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getAmount());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
