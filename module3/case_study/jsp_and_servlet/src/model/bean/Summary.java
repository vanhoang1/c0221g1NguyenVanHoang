package model.bean;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;

public class Summary {
 private Contract contract;
 private ContractDetail contractDetail;

    public Summary() {
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }

    public Summary(Contract contract, ContractDetail contractDetail) {
        this.contract = contract;
        this.contractDetail = contractDetail;
    }
}
