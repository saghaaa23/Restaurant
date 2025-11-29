package com.restaurant.restaurant_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tables_resto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableResto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String numero;

    @NotNull
    @Min(1)
    private Integer capacite;

    @Enumerated(EnumType.STRING)
    private StatutTable statut = StatutTable.LIBRE;

    public enum StatutTable {
        LIBRE, OCCUPEE, RESERVEE, HORS_SERVICE
    }
}