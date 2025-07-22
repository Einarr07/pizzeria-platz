package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.CustomerEntity;
import com.platzi.pizza.persistence.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerEntity findPhone(String phone) {
        return customerRepository.findByPhoneNumber(phone);
    }
}
