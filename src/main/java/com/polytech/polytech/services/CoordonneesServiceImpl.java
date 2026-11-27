package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.entity.Coordonnees;

import com.polytech.polytech.reposotory.CoordonneesReposotory;

@Service
public class CoordonneesServiceImpl implements CoordonneesService {


    private final CoordonneesReposotory repo;

    public CoordonneesServiceImpl(CoordonneesReposotory coordonneesRepository) {
        this.repo = coordonneesRepository;
    }




    @Override
    public Coordonnees saveCoordonnees(Coordonnees coordonnees) {
        // check the uniqueness of the coordonnees before saving either id or longitude and latitude
        if (coordonnees.getId() != null && repo.existsById(coordonnees.getId())) {
            throw new IllegalArgumentException("Coordonnees with ID " + coordonnees.getId() + " already exists.");
        }
        
        if (repo.existsByLongitudeAndLatitude(coordonnees.getLongitude(), coordonnees.getLatitude())){
            throw new IllegalArgumentException("Coordonnees with longitude " + coordonnees.getLongitude() + " and latitude " + coordonnees.getLatitude() + " already exists.");
        }

        return repo.save(coordonnees);
    }













    @Override
    public List<Coordonnees> fetchCoordonneesList() {
        return repo.findAll();
    }



    @Override
    public Coordonnees updateCoordonnees(Coordonnees coordonnees, Long coordonneesId) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'updateCoordonnees'");

        //check if coordonnees with the given id exists 
        Coordonnees coord_found = findCoordonneesById(coordonneesId);
        coord_found.setLatitude(coordonnees.getLatitude());
        coord_found.setLongitude(coordonnees.getLongitude());
        return repo.save(coord_found);

}

    @Override
    public void deleteCoordonneesById(Long coordonneesId) {
        findCoordonneesById(coordonneesId);
        repo.deleteById(coordonneesId);
    }
    @Override
    public Coordonnees findCoordonneesById(Long coordonneesId) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findCoordonneesById'");
        return repo.findById(coordonneesId)
                .orElseThrow(() -> new IllegalArgumentException("Coordonnees with ID " + coordonneesId + " not found."));
    }

    // Implement the methods defined in the CoordonneesService interface





}
