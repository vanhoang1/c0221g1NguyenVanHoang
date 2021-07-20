package com.casestudy.model.entity.account;

import com.casestudy.model.entity.employee.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
@Getter
@Setter
public class AppUserDetail extends User {
    public AppUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, Employee employee) {
        super(username, password, authorities);
        this.employee = employee;
    }

    public AppUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Employee employee) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.employee = employee;
    }

    public AppUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
    private Employee employee;

}
