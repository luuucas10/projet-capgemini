package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.reposotory.ReservationReposotory;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationReposotory repo;

    public ReservationServiceImpl(ReservationReposotory reservationRepository) {
        this.repo = reservationRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getDate_debut() != null && reservation.getDate_fin() != null
                && reservation.getDate_fin().before(reservation.getDate_debut())) {
            throw new IllegalArgumentException("date_fin must be after date_debut.");
        }
        return repo.save(reservation);
    }

    @Override
    public List<Reservation> fetchReservationList() {
        return repo.findAll();
    }

    @Override
    public Reservation findReservationById(Long reservationId) {
        return repo.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with ID " + reservationId + " not found."));
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long reservationId) {
        Reservation reservation_found = findReservationById(reservationId);
        reservation_found.setUtilisateur_id(reservation.getUtilisateur_id());
        reservation_found.setTerrain_id(reservation.getTerrain_id());
        reservation_found.setReservation(reservation.getReservation());
        reservation_found.setDate_debut(reservation.getDate_debut());
        reservation_found.setDate_fin(reservation.getDate_fin());
        return repo.save(reservation_found);
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        findReservationById(reservationId);
        repo.deleteById(reservationId);
    }

}
