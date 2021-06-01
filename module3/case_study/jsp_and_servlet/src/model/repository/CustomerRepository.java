package model.repository;

import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM khach_hang;";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM `case_study`.`khach_hang` WHERE (`id_khach_hang` = ?);";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE `khach_hang` SET `id_loai_khach` = ?, `ho_ten` = ?, `ngay_sinh` = ?, `so_cmtdn` = ?, `sdt` = ?, `email` = ?, `dia_chi` = ? WHERE (`id_khach_hang` = ?);";
    private static final String SELECT_CUSTOMER = "SELECT * FROM khach_hang WHERE (`id_khach_hang` = ?);";

    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nameCustomer = resultSet.getString("ho_ten");
                Date dateOfBirth = resultSet.getDate("ngay_sinh");
                String soCMND = resultSet.getString("so_cmtdn");
                String soDT = resultSet.getString("sdt");
                String address = resultSet.getString("dia_chi");
                String email = resultSet.getString("email");
                int typeOfCustomer = resultSet.getInt("id_loai_khach");
                Customer customer = new Customer(id, nameCustomer, dateOfBirth, soCMND, soDT, address, email, typeOfCustomer);
                list.add(customer);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Customer getCustomer(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameCustomer = resultSet.getString("ho_ten");
                Date dateOfBirth = resultSet.getDate("ngay_sinh");
                String soCMND = resultSet.getString("so_cmtdn");
                String soDT = resultSet.getString("sdt");
                String address = resultSet.getString("dia_chi");
                String email = resultSet.getString("email");
                int typeOfCustomer = resultSet.getInt("id_loai_khach");

                return new Customer(id, nameCustomer, dateOfBirth, soCMND, soDT, address, email, typeOfCustomer);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCustomer(int id, Customer customer) {
        Connection connection = baseRepository.getConnection();
        boolean check= false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
            preparedStatement.setInt(1, customer.getTypeOfCustomer());
            preparedStatement.setString(2, customer.getNameCustomer());
            preparedStatement.setObject(3, customer.getDateOfBirth().toInstant().atZone( ZoneId.of( "Asia/Tokyo" ) ).toLocalDate() );    ;
            preparedStatement.setString(4, customer.getSoCMND());
            preparedStatement.setString(5, customer.getSoDT());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, id);
            check= preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }
}
