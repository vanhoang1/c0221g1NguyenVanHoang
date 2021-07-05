package com.casestudy.model.repository.user;

import com.casestudy.model.entity.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Long> {
    @Query( value= "select * from tai_khoan tk where ten_tai_khoan= :userName ",nativeQuery=true)
    AppUser findUserAccount(@Param("userName") String userName);
}
