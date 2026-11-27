package com.polytech.polytech.services;

import java.util.List;

import com.polytech.polytech.entity.Utilisateurs;

public interface UtilisateursServiceInterface {

    Utilisateurs saveUtilisateur(Utilisateurs utilisateur);

    List<Utilisateurs> fetchUtilisateurList();

    Utilisateurs findUtilisateurById(Long utilisateurId);

    Utilisateurs updateUtilisateur(Utilisateurs utilisateur, Long utilisateurId);

    void deleteUtilisateurById(Long utilisateurId);

}
