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

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateurs> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(Mapper::toUtilisateurDTO).toList();
    }

    public UtilisateurDTO findUtilisateurById(Long id) {
        Utilisateurs utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id: " + id));
        return Mapper.toUtilisateurDTO(utilisateur);
    }

    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateurs utilisateur = Mapper.toUtilisateurEntity(utilisateurDTO);
        Utilisateurs savedUtilisateur = utilisateurRepository.save(utilisateur);
        return Mapper.toUtilisateurDTO(savedUtilisateur);
    }

    public UtilisateurDTO updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO) {
        Utilisateurs existingUtilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id: " + id));

        existingUtilisateur.setNom(utilisateurDTO.nom());
        existingUtilisateur.setPrenom(utilisateurDTO.prenom());
        existingUtilisateur.setMail(utilisateurDTO.mail());
        existingUtilisateur.setPassword(utilisateurDTO.password());
        existingUtilisateur.setUsername(utilisateurDTO.username());

        Utilisateurs updatedUtilisateur = utilisateurRepository.save(existingUtilisateur);
        return Mapper.toUtilisateurDTO(updatedUtilisateur);
    }

    public void deleteUtilisateurById(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur not found with id: " + id);
        }
        utilisateurRepository.deleteById(id);
    }

}
