package com.restaurant.restaurant_management.services;

import com.restaurant.restaurant_management.entities.Reservation;
import com.restaurant.restaurant_management.entities.Reservation.StatutReservation;
import com.restaurant.restaurant_management.entities.TableResto;
import com.restaurant.restaurant_management.repositories.ReservationRepository;
import com.restaurant.restaurant_management.repositories.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TableRepository tableRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
    }

    public List<Reservation> getReservationsByStatut(StatutReservation statut) {
        return reservationRepository.findByStatut(statut);
    }

    public List<Reservation> getReservationsByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return reservationRepository.findByDateHeureBetween(start, end);
    }

    public Reservation createReservation(Reservation reservation) {
        if (reservation.getTable() != null && reservation.getTable().getId() != null) {
            TableResto table = tableRepository.findById(reservation.getTable().getId())
                    .orElseThrow(() -> new RuntimeException("Table non trouvée"));
            reservation.setTable(table);
        }
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = getReservationById(id);
        reservation.setClient(reservationDetails.getClient());
        reservation.setTelephone(reservationDetails.getTelephone());
        reservation.setEmail(reservationDetails.getEmail());
        reservation.setDateHeure(reservationDetails.getDateHeure());
        reservation.setNombrePersonnes(reservationDetails.getNombrePersonnes());

        if (reservationDetails.getTable() != null && reservationDetails.getTable().getId() != null) {
            TableResto table = tableRepository.findById(reservationDetails.getTable().getId())
                    .orElseThrow(() -> new RuntimeException("Table non trouvée"));
            reservation.setTable(table);
        }

        return reservationRepository.save(reservation);
    }

    public Reservation updateStatut(Long id, StatutReservation statut) {
        Reservation reservation = getReservationById(id);
        reservation.setStatut(statut);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}