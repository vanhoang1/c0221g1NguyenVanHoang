package model.repository.employee;

import model.bean.employee.Division;
import model.bean.employee.Position;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRepository extends BaseRepository<Division> {
    public DivisionRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.bo_phan;";
        this.SELECT="SELECT * FROM case_study.bo_phan  WHERE (`id_bo_phan` = ?);";
    }

    @Override
    public Division get(ResultSet resultSet) {
        try {
            int id=  resultSet.getInt(1);
            String name =resultSet.getString("ten_bo_phan");
            return new Division(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Division division, PreparedStatement preparedStatement) {

    }
}
