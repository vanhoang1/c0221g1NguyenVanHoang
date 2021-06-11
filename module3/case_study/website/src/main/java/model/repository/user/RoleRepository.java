package model.repository.user;

import model.bean.account.Role;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRepository extends BaseRepository<Role> {
    public RoleRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.vai_tro;";
        this.SELECT="SELECT * FROM case_study.vai_tro Where id_vai_tro =?";
    }

    @Override
    public Role get(ResultSet resultSet) {
        try {
           int id= resultSet.getInt(1);
           String name = resultSet.getString(2);
            return new Role(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void set(Role role, PreparedStatement preparedStatement) {

    }
}
