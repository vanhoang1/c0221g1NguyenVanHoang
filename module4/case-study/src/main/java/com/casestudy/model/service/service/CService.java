package com.casestudy.model.service.service;

import com.casestudy.model.entity.service.RentType;
import com.casestudy.model.entity.service.ServiceType;
import com.casestudy.model.entity.service.Services;
import com.casestudy.model.repository.service.IRentTypeRepository;
import com.casestudy.model.repository.service.IServiceTypeRepository;
import com.casestudy.model.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CService implements IService {

   private final  ServiceRepository serviceRepository;
   private final IRentTypeRepository rentTypeRepository;
   private  final IServiceTypeRepository serviceTypeRepository;
    @Autowired
    public CService(ServiceRepository serviceRepository, IRentTypeRepository rentTypeRepository, IServiceTypeRepository serviceTypeRepository) {
        this.serviceRepository = serviceRepository;
        this.rentTypeRepository = rentTypeRepository;
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public Page<Services> findAll(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Services> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Iterable<Services> findAllNormal() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Iterable<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }
}
