package com.polytech.polytech.services;

import java.util.List;

import com.polytech.polytech.entity.Utilisateur;

public interface UtilisateurService {

    Utilisateur saveUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> fetchUtilisateurList();

    Utilisateur findUtilisateurById(Long utilisateurId);

    Utilisateur updateUtilisateur(Utilisateur utilisateur, Long utilisateurId);

    void deleteUtilisateurById(Long utilisateurId);

}
