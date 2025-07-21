package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface IPizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

}
