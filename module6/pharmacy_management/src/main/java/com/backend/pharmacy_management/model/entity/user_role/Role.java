package com.backend.pharmacy_management.model.entity.user_role;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;
}
