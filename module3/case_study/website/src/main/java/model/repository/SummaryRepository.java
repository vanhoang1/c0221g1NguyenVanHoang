package model.repository;

import model.bean.Summary;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.repository.contract.ContractDetailRepository;
import model.repository.contract.ContractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SummaryRepository extends BaseRepository<Summary> {
    ContractRepository contractRepository;
    ContractDetailRepository contractDetailRepository;

    public SummaryRepository() {
        this.SELECT_ALL="SELECT  h.id_hop_dong as idContract, ct.id_chi_tiet_hop_dong as idContractDetail FROM ( hop_dong h )LEFT JOIN( chi_tiet_hop_dong ct )ON ( h.id_hop_dong = ct.id_hop_dong) WHERE ( h.ngay_ket_thuc >= CURRENT_DATE());";
        this.contractDetailRepository= new ContractDetailRepository();
        this.contractRepository= new ContractRepository();
    }

    @Override
    public Summary get(ResultSet resultSet) {
        try {
        int    idContract =   resultSet.getInt("idContract");
        Contract contract= contractRepository.get(idContract);
        int  idContractDetail = resultSet.getInt("idContractDetail");
        ContractDetail contractDetail= contractDetailRepository.get(idContractDetail);
        return  new Summary(contract,contractDetail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Summary summary, PreparedStatement preparedStatement) {

    }
}
