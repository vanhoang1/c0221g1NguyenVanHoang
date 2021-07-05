package com.casestudy.model.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vai_tro", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "ten_vai_tro") })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole {

    @Id
    @GeneratedValue
    @Column(name = "id_vai_tro", nullable = false)
    private Long roleId;

    @Column(name = "ten_vai_tro", length = 30, nullable = false)
    private String roleName;

}