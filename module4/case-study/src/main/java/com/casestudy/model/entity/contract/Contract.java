package com.casestudy.model.entity.contract;



import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.service.Services;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hop_dong")
    private Long id;
    @Column(name = "ngay_lam_hop_dong")
    private LocalDate startDate;
    @Column(name = "ngay_ket_thuc")
    private LocalDate endDate;
    @Column(name = "tien_dat_coc")
    private Double deposit;
    @Column(name = "tong_tien")
    private Double totalMoney;
    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    @JsonManagedReference
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    @JsonManagedReference
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "id_dich_vu")
    @JsonManagedReference
    private Services service;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    Set<ContractDetail> contractDetails;
}
