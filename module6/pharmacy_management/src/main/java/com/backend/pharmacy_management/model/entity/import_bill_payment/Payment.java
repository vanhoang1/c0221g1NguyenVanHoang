package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long paymentId ;
    Double totalMoney ;
    Double prepayment ;
    Integer discount ;
    String status ;
    @OneToOne(mappedBy = "payment")
    @JsonManagedReference
    ImportBill importBill;

    public Long getPaymentId() {
        return paymentId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public Double getPrepayment() {
        return prepayment;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getStatus() {
        return status;
    }

    public ImportBill getImportBill() {
        return importBill;
    }
}
