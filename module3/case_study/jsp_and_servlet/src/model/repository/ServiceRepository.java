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

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE = "SELECT * FROM case_study.dich_vu;";
    private static final String DELETE_SERVICE_SQL = "DELETE FROM `case_study`.`dich_vu` WHERE (`id_dich_vu` = ?);";
    private static final String UPDATE_SERVICE_SQL = "UPDATE `case_study`.`dich_vu` SET `ten_dich_vu` = ?, `dien_tich` = ?, `so_tang` = ?, `so_nguoi_toi_da` = ?, `chi_phi_thue` = ?, `id_kieu_thue` = ?, `id_loai_dich_vu` = ?, `TrangThai` = ? WHERE (`id_dich_vu` = ?);";
    private static final String SELECT_SERVICE = "SELECT * FROM case_study.dich_vu WHERE (`id_dich_vu` = ?);";
    private static final String INSERT_SERVICE = "INSERT INTO `case_study`.`dich_vu` (`ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `TrangThai`) VALUES  (?, ?, ?, ?, ?, ?, ?,?);";
    private static final String FIND_BY_NAME = "SELECT * FROM case_study.dich_vu WHERE (`ten_dich_vu` LIKE ?);";

    public List<Services> getAllService() {
        List<Services> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String serviceName = resultSet.getString("ten_dich_vu");
                int areaOfUse = resultSet.getInt("dien_tich");
                int numberOfFloors = resultSet.getInt("so_tang");
                int maxNumOfPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentalCosts = resultSet.getInt("chi_phi_thue");
                int idRentType = resultSet.getInt("id_kieu_thue");
                int idServiceType = resultSet.getInt("id_loai_dich_vu");
                String status = resultSet.getString("TrangThai");
                Services services = new Services(id, serviceName, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, idRentType, idServiceType, status);
                list.add(services);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Services getService(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String serviceName = resultSet.getString("ten_dich_vu");
            int areaOfUse = resultSet.getInt("dien_tich");
            int numberOfFloors = resultSet.getInt("so_tang");
            int maxNumOfPeople = resultSet.getInt("so_nguoi_toi_da");
            int rentalCosts = resultSet.getInt("chi_phi_thue");
            int idRentType = resultSet.getInt("id_kieu_thue");
            int idServiceType = resultSet.getInt("id_loai_dich_vu");
            String status = resultSet.getString("TrangThai");
            Services services = new Services(id, serviceName, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, idRentType, idServiceType, status);
            preparedStatement.close();
            connection.close();
            return services;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateService(int id, Services services) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_SQL);
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setInt(2, services.getAreaOfUse());
            preparedStatement.setInt(3, services.getNumberOfFloors());
            preparedStatement.setInt(4, services.getMaxNumOfPeople());
            preparedStatement.setInt(5, services.getRentalCosts());
            preparedStatement.setInt(6, services.getIdRentType());
            preparedStatement.setInt(7, services.getIdServiceType());
            preparedStatement.setString(8, services.getStatus());
            preparedStatement.setInt(9, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean insertService( Services services) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setInt(2, services.getAreaOfUse());
            preparedStatement.setInt(3, services.getNumberOfFloors());
            preparedStatement.setInt(4, services.getMaxNumOfPeople());
            preparedStatement.setInt(5, services.getRentalCosts());
            preparedStatement.setInt(6, services.getIdRentType());
            preparedStatement.setInt(7, services.getIdServiceType());
            preparedStatement.setString(8, services.getStatus());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public List<Services> searchService(String name){
        List<Services> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1,'%'+name+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String serviceName = resultSet.getString("ten_dich_vu");
                int areaOfUse = resultSet.getInt("dien_tich");
                int numberOfFloors = resultSet.getInt("so_tang");
                int maxNumOfPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentalCosts = resultSet.getInt("chi_phi_thue");
                int idRentType = resultSet.getInt("id_kieu_thue");
                int idServiceType = resultSet.getInt("id_loai_dich_vu");
                String status = resultSet.getString("TrangThai");
                Services services = new Services(id, serviceName, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, idRentType, idServiceType, status);
                list.add(services);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean delService(int id){
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE_SQL);
            preparedStatement.setInt(1,id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
return check;
    }
}

