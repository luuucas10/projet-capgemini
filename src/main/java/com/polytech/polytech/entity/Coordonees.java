package com.polytech.polytech.entity;
import jakarta.persistence.*;

@Entity
@Table (name="coordonnees")
public class Coordonees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name="latitude")
    private String latitude;

    @Column (name="longitude")
    private String longitude;

    @Column (name="jeux_id")
    private int jeuxId;

    //constructeurs
    public Coordonees() {
    }

    public Coordonees(String latitude, String longitude, int jeuxId) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.jeuxId = jeuxId;
    }

    // getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public long getJeuxId() {
        return jeuxId;
    }

        public void setJeuxId(long jeuxId) {
        this.jeuxId = jeuxId;
    }
}
