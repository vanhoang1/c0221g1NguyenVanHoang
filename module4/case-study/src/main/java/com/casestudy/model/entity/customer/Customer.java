package com.casestudy.model.entity.customer;


import com.casestudy.model.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khach_hang")
    private Long id;
    @Column(name = "ho_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private LocalDate birthDay;
    @Column(name = "so_cmtdn")
    private String idCard;
    @Column(name = "gioi_tinh")
    private Integer gender;
    @Column(name = "sdt")
    private String phone;
    @Column(name = "ma_khach_hang")
    private String maKhachHang;
    @Column(name = "dia_chi")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "co")
    private Boolean flag;
    @ManyToOne
    @JoinColumn(name = "id_loai_khach")
    @JsonManagedReference
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    Set<Contract> contracts;
}
