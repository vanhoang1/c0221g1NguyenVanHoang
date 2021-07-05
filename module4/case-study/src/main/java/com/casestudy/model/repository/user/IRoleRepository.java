package com.casestudy.model.repository.user;

import com.casestudy.model.entity.account.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<AppRole,Long> {
    @Query(value="select vt.ten_vai_tro from vai_tro vt join chi_tiet_tai_khoan cttk on vt.id_vai_tro = cttk.id_vai_tro where id_tai_khoan= :userId",nativeQuery=true)
    List<String> getRoleNames(@Param(value="userId") Long userId);
}
