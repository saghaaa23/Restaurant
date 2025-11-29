package com.restaurant.restaurant_management.repositories;

import com.restaurant.restaurant_management.entities.Reservation;
import com.restaurant.restaurant_management.entities.Reservation.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStatut(StatutReservation statut);
    List<Reservation> findByDateHeureBetween(LocalDateTime start, LocalDateTime end);
}