package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.DTO.CoordonneesDTO;
import com.polytech.polytech.entity.Coordonees;
import com.polytech.polytech.mapper.Mapper;
import com.polytech.polytech.repository.CoordonneesRepository;

@Service
public class CoordonneesService {
    private final CoordonneesRepository coordonneesRepository;

    public CoordonneesService(CoordonneesRepository coordonneesRepository) {
        this.coordonneesRepository = coordonneesRepository;
    }

    public List<CoordonneesDTO> getAllCoordonnees() {
        return coordonneesRepository.findAll().stream()
                .map(Mapper::toCoordonneesDTO)
                .toList();
    }

    public CoordonneesDTO findCoordonneesById(Long id) {
        Coordonees coordonnees = coordonneesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordonnees not found with id: " + id));
        return Mapper.toCoordonneesDTO(coordonnees);
    }

    public CoordonneesDTO saveCoordonnees(CoordonneesDTO coordonneesDTO) {
        if (coordonneesDTO.id() != null && coordonneesRepository.existsById(coordonneesDTO.id())) {
            throw new RuntimeException("Coordonnees already exists with id: " + coordonneesDTO.id());
        }
        if (coordonneesRepository.existsByLongitudeAndLatitude(coordonneesDTO.longitude(), coordonneesDTO.latitude())) {
            throw new RuntimeException("Coordonnees already exist for longitude " + coordonneesDTO.longitude()
                    + " and latitude " + coordonneesDTO.latitude());
        }
        Coordonees saved = coordonneesRepository.save(Mapper.toCoordonneesEntity(coordonneesDTO));
        return Mapper.toCoordonneesDTO(saved);
    }

    public CoordonneesDTO updateCoordonnees(Long id, CoordonneesDTO coordonneesDTO) {
        Coordonees existing = coordonneesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordonnees not found with id: " + id));

        existing.setLatitude(coordonneesDTO.latitude());
        existing.setLongitude(coordonneesDTO.longitude());
        existing.setJeuxId(coordonneesDTO.jeuxId());

        return Mapper.toCoordonneesDTO(coordonneesRepository.save(existing));
    }

    public void deleteCoordonneesById(Long id) {
        if (!coordonneesRepository.existsById(id)) {
            throw new RuntimeException("Coordonnees not found with id: " + id);
        }
        coordonneesRepository.deleteById(id);
    }

}
