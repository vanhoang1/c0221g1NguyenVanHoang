package model.repository.employee;

import model.bean.employee.Education;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationRepository extends BaseRepository<Education> {
    public EducationRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.trinh_do;";
        this.SELECT="SELECT * FROM case_study.trinh_do  WHERE (`id_trinh_do` = ?);";
    }

    @Override
    public Education get(ResultSet resultSet) {
        try {
            int id=  resultSet.getInt(1);
            String name =resultSet.getString("trinh_do");
            return new Education(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Education education, PreparedStatement preparedStatement) {

    }
}
