package com.casestudy.model.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tai_khoan", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "ten_tai_khoan") })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "id_tai_khoan", nullable = false)
    private Long userId;

    @Column(name = "ten_tai_khoan", length = 36, nullable = false)
    private String userName;

    @Column(name = "mat_khau", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "trang_thai", length = 1, nullable = false)
    private boolean enabled;


}
