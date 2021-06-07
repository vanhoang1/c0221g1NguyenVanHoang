package model.service.impl;

import model.bean.Summary;
import model.repository.SummaryRepository;
import model.service.api.Service;

import java.util.List;

public class ISummaryService implements Service<Summary> {
    SummaryRepository summaryRepository= new SummaryRepository()   ;
    @Override
    public List<Summary> findAll() {
        return summaryRepository.getAll();
    }

    @Override
    public boolean save(Summary summary) {
        return false;
    }

    @Override
    public Summary findById(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Summary summary) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public List<Summary> findByName(String search) {
        return summaryRepository.search(search);
}
}
