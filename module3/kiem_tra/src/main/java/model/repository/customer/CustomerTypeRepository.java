package model.repository.customer;

import model.bean.customer.CustomerType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTypeRepository extends BaseRepository<CustomerType> {
    public CustomerTypeRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.loai_khach;";
        this.SELECT="SELECT * FROM case_study.loai_khach WHERE (`id_loai_khach` = ?);";
    }

    @Override
    public CustomerType get(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("ten_loai_khach");
           return new CustomerType(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(CustomerType customerType, PreparedStatement preparedStatement) {

    }
}
