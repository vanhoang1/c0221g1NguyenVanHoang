package com.casestudy.model.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "khach_hang_view")
@Immutable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerView {
    @Id
    @Column(name="row_num")
    Long id;

    @Column(name = "id_hop_dong")
    Long contractId;
    @Column(name="ho_ten")
    String customerName;
    @Column(name = "ngay_lam_hop_dong")
    LocalDate startDate;
    @Column(name = "ngay_ket_thuc")
    LocalDate endDate;
    @Column(name = "ten_dich_vu_di_kem")
    String AttachServiceName;
    @Column(name = "id_dich_vu")
    Long serviceId;

}
