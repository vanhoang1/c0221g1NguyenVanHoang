package model.repository;

import model.bean.Customer;
import model.bean.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceRepository extends  BaseRepository<Services> {
    public ServiceRepository() {
        this.DEL="DELETE FROM `case_study`.`dich_vu` WHERE (`id_dich_vu` = ?);";
        this.SELECT_ALL= "SELECT * FROM case_study.dich_vu;";
        this.SELECT ="SELECT * FROM case_study.dich_vu WHERE (`id_dich_vu` = ?);";
        this.FIND="SELECT * FROM case_study.dich_vu WHERE (`ten_dich_vu` LIKE ?);";
        this.UPDATE= "UPDATE `case_study`.`dich_vu` SET `ten_dich_vu` = ?, `dien_tich` = ?, `so_tang` = ?, `so_nguoi_toi_da` = ?, `chi_phi_thue` = ?, `id_kieu_thue` = ?, `id_loai_dich_vu` = ?, `TrangThai` = ? WHERE (`id_dich_vu` = ?);";
        this.INSERT= "INSERT INTO `case_study`.`dich_vu` (`ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `TrangThai`) VALUES  (?, ?, ?, ?, ?, ?, ?,?);";
        this.ID=9;
    }

    @Override
    public Services get(ResultSet resultSet) {

        try {
            int id = resultSet.getInt(1);
            String serviceName = resultSet.getString("ten_dich_vu");
            int areaOfUse = resultSet.getInt("dien_tich");
            int numberOfFloors = resultSet.getInt("so_tang");
            int maxNumOfPeople = resultSet.getInt("so_nguoi_toi_da");
            int rentalCosts = resultSet.getInt("chi_phi_thue");
            int idRentType = resultSet.getInt("id_kieu_thue");
            int idServiceType = resultSet.getInt("id_loai_dich_vu");
            String status = resultSet.getString("TrangThai");
            return new Services(id, serviceName, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, idRentType, idServiceType, status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
     return  null;
    }

    @Override
    public void set(Services services, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setInt(2, services.getAreaOfUse());
            preparedStatement.setInt(3, services.getNumberOfFloors());
            preparedStatement.setInt(4, services.getMaxNumOfPeople());
            preparedStatement.setInt(5, services.getRentalCosts());
            preparedStatement.setInt(6, services.getIdRentType());
            preparedStatement.setInt(7, services.getIdServiceType());
            preparedStatement.setString(8, services.getStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

