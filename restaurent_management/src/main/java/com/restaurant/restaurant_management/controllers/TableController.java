package com.restaurant.restaurant_management.controllers;

import com.restaurant.restaurant_management.entities.TableResto;
import com.restaurant.restaurant_management.entities.TableResto.StatutTable;
import com.restaurant.restaurant_management.services.TableService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Tables")
public class TableController {

    private final TableService tableService;

    @GetMapping
    public ResponseEntity<List<TableResto>> getAllTables() {
        return ResponseEntity.ok(tableService.getAllTables());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableResto> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTableById(id));
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<TableResto>> getTablesByStatut(@PathVariable StatutTable statut) {
        return ResponseEntity.ok(tableService.getTablesByStatut(statut));
    }

    @PostMapping
    public ResponseEntity<TableResto> createTable(@Valid @RequestBody TableResto table) {
        return ResponseEntity.ok(tableService.createTable(table));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableResto> updateTable(@PathVariable Long id, @Valid @RequestBody TableResto table) {
        return ResponseEntity.ok(tableService.updateTable(id, table));
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<TableResto> updateStatut(@PathVariable Long id, @RequestParam StatutTable statut) {
        return ResponseEntity.ok(tableService.updateStatut(id, statut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}