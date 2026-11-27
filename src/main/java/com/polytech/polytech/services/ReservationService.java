package com.polytech.polytech.services;

import java.util.List;

import com.polytech.polytech.entity.Reservation;

public interface ReservationService {

    Reservation saveReservation(Reservation reservation);

    List<Reservation> fetchReservationList();

    Reservation findReservationById(Long reservationId);

    Reservation updateReservation(Reservation reservation, Long reservationId);

    void deleteReservationById(Long reservationId);

}
