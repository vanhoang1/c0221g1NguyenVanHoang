package com.backend.pharmacy_management.model.entity.drug;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "drug_code")
    private String drugCode;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "active_element")
    private String activeElement;
    @Column(name = "drug_amount")
    private Long drugAmount;
    @Column(name = "unit")
    private String unit;
    @Column(name = "conversion_unit")
    private String conversionUnit;
    @Column(name = "wholesale_profit_rate")
    private Double wholesaleProfitRate;
    @Column(name = "retail_profit_rate")
    private Double retailProfitRate;
    @Column(name = "drug_preserve", columnDefinition = "TEXT")
    private String drugPreserve;
    @Column(name = "drug_dosage", columnDefinition = "TEXT")
    private String drugDosage;
    @Column(name = "drug_ingredient", columnDefinition = "TEXT")
    private String drugIngredient;
    @Column(name = "drug_side_effect", columnDefinition = "TEXT")
    private String drugSideEffect;
    @Column(name = "drug_user_manual", columnDefinition = "TEXT")
    private  String drugUserManual;
    private Integer flag = 1;
    @ManyToOne
    @JoinColumn(name = "drug_group_id", referencedColumnName = "drug_group_id")
    private DrugGroup drugGroup;
    @OneToMany(mappedBy = "drug")
    private List<DrugImageDetail> drugImageDetails;
    @OneToMany(mappedBy = "drug")
    private List<DrugOfBill> drugOfBills;
    @OneToMany(mappedBy = "drug")
    private List<DrugOfBillRetail> drugOfBillRetails;
    @OneToMany(mappedBy = "drug")
    private List<Indicative> indicatives;
    @OneToMany(mappedBy = "drug")
    private List<ExportBillDetail> exportBillDetails;
}
