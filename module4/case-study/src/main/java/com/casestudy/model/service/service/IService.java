package com.casestudy.model.service.service;

import com.casestudy.model.entity.service.RentType;
import com.casestudy.model.entity.service.ServiceType;
import com.casestudy.model.entity.service.Services;
import com.casestudy.model.service.IGeneralService;

public interface IService extends IGeneralService<Services> {
    Iterable<RentType> findAllRentType();
    Iterable<ServiceType> findAllServiceType();
}
