package com.restaurant.restaurant_management.controllers;

import com.restaurant.restaurant_management.entities.CategoriePlat;
import com.restaurant.restaurant_management.services.CategoriePlatService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Categories")
public class CategoriePlatController {

    private final CategoriePlatService categoriePlatService;

    @GetMapping
    public ResponseEntity<List<CategoriePlat>> getAllCategories() {
        return ResponseEntity.ok(categoriePlatService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriePlat> getCategorieById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriePlatService.getCategorieById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriePlat> createCategorie(@RequestBody CategoriePlat categorie) {
        return ResponseEntity.ok(categoriePlatService.createCategorie(categorie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        categoriePlatService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
}