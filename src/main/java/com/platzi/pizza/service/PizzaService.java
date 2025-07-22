package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.repository.IPizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final IPizzaRepository pizzaRepository;

    public List<PizzaEntity> getAll() {
        return pizzaRepository.findAll();
    }

    public List<PizzaEntity> findAllByAvailableTrueOrderByPrice() {
        pizzaRepository.countByVeganTrue();
        return pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getWith(String description) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getWithOut(String description) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getCheapest(double price) {
        return pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity getPizzaByName(String name) {
        return pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("No exist the pizza"));
    }

    public PizzaEntity get(int id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizzaEntity) {
        return pizzaRepository.save(pizzaEntity);
    }

    public void delete(int id) {
        pizzaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return pizzaRepository.existsById(id);
    }


}
