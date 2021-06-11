package model.repository.product;

import model.bean.exam.Category;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategogyRepository extends BaseRepository<Category> {
    public CategogyRepository() {
        this.SELECT_ALL="SELECT * FROM exam.category;";
        this.SELECT="SELECT * FROM exam.category Where id_category = ?";
    }

    @Override
    public Category get(ResultSet resultSet) {
        try {
          int id =  resultSet.getInt(1);
          String name= resultSet.getString(2);
         return new Category(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Category category, PreparedStatement preparedStatement) {

    }
}
