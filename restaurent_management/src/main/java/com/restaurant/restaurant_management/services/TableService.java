package com.restaurant.restaurant_management.services;

import com.restaurant.restaurant_management.entities.TableResto;
import com.restaurant.restaurant_management.entities.TableResto.StatutTable;
import com.restaurant.restaurant_management.repositories.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TableService {

    private final TableRepository tableRepository;

    public List<TableResto> getAllTables() {
        return tableRepository.findAll();
    }

    public TableResto getTableById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table non trouvée"));
    }

    public List<TableResto> getTablesByStatut(StatutTable statut) {
        return tableRepository.findByStatut(statut);
    }

    public TableResto createTable(TableResto table) {
        if (table.getStatut() == null) {
            table.setStatut(StatutTable.LIBRE);
        }
        return tableRepository.save(table);
    }

    public TableResto updateTable(Long id, TableResto tableDetails) {
        TableResto table = getTableById(id);
        table.setNumero(tableDetails.getNumero());
        table.setCapacite(tableDetails.getCapacite());
        table.setStatut(tableDetails.getStatut());
        return tableRepository.save(table);
    }

    public TableResto updateStatut(Long id, StatutTable statut) {
        TableResto table = getTableById(id);
        table.setStatut(statut);
        return tableRepository.save(table);
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}