package com.luxecuisine.inventory.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.luxecuisine.inventory.model.Ingredient;
import com.luxecuisine.inventory.service.IngredientService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/search")
    public List<Ingredient> searchIngredients(@RequestParam String query) {
        return ingredientService.searchIngredients(query);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient updated) {
        return ingredientService.updateIngredient(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }

    @GetMapping("/report")
    public Map<String, Object> generateReport() {
        return ingredientService.generateReport();
    }
}
