package model.repository;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.ContractDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractDetailRepository extends BaseRepository<ContractDetail>  {
    ContractRepository contractRepository;
    AttachServiceRepository attachServiceRepository;
    public ContractDetailRepository() {
       this.contractRepository = new ContractRepository();
       this.attachServiceRepository = new AttachServiceRepository();
        this.SELECT = "SELECT * FROM case_study.chi_tiet_hop_dong WHERE (`id_chi_tiet_hop_dong` = ?);";
        this.DEL = "DELETE FROM `case_study`.`chi_tiet_hop_dong` WHERE (`id_chi_tiet_hop_dong` =  ?);";
        this.FIND = "SELECT * FROM case_study.hop_dong WHERE (`id_chi_tiet_hop_dong` LIKE ?);";
        this.SELECT_ALL = "SELECT * FROM case_study.chi_tiet_hop_dong;";
        this.INSERT = "_INSERT INTO `case_study`.`chi_tiet_hop_dong` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ( ?, ?, ?);";
        this.UPDATE = "UPDATE `case_study`.`chi_tiet_hop_dong` SET `id_hop_dong` = ?, `id_dich_vu_di_kem` = ?, `so_luong` = ? WHERE (`id_chi_tiet_hop_dong`  = ?);";
        this.ID=4;
    }

    public ContractRepository getContractRepository() {
        return contractRepository;
    }

    public void setContractRepository(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public AttachServiceRepository getAttachServiceRepository() {
        return attachServiceRepository;
    }

    public void setAttachServiceRepository(AttachServiceRepository attachServiceRepository) {
        this.attachServiceRepository = attachServiceRepository;
    }

    @Override
    public ContractDetail get(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            int idContract = resultSet.getInt("id_hop_dong");
            int idAttach = resultSet.getInt("id_dich_vu_di_kem");
            Contract contract = contractRepository.get(idContract);
            AttachService attachService = attachServiceRepository.get(idAttach);
            int quantity = resultSet.getInt("so_luong");
            return new ContractDetail(id,contract,attachService,quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public void set(ContractDetail contractDetail, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1,contractDetail.getContract().getIdContract());
            preparedStatement.setInt(2,contractDetail.getAttachService().getId());
            preparedStatement.setDouble(3,contractDetail.getQuantity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
