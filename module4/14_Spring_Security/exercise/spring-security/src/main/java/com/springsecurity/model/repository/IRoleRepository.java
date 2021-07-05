package com.springsecurity.model.repository;

import com.springsecurity.model.entity.AppRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends CrudRepository<AppRole,Long> {
    @Query(value="select r.Role_Name from User_Role ur join App_Role r on r.Role_Id=ur.Role_Id where  ur.User_Id = :userId",nativeQuery=true)
    List<String> getRoleNames(@Param(value="userId") Long userId);
}
