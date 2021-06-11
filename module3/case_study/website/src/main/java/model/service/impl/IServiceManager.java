package model.service.impl;

import model.bean.service.Services;
import model.repository.BaseRepository;
import model.repository.service.ServiceRepository;
import model.service.api.Service;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IServiceManager implements Service<Services> {
    BaseRepository<Services> serviceRepository = new ServiceRepository();

    @Override
    public List<Services> findAll() {
        return serviceRepository.getAll();
    }

    @Override
    public Map<String, String> save(Services services){
        Map<String, String> map = findErr(services);
        if (map.isEmpty()) serviceRepository.insert(services);
        return map;
    }

    @Override
    public Services findById(int id) {
        return serviceRepository.get(id);
    }

    @Override
    public  Map<String, String> update(int id, Services services) {
        Map<String, String> map = findErr(services);
        if (map.isEmpty()) serviceRepository.update(id, services);
        return map;
    }

    @Override
    public boolean remove(int id) {
        return serviceRepository.delete(id);
    }

    @Override
    public List<Services> findByName(String search) {
        return serviceRepository.search(search);
    }

    @Override
    public  Map<String, String> findErr(Services services) {
        Map<String, String> map= new HashMap<>();
        if (Validate.checkServiceId(services.getMaDichVu())) map.put("id", "Wrong format ID service");
        return map;
    }


}
