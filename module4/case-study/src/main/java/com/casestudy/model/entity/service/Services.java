package com.casestudy.model.entity.service;

import com.casestudy.model.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dich_vu")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dich_vu")
    private Long id;
    @Column(name = "ten_dich_vu")
    private String name;
    @Column(name = "dien_tich")
    private Double areaOfUse;
    @Column(name = "so_tang")
    private Integer numberOfFloors;
    @Column(name = "so_nguoi_toi_da")
    private Integer maxNumOfPeople;
    @Column(name = "chi_phi_thue")
    private Integer rentalCosts;
    @ManyToOne
    @JoinColumn(name = "id_kieu_thue")
    @JsonManagedReference
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "id_loai_dich_vu")
    @JsonManagedReference
    private ServiceType serviceType;
    @Column(name = "TrangThai")
    private String status;
    @Column(name = "ma_dich_vu")
    private String maDichVu;

    @OneToMany(mappedBy = "service")
    @JsonBackReference
    Set<Contract> contracts;
}
