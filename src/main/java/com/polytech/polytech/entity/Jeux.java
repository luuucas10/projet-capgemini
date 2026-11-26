package com.polytech.polytech.entity;
import jakarta.persistence.*;

@Entity 
@Table (name="jeux")
public class Jeux {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name="nom")
    private String nom;

    @Column (name="quantite")
    private int quantite;

    @Column (name="description")
    private String description;

    //constructeurs
    public Jeux() {
    }

    public Jeux(String nom, int quantite, String description) {
        this.nom = nom;
        this.quantite = quantite;
        this.description = description;
    }

    // getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
