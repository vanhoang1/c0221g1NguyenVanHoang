package model.repository.service;

import model.bean.service.RentType;
import model.bean.service.ServiceType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentTypeRepository extends BaseRepository<RentType> {
    public RentTypeRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.kieu_thue;";
        this.SELECT="SELECT * FROM case_study.kieu_thue WHERE ( id_kieu_thue = ?)";
    }

    @Override
    public RentType get(ResultSet resultSet) {
        try {
            int id= resultSet.getInt(1);
            String name =resultSet.getString("ten_kieu_thue");
           double cost = resultSet .getDouble("gia");
           return  new RentType(id,name,cost);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(RentType rentType, PreparedStatement preparedStatement) {

    }
}
