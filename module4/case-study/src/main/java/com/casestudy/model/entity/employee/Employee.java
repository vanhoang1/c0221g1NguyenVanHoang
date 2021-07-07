package com.casestudy.model.entity.employee;

import com.casestudy.model.entity.account.AppUser;
import com.casestudy.model.entity.contract.Contract;
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
@Table(name="nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nhan_vien")
    private Long id;
    @Column(name = "ho_ten")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_vi_tri")
    @JsonManagedReference
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_trinh_do")
    @JsonManagedReference
    private Education education;
    @ManyToOne
    @JoinColumn(name = "id_bo_phan")
    @JsonManagedReference
    private Division division;
    @Column(name = "ngay_sinh")
    private LocalDate birthDay;
    @Column(name = "so_cmtdn")
    private String idCard;
    @Column(name = "luong")
    private Double salary;
    @Column(name = "sdt")
    private String phone;
    @Column(name = "dia_chi")
    private String address;
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name="id_tai_khoan")
    private AppUser appUser;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    Set<Contract> contracts;
    @Column(name = "co")
    private Boolean flag;
}
