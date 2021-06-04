package model.repository;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee> {
    public EmployeeRepository() {
        this.SELECT_ALL= "SELECT * FROM case_study.nhan_vien;";
        this.SELECT= "SELECT * FROM nhan_vien WHERE (`id_nhan_vien` = ?);";
        this.DEL="DELETE FROM `case_study`.`nhan_vien` WHERE (`id_nhan_vien` = ?);";
        this.FIND="SELECT * FROM nhan_vien WHERE (`ho_ten` LIKE ?);";
        this.INSERT= "INSERT INTO `case_study`.`nhan_vien` (`ho_ten`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`, `ngay_sinh`, `so_cmtdn`, `luong`, `sdt`, `email`, `dia_chi`,`ten_tai_khoan`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
        this.UPDATE= "UPDATE `case_study`.`nhan_vien` SET `ho_ten` = ?, `id_vi_tri` = ?, `id_trinh_do` = ?, `id_bo_phan` = ?, `ngay_sinh` = ?, `so_cmtdn` = ?, `luong` = ?, `sdt` = ?, `email` = ?, `dia_chi` = ?, `ten_tai_khoan` = ? WHERE (`id_nhan_vien` = ?);";
        this.ID=12;
    }
    @Override
    public Employee get(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            String nameCustomer = resultSet.getString("ho_ten");
            int idPosition = resultSet.getInt("id_vi_tri");
            int idEducation =resultSet.getInt("id_trinh_do");
            int idDivision =resultSet.getInt("id_bo_phan");
            Date dateOfBirth = resultSet.getDate("ngay_sinh");
            String idCard = resultSet.getString("so_cmtdn");
            double salary=resultSet.getDouble("luong");
            String phone = resultSet.getString("sdt");
            String address = resultSet.getString("dia_chi");
            String email = resultSet.getString("email");
            String username = resultSet.getString("ten_tai_khoan");
            return   new Employee(id,nameCustomer,idPosition,idEducation,idDivision,dateOfBirth,idCard,salary,phone,address,email,username);

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return  null;
    }

    @Override
    public void set(Employee employee, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1,employee.getNameEmployee());
            preparedStatement.setInt(2,employee.getIdPosition());
            preparedStatement.setInt(3,employee.getIdEducation());
            preparedStatement.setInt(4,employee.getIdDivision());
            preparedStatement.setObject(5,employee.getBirthDay().toInstant().atZone(ZoneId.of("Asia/Tokyo")).toLocalDate());
            preparedStatement.setString(6,employee.getIdCard());
            preparedStatement.setDouble(7,employee.getSalary());
            preparedStatement.setString(8,employee.getPhone());
            preparedStatement.setString(9,employee.getEmail());
            preparedStatement.setString(10,employee.getAddress());
            preparedStatement.setString(11,employee.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
