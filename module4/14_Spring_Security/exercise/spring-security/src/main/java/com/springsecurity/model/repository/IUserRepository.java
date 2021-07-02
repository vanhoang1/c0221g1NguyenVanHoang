package com.springsecurity.model.repository;

import com.springsecurity.model.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<AppUser, Long> {
    @Query( value= "select * from App_User u where u.User_Name = :userName ",nativeQuery=true)
    AppUser findUserAccount(@Param("userName") String userName);
}
