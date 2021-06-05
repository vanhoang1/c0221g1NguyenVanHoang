package model.repository.customer;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;


public class CustomerRepository extends BaseRepository<Customer> {
    CustomerTypeRepository customerTypeRepository ;
    public CustomerRepository() {
        this.SELECT="SELECT * FROM khach_hang  WHERE (`id_khach_hang` = ?);";
        this.DEL = "DELETE FROM `case_study`.`khach_hang` WHERE (`id_khach_hang` = ?);";
        this.FIND = "SELECT * FROM khach_hang WHERE (`ho_ten` LIKE ?);";
        this.SELECT_ALL="SELECT * FROM khach_hang;";
        this.INSERT= "INSERT INTO `case_study`.`khach_hang` (`id_loai_khach`, `ho_ten`, `ngay_sinh`, gioi_tinh, `so_cmtdn`, `sdt`, `email`, `dia_chi`) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        this.UPDATE="UPDATE `khach_hang` SET `id_loai_khach` = ?, `ho_ten` = ?, `ngay_sinh` = ?, gioi_tinh=? , `so_cmtdn` = ? ,`sdt` = ?, `email` = ?, `dia_chi` = ? WHERE (`id_khach_hang` = ?);";
        this.ID=9;
        this.customerTypeRepository = new CustomerTypeRepository();
    }

    @Override
    public Customer get(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            String nameCustomer = resultSet.getString("ho_ten");
            Date dateOfBirth = resultSet.getDate("ngay_sinh");
            String soCMND = resultSet.getString("so_cmtdn");
            String soDT = resultSet.getString("sdt");
            String address = resultSet.getString("dia_chi");
            String email = resultSet.getString("email");
            int typeOfCustomer = resultSet.getInt("id_loai_khach");
            CustomerType customerType = customerTypeRepository.get(typeOfCustomer);
            int gender = resultSet.getInt("gioi_tinh");
            return new Customer(id, nameCustomer, dateOfBirth, soCMND, gender, soDT, address, email, customerType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Customer customer, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1, customer.getCustomerType().getId());
            preparedStatement.setString(2, customer.getNameCustomer());
            preparedStatement.setObject(3, customer.getDateOfBirth().toInstant().atZone(ZoneId.of("Asia/Tokyo")).toLocalDate());
            preparedStatement.setInt(4,customer.getGender());
            preparedStatement.setString(5, customer.getSoCMND());
            preparedStatement.setString(6, customer.getSoDT());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
