package com.backend.pharmacy_management.model.entity.bill_wholesale;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_of_bill_wholesale")
public class DrugOfBillWholesale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_of_bill_wholesale_id")
    private Long drugOfBillWholesaleId;
    @ManyToOne
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "bill_wholesale_id", nullable = false)
    private BillWholesale billWholesale;
    private int quantity;
}