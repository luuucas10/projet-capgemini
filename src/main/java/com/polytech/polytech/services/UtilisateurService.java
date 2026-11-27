package com.polytech.polytech.services;

import com.polytech.polytech.repository.ReservationRepository;
import com.polytech.polytech.repository.UtilisateurRepository;
import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateurs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.polytech.mapper.Mapper;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository,
            ReservationRepository reservationRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateurs> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(Mapper::toUtilisateurDTO).toList();
    }

    public UtilisateurDTO getById(Long id) {
        Utilisateurs utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id: " + id));
        return Mapper.toUtilisateurDTO(utilisateur);
    }

}
