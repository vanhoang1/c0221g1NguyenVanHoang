package model.repository.employee;

import model.bean.exam.Employee;
import model.repository.BaseRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class EmployeeRepository extends BaseRepository<Employee> {
    public EmployeeRepository() {
        this.SELECT_ALL="SELECT * FROM exam.employee;";
        this.SELECT="SELECT * FROM exam.employee Where id_employee=?";
        this.INSERT="INSERT INTO `exam`.`employee` (`name_employee`, `birthday`) VALUES (?, ?);";
        this.UPDATE="UPDATE `exam`.`employee` SET `name_employee` = ?, `birthday` = ? WHERE (`id_employee` = ?);";
        this.DEL="DELETE FROM `exam`.`employee` WHERE (`id_employee` = '?);";
        this.ID=3;
    }

    @Override
    public Employee get(ResultSet resultSet) {
        try {
           int id = resultSet.getInt(1);
            String name = resultSet.getString("name_employee");
            Date birthDay= resultSet.getDate("birthday");
            return new Employee(id,name,birthDay);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Employee employee, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setObject(2,employee.getBirthDay().toInstant().atZone(ZoneId.of("Asia/Tokyo")).toLocalDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
