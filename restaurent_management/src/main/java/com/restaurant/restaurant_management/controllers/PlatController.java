package com.restaurant.restaurant_management.controllers;

import com.restaurant.restaurant_management.entities.Plat;
import com.restaurant.restaurant_management.services.PlatService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/plats")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Plats")
public class PlatController {

    private final PlatService platService;

    @GetMapping
    public ResponseEntity<List<Plat>> getAllPlats() {
        return ResponseEntity.ok(platService.getAllPlats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plat> getPlatById(@PathVariable Long id) {
        return ResponseEntity.ok(platService.getPlatById(id));
    }

    @GetMapping("/categorie/{categorieId}")
    public ResponseEntity<List<Plat>> getPlatsByCategorie(@PathVariable Long categorieId) {
        return ResponseEntity.ok(platService.getPlatsByCategorie(categorieId));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Plat>> getPlatsDisponibles() {
        return ResponseEntity.ok(platService.getPlatsDisponibles());
    }

    @PostMapping
    public ResponseEntity<Plat> createPlat(@Valid @RequestBody Plat plat) {
        return ResponseEntity.ok(platService.createPlat(plat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plat> updatePlat(@PathVariable Long id, @Valid @RequestBody Plat plat) {
        return ResponseEntity.ok(platService.updatePlat(id, plat));
    }

    @PatchMapping("/{id}/disponibilite")
    public ResponseEntity<Plat> updateDisponibilite(@PathVariable Long id, @RequestParam Boolean disponible) {
        return ResponseEntity.ok(platService.updateDisponibilite(id, disponible));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlat(@PathVariable Long id) {
        platService.deletePlat(id);
        return ResponseEntity.noContent().build();
    }
}