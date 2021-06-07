package model.repository.service;

import model.bean.service.RentType;
import model.bean.service.ServiceType;
import model.bean.service.Services;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRepository extends BaseRepository<Services> {
    RentTypeRepository rentTypeRepository;
    ServiceTypeRepository serviceTypeRepository;
    public ServiceRepository() {
        this.DEL="DELETE FROM `case_study`.`dich_vu` WHERE (`id_dich_vu` = ?);";
        this.SELECT_ALL= "SELECT * FROM case_study.dich_vu;";
        this.SELECT ="SELECT * FROM case_study.dich_vu WHERE (`id_dich_vu` = ?);";
        this.FIND="SELECT * FROM case_study.dich_vu WHERE (`ten_dich_vu` LIKE ?);";
        this.UPDATE= "UPDATE `case_study`.`dich_vu` SET `ten_dich_vu` = ?, `dien_tich` = ?, `so_tang` = ?, `so_nguoi_toi_da` = ?, `chi_phi_thue` = ?, `id_kieu_thue` = ?, `id_loai_dich_vu` = ?, `TrangThai` = ? ,ma_dich_vu=? WHERE (`id_dich_vu` = ?);";
        this.INSERT= "INSERT INTO `case_study`.`dich_vu` (`ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `TrangThai`,ma_dich_vu) VALUES  (?, ?, ?, ?, ?, ?, ?,?,?);";
        this.ID=10;
        this.rentTypeRepository= new RentTypeRepository();
        this.serviceTypeRepository = new ServiceTypeRepository();
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
            RentType rentType = rentTypeRepository.get(idRentType);
            int idServiceType = resultSet.getInt("id_loai_dich_vu");
            ServiceType serviceType = serviceTypeRepository.get(idServiceType);
            String status = resultSet.getString("TrangThai");
            String maDichVu = resultSet.getString("ma_dich_vu");
            return new Services(id, serviceName, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, rentType, serviceType, status,maDichVu);

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
            preparedStatement.setInt(6, services.getRentType().getId());
            preparedStatement.setInt(7, services.getServiceType().getId());
            preparedStatement.setString(8, services.getStatus());
            preparedStatement.setString(9, services.getMaDichVu());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

