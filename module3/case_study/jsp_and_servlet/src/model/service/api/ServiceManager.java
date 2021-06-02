package model.service.api;
import model.bean.Services;

import java.util.List;

public interface ServiceManager {
    List<Services> findAll();
    boolean save(Services services);
    Services findById(int id);
    boolean update(int id, Services services);
    boolean  remove(int id);
    List<Services> findByName(String search);
}
