package model.repository.user;

import model.bean.account.User;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends BaseRepository<User> {
    private  static final  String LOGIN= "SELECT * FROM case_study.tai_khoan WHERE `ten_tai_khoan`=? AND `mat_khau` =?";
    public UserRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.tai_khoan;";
        this.SELECT="SELECT * FROM case_study.tai_khoan WHERE `ten_tai_khoan`=?;";

    }

    @Override
    public User get(ResultSet resultSet) {
        try {
            String username = resultSet.getString(1);
            String password = resultSet.getString(2);
            return new User(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(User user, PreparedStatement preparedStatement) {

    }
     public  User login(String username, String password){
         Connection connection = getConnection();
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
             preparedStatement.setString(1,username);
             preparedStatement.setString(2,password);
             ResultSet resultSet= preparedStatement.executeQuery();
             resultSet.next();
             return get(resultSet);
         } catch (SQLException e) {
             e.printStackTrace();
         }finally {
             try {
                 connection.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
        return null;
     }
}
