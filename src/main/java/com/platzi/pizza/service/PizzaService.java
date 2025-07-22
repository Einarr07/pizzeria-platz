package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.repository.IPizzaPagSortRepository;
import com.platzi.pizza.persistence.repository.IPizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final IPizzaRepository pizzaRepository;
    private final IPizzaPagSortRepository pizzaPagSortRepository;

    /*public List<PizzaEntity> getAll() {
        return pizzaRepository.findAll();
    }*/

    public Page<PizzaEntity> getAll(int page, int elements) {

        PageRequest pageRequest = PageRequest.of(page, elements);
        return pizzaPagSortRepository.findAll(pageRequest);
    }

    /*
    public List<PizzaEntity> findAllByAvailableTrueOrderByPrice() {
        pizzaRepository.countByVeganTrue();
        return pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }
     */
    public Page<PizzaEntity> getAvailable(int page, int elements, String sortBy, String sorDirection) {
        pizzaRepository.countByVeganTrue();

        Sort sort = Sort.by(Sort.Direction.fromString(sorDirection), sortBy);
        PageRequest pageRequest = PageRequest.of(page, elements, sort);
        return pizzaPagSortRepository.findByAvailableTrue(pageRequest);
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
