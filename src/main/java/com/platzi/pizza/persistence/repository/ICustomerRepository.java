package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends ListCrudRepository<CustomerEntity, String> {

    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phoneNumber")
    CustomerEntity findByPhoneNumber(@Param("phoneNumber") String phone);
}
