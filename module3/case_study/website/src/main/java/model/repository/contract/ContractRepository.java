package model.repository.contract;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Services;
import model.repository.BaseRepository;
import model.repository.customer.CustomerRepository;
import model.repository.employee.EmployeeRepository;
import model.repository.service.ServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;

public class ContractRepository extends BaseRepository<Contract> {
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository ;
    private ServiceRepository serviceRepository ;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ServiceRepository getServiceRepository() {
        return serviceRepository;
    }

    public void setServiceRepository(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ContractRepository() {
        this.SELECT = "SELECT * FROM case_study.hop_dong WHERE (`id_hop_dong` = ?);";
        this.DEL = "DELETE FROM `case_study`.`hop_dong` WHERE (`id_hop_dong` = ?);";
        this.FIND = "SELECT * FROM case_study.hop_dong WHERE (`id_hop_dong` LIKE ?);";
        this.SELECT_ALL = "SELECT * FROM case_study.hop_dong ";
        this.INSERT = "INSERT INTO `case_study`.`hop_dong` (`id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES  (?, ?, ?, ?, ?, ?, ?);";
        this.UPDATE = "UPDATE `case_study`.`hop_dong` SET `id_nhan_vien` = ?, `id_khach_hang` = ?, `id_dich_vu` = ?, `ngay_lam_hop_dong` = ?, `ngay_ket_thuc` = ?, `tien_dat_coc` = ? , `tong_tien` = ? WHERE (`id_hop_dong` = ?);";
        this.ID=8;
        this.employeeRepository = new EmployeeRepository();
        this.customerRepository = new CustomerRepository();
        this.serviceRepository = new ServiceRepository();
    }

    @Override
    public Contract get(ResultSet resultSet) {

        try {
            int idContract = resultSet.getInt("id_hop_dong");
            Date startDate = resultSet.getDate("ngay_lam_hop_dong");
            Date endDate  = resultSet.getDate("ngay_ket_thuc");
            double deposit = resultSet.getDouble("tien_dat_coc");
            double totalMoney  = resultSet.getDouble("tong_tien");
            int idEmployee = resultSet.getInt("id_nhan_vien");
            Employee employee = employeeRepository.get(idEmployee);
            int idCustomer = resultSet.getInt("id_khach_hang");
            Customer customer = customerRepository.get(idCustomer);
            int idService = resultSet.getInt("id_dich_vu");
            Services services = serviceRepository.get(idService);
            return   new Contract(idContract,startDate,endDate,deposit,totalMoney,employee,customer,services);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Contract contract, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1,contract.getEmployee().getIdEmployee());
            preparedStatement.setInt(2,contract.getCustomer().getId());
            preparedStatement.setInt(3,contract.getService().getId());
            preparedStatement.setObject(4,contract.getStartDate().toInstant().atZone(ZoneId.of("Asia/Tokyo")).toLocalDate());
            preparedStatement.setObject(5,contract.getEndDate().toInstant().atZone(ZoneId.of("Asia/Tokyo")).toLocalDate());
            preparedStatement.setDouble(6,contract.getDeposit());
            preparedStatement.setDouble(7,contract.getTotalMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
