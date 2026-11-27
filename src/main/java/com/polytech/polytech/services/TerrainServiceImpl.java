package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.reposotory.TerrainReposotory;

@Service
public class TerrainServiceImpl implements TerrainService {

    private final TerrainReposotory repo;

    public TerrainServiceImpl(TerrainReposotory terrainRepository) {
        this.repo = terrainRepository;
    }

    @Override
    public Terrain saveTerrain(Terrain terrain) {
        return repo.save(terrain);
    }

    @Override
    public List<Terrain> fetchTerrainList() {
        return repo.findAll();
    }

    @Override
    public Terrain findTerrainById(Long terrainId) {
        return repo.findById(terrainId)
                .orElseThrow(() -> new IllegalArgumentException("Terrain with ID " + terrainId + " not found."));
    }

    @Override
    public Terrain updateTerrain(Terrain terrain, Long terrainId) {
        Terrain terrain_found = findTerrainById(terrainId);
        terrain_found.setNom(terrain.getNom());
        terrain_found.setQuantity(terrain.getQuantity());
        terrain_found.setDescription(terrain.getDescription());
        return repo.save(terrain_found);
    }

    @Override
    public void deleteTerrainById(Long terrainId) {
        findTerrainById(terrainId);
        repo.deleteById(terrainId);
    }

}
