package model.service.impl;

import model.bean.Services;
import model.repository.ServiceRepository;
import model.service.api.ServiceManager;

import java.util.List;

public class IServiceManager implements ServiceManager {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public List<Services> findAll() {
        return serviceRepository.getAllService();
    }

    @Override
    public boolean save(Services services) {
        return serviceRepository.insertService(services);
    }

    @Override
    public Services findById(int id) {
        return serviceRepository.getService(id);
    }

    @Override
    public boolean update(int id, Services services) {
        return serviceRepository.updateService(id,services);
    }

    @Override
    public boolean remove(int id) {
        return serviceRepository.delService(id);
    }

    @Override
    public List<Services> findByName(String search) {
        return serviceRepository.searchService(search);
    }
}
