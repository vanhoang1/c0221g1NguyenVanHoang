package com.casestudy.model.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserRoleKey  implements Serializable {
    @Column(name = "user_id")
    Long userId;

    @Column(name = "role_id")
    Long roleId;
}
