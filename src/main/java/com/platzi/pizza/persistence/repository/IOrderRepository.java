package com.platzi.pizza.persistence.repository;


import com.platzi.pizza.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface IOrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}
