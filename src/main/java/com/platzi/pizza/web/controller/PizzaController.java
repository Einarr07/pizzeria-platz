package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.PizzaService;
import com.platzi.pizza.service.dto.UpdatePizzaPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAllPizzas(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }

    @GetMapping("/available")
    public ResponseEntity<Page<PizzaEntity>> getAllAvailablePizzas(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "8") int elements,
                                                                   @RequestParam(defaultValue = "price") String sortBy,
                                                                   @RequestParam(defaultValue = "ASC") String sorDirection) {
        return ResponseEntity.ok(pizzaService.getAvailable(page, elements, sortBy, sorDirection));
    }

    @GetMapping("/by-description/{description}")
    public ResponseEntity<List<PizzaEntity>> getAllByDescription(@PathVariable String description) {
        return ResponseEntity.ok(pizzaService.getWith(description));
    }

    @GetMapping("/by-not-description/{description}")
    public ResponseEntity<List<PizzaEntity>> getAllByNotDescription(@PathVariable String description) {
        return ResponseEntity.ok(pizzaService.getWithOut(description));
    }

    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapest(@PathVariable double price) {
        return ResponseEntity.ok(pizzaService.getCheapest(price));
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<PizzaEntity> getPizzaByName(@PathVariable String name) {
        return ResponseEntity.ok(pizzaService.getPizzaByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> getPizzaById(@PathVariable int id) {
        return ResponseEntity.ok(pizzaService.get(id));
    }

    @PostMapping("/add")
    public ResponseEntity<PizzaEntity> addPizza(@RequestBody PizzaEntity pizzaEntity) {

        if (pizzaEntity.getIdPizza() == null || !pizzaService.existsById(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizzaEntity) {

        if (pizzaEntity.getIdPizza() != null && pizzaService.existsById(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));

        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update-price")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDTO dto) {

        if(pizzaService.existsById(dto.getPizzaId())) {
            pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable int id) {

        if (pizzaService.existsById(id)) {
            pizzaService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}


