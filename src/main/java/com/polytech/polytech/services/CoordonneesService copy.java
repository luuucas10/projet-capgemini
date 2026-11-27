package com.polytech.polytech.services;

import java.util.List;


import com.polytech.polytech.entity.Coordonnees;



public interface CoordonneesService {

    Coordonnees saveCoordonnees(Coordonnees coordonnees);

    List<Coordonnees> fetchCoordonneesList();
    
    Coordonnees findCoordonneesById(Long coordonneesId);
    Coordonnees updateCoordonnees(Coordonnees coordonnees, Long coordonneesId);
    void deleteCoordonneesById(Long coordonneesId);

}
