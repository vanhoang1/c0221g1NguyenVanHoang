package com.casestudy.model.repository.service;

import com.casestudy.model.entity.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
}

