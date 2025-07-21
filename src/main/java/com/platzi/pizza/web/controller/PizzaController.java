package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<PizzaEntity>> getAllPizzas() {
        return ResponseEntity.ok(this.pizzaService.getAll());
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable int id) {

        if (pizzaService.existsById(id)) {
            pizzaService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}


