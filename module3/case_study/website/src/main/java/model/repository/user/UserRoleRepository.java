package model.repository.user;

import model.bean.account.Role;
import model.bean.account.User;
import model.bean.account.UserRole;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleRepository extends BaseRepository<UserRole> {
    UserRepository userRepository = new UserRepository();
    RoleRepository roleRepository = new RoleRepository();
    public UserRoleRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.chi_tiet_tai_khoan;";
       this.SELECT="SELECT * FROM case_study.chi_tiet_tai_khoan where ten_tai_khoan =?";
    }

    @Override
    public UserRole get(ResultSet resultSet) {
        try {
            int idRole = resultSet.getInt(1);
            String username= resultSet.getString(2);
            Role role = roleRepository.get(idRole);
            User user =  userRepository.get(username);
            return  new UserRole(user,role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(UserRole userRole, PreparedStatement preparedStatement) {

    }
    public  UserRole get(String name){
        Connection connection = getConnection();
        UserRole userRole =null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userRole   = get(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRole;
    }
}
