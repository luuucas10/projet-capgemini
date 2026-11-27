package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.reposotory.UtilisateurReposotory;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

    private final UtilisateurReposotory repo;

    public UtilisateurServiceImp(UtilisateurReposotory utilisateurRepository) {
        this.repo = utilisateurRepository;
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return repo.save(utilisateur);
    }

    @Override
    public List<Utilisateur> fetchUtilisateurList() {
        return repo.findAll();
    }

    @Override
    public Utilisateur findUtilisateurById(Long utilisateurId) {
        return repo.findById(utilisateurId)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with ID " + utilisateurId + " not found."));
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long utilisateurId) {
        Utilisateur utilisateur_found = findUtilisateurById(utilisateurId);
        utilisateur_found.setNom(utilisateur.getNom());
        utilisateur_found.setPrenom(utilisateur.getPrenom());
        utilisateur_found.setMail(utilisateur.getMail());
        utilisateur_found.setPassword(utilisateur.getPassword());
        utilisateur_found.setUsername(utilisateur.getUsername());
        return repo.save(utilisateur_found);
    }

    @Override
    public void deleteUtilisateurById(Long utilisateurId) {
        findUtilisateurById(utilisateurId);
        repo.deleteById(utilisateurId);
    }

}
