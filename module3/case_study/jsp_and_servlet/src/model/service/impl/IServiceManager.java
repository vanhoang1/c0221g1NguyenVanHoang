package model.service.impl;

import model.bean.Services;
import model.repository.BaseRepository;
import model.repository.ServiceRepository;
import model.service.api.Service;


import java.util.List;

public class IServiceManager implements Service<Services> {
   BaseRepository<Services> serviceRepository = new ServiceRepository();
    @Override
    public List<Services> findAll() {
        return serviceRepository.getAll();
    }

    @Override
    public boolean save(Services services) {
        return serviceRepository.insert(services);
    }

    @Override
    public Services findById(int id) {
        return serviceRepository.get(id);
    }

    @Override
    public boolean update(int id, Services services) {
        return serviceRepository.update(id,services);
    }

    @Override
    public boolean remove(int id) {
        return serviceRepository.delete(id);
    }

    @Override
    public List<Services> findByName(String search) {
        return serviceRepository.search(search);
    }
}
