package com.polytech.polytech.entity;
import jakarta.persistence.*;

@Entity 
@Table(name="reservation")
public class Reservation {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name="utilisateur_id")
    private long utilisateurId;

    @Column (name="jeux_id")
    private long jeuxId;

    @Column (name="date_debut")
    private String dateDebut;

    @Column (name="date_fin")
    private String dateFin;

    //constructeurs
    public Reservation() {
    }

    public Reservation(long utilisateurId, long jeuxId, String dateDebut, String dateFin) {
        this.utilisateurId = utilisateurId;
        this.jeuxId = jeuxId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
    
    public long getJeuxId() {
        return jeuxId;
    }

    public void setJeuxId(long jeuxId) {
        this.jeuxId = jeuxId;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

}
