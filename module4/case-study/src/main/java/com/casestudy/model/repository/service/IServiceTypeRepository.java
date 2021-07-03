package com.casestudy.model.repository.service;

import com.casestudy.model.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
