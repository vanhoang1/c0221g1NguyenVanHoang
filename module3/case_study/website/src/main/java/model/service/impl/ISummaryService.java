package model.service.impl;

import model.bean.Summary;
import model.repository.SummaryRepository;
import model.service.api.Service;

import java.util.List;
import java.util.Map;

public class ISummaryService implements Service<Summary> {
    SummaryRepository summaryRepository= new SummaryRepository()   ;
    @Override
    public List<Summary> findAll() {
        return summaryRepository.getAll();
    }

    @Override
    public Map<String, String> save(Summary summary) {
        return null;
    }

    @Override
    public Summary findById(int id) {
        return null;
    }

    @Override
    public Map<String, String> update(int id, Summary summary) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public List<Summary> findByName(String search) {
        return summaryRepository.search(search);
}

    @Override
    public Map<String, String> findErr(Summary summary) {
        return null;
    }
}
