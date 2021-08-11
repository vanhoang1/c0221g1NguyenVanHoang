package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill")
public class ImportBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long importBillId;
    private String importSystemCode;
    private Long employeeId;
    private Long paymentId;
    private Long manufacturerId;
    private String accountingVoucher;
    private LocalDateTime invoiceDate;
    private Boolean flag = true;
    @OneToOne
    @JoinColumn(name = "payment_id")
    @JsonManagedReference
    private  Payment payment;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonManagedReference
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private Employee employee;
    @OneToMany(mappedBy = "importBill",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ImportBillDrug> importBillDrugs;

    public void setImportBillId(Long importBillId) {
        this.importBillId = importBillId;
    }

    public void setImportSystemCode(String importSystemCode) {
        this.importSystemCode = importSystemCode;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setAccountingVoucher(String accountingVoucher) {
        this.accountingVoucher = accountingVoucher;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setImportBillDrugs(List<ImportBillDrug> importBillDrugs) {
        this.importBillDrugs = importBillDrugs;
    }
}
