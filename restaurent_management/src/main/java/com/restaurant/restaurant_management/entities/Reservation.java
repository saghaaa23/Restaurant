package com.restaurant.restaurant_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String client;

    @NotBlank
    private String telephone;

    @Email
    private String email;

    @NotNull
    private LocalDateTime dateHeure;

    @NotNull
    @Min(1)
    @Max(20)
    private Integer nombrePersonnes;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private TableResto table;

    public enum StatutReservation {
        CONFIRMEE, ANNULEE, TERMINEE
    }

    @PrePersist
    protected void onCreate() {
        if (this.statut == null) {
            this.statut = StatutReservation.CONFIRMEE;
        }
    }
}