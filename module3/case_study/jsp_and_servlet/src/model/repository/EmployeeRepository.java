package model.repository;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM case_study.nhan_vien;";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM `case_study`.`nhan_vien` WHERE (`id_nhan_vien` = ?);";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE `case_study`.`nhan_vien` SET `ho_ten` = ?, `id_vi_tri` = ?, `id_trinh_do` = ?, `id_bo_phan` = ?, `ngay_sinh` = ?, `so_cmtdn` = ?, `luong` = ?, `sdt` = ?, `email` = ?, `dia_chi` = ?, `ten_tai_khoan` = ? WHERE (`id_nhan_vien` = ?);";
    private static final String SELECT_EMPLOYEE = "SELECT * FROM nhan_vien WHERE (`id_nhan_vien` = ?);";
    private static final String INSERT_EMPLOYEE= "INSERT INTO `case_study`.`nhan_vien` (`ho_ten`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`, `ngay_sinh`, `so_cmtdn`, `luong`, `sdt`, `email`, `dia_chi`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_NAME = "SELECT * FROM nhan_vien WHERE (`ho_ten` LIKE ?);";

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                Employee employee = new Employee(id,nameCustomer,idPosition,idEducation,idDivision,dateOfBirth,idCard,salary,phone,address,email,username);
                list.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
