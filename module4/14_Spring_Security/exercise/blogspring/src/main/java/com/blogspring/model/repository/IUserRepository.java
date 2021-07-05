package com.blogspring.model.repository;

import com.blogspring.model.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<AppUser, Long> {
    @Query( value= "select * from app_user u WHERE u.USER_NAME = :userName",nativeQuery=true)
    AppUser findUserAccount(@Param("userName") String userName);
}
