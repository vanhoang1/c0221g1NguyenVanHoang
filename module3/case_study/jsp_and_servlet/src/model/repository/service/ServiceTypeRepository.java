package model.repository.service;

import model.bean.service.ServiceType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeRepository extends BaseRepository<ServiceType> {
    public ServiceTypeRepository() {
        this.SELECT_ALL= "SELECT * FROM case_study.loai_dich_vu;";
        this.SELECT ="SELECT * FROM case_study.loai_dich_vu WHERE (`id_loai_dich_vu` = ?);";

    }

    @Override
    public ServiceType get(ResultSet resultSet) {
        try {
           int id= resultSet.getInt(1);
           String name =resultSet.getString("ten_loai_dich_vu");
           return new ServiceType(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(ServiceType serviceType, PreparedStatement preparedStatement) {

    }
}
