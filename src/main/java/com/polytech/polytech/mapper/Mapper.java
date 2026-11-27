package com.polytech.polytech.mapper;

import com.polytech.polytech.entity.Utilisateurs;

import com.polytech.polytech.entity.Jeux;
import com.polytech.polytech.entity.Coordonees;
import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.DTO.JeuxDTO;
import com.polytech.polytech.DTO.CoordonneesDTO;
import com.polytech.polytech.DTO.ReservationDTO;

public class Mapper {
    public static UtilisateurDTO toUtilisateurDTO(Utilisateurs utilisateur) {
        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getMail(),
                utilisateur.getPassword(),
                utilisateur.getUsername());
    }

    public static Utilisateurs toUtilisateurEntity(UtilisateurDTO utilisateurDTO) {
        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setId(utilisateurDTO.id());
        utilisateur.setNom(utilisateurDTO.nom());
        utilisateur.setPrenom(utilisateurDTO.prenom());
        utilisateur.setMail(utilisateurDTO.mail());
        utilisateur.setPassword(utilisateurDTO.password());
        utilisateur.setUsername(utilisateurDTO.username());
        return utilisateur;
    }

    public static JeuxDTO toJeuxDTO(Jeux jeux) {
        return new JeuxDTO(
                jeux.getId(),
                jeux.getNom(),
                jeux.getQuantite(),
                jeux.getDescription());
    }

    public static Jeux toJeuxEntity(JeuxDTO jeuxDTO) {
        Jeux jeux = new Jeux();
        if (jeuxDTO.id() != null) {
            jeux.setId(jeuxDTO.id());
        }
        jeux.setNom(jeuxDTO.nom());
        jeux.setQuantite(jeuxDTO.quantite());
        jeux.setDescription(jeuxDTO.description());
        return jeux;
    }

    public static Coordonees toCoordonneesEntity(CoordonneesDTO coordonneesDTO) {
        Coordonees coordonees = new Coordonees();
        if (coordonneesDTO.id() != null) {
            coordonees.setId(coordonneesDTO.id());
        }
        coordonees.setLatitude(coordonneesDTO.latitude());
        coordonees.setLongitude(coordonneesDTO.longitude());
        coordonees.setJeuxId(coordonneesDTO.jeuxId());
        return coordonees;
    }

    public static CoordonneesDTO toCoordonneesDTO(Coordonees coordonnees) {
        return new CoordonneesDTO(
                coordonnees.getId(),
                coordonnees.getLatitude(),
                coordonnees.getLongitude(),
                coordonnees.getJeuxId());
    }

    public static ReservationDTO toReservationDTO(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getUtilisateurId(),
                reservation.getJeuxId(),
                reservation.getReservation(),
                reservation.getDateDebut(),
                reservation.getDateFin());
    }

    public static Reservation toReservationEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        if (reservationDTO.id() != null) {
            reservation.setId(reservationDTO.id());
        }
        reservation.setUtilisateurId(reservationDTO.utilisateurId());
        reservation.setJeuxId(reservationDTO.jeuxId());
        reservation.setReservation(reservationDTO.reservation());
        reservation.setDateDebut(reservationDTO.dateDebut());
        reservation.setDateFin(reservationDTO.dateFin());
        return reservation;
    }
}
