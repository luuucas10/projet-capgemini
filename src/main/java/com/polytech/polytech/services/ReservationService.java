package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.DTO.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.mapper.Mapper;
import com.polytech.polytech.repository.JeuxRepository;
import com.polytech.polytech.repository.ReservationRepository;
import com.polytech.polytech.repository.UtilisateurRepository;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final JeuxRepository jeuxRepository;

    public ReservationService(ReservationRepository reservationRepository,
            UtilisateurRepository utilisateurRepository,
            JeuxRepository jeuxRepository) {
        this.reservationRepository = reservationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.jeuxRepository = jeuxRepository;
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(Mapper::toReservationDTO)
                .toList();
    }

    public ReservationDTO findReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
        return Mapper.toReservationDTO(reservation);
    }

    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        if (reservationDTO.id() != null && reservationRepository.existsById(reservationDTO.id())) {
            throw new RuntimeException("Reservation already exists with id: " + reservationDTO.id());
        }
        validate(reservationDTO);
        Reservation saved = reservationRepository.save(Mapper.toReservationEntity(reservationDTO));
        return Mapper.toReservationDTO(saved);
    }

    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation existing = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
        validate(reservationDTO);

        existing.setUtilisateurId(reservationDTO.utilisateurId());
        existing.setJeuxId(reservationDTO.jeuxId());
        existing.setReservation(reservationDTO.reservation());
        existing.setDateDebut(reservationDTO.dateDebut());
        existing.setDateFin(reservationDTO.dateFin());

        return Mapper.toReservationDTO(reservationRepository.save(existing));
    }

    public void deleteReservationById(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation not found with id: " + id);
        }
        reservationRepository.deleteById(id);
    }

    private void validate(ReservationDTO dto) {
        if (dto.utilisateurId() == null || !utilisateurRepository.existsById(dto.utilisateurId())) {
            throw new RuntimeException("Utilisateur not found with id: " + dto.utilisateurId());
        }

        if (dto.jeuxId() == null || !jeuxRepository.existsById(dto.jeuxId())) {
            throw new RuntimeException("Jeux not found with id: " + dto.jeuxId());
        }

        if (dto.dateDebut() != null && dto.dateFin() != null && dto.dateFin().compareTo(dto.dateDebut()) < 0) {
            throw new RuntimeException("dateFin must be after dateDebut.");
        }
    }

}
