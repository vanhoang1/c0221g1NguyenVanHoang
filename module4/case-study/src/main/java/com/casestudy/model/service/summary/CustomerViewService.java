package com.casestudy.model.service.summary;

import com.casestudy.model.entity.customer.CustomerView;
import com.casestudy.model.repository.customer.ICustomerViewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerViewService implements  ICustomerViewService {
    private final ICustomerViewRepository customerViewRepository;

    public CustomerViewService(ICustomerViewRepository customerViewRepository) {
        this.customerViewRepository = customerViewRepository;
    }

    @Override
    public Page<CustomerView> findAll(Pageable pageable, String keyword) {
        return customerViewRepository.findAllByAttachServiceNameContainingOrCustomerNameContaining(pageable,'%'+ keyword+'%');
    }

    @Override
    public Optional<CustomerView> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<CustomerView> findAllNormal() {
        return null;
    }

    @Override
    public void save(CustomerView customerView) {

    }

    @Override
    public void remove(Long id) {

    }
}
