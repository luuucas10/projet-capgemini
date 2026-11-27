package com.polytech.polytech.services;

import java.util.List;

import com.polytech.polytech.entity.Terrain;

public interface TerrainService {

    Terrain saveTerrain(Terrain terrain);

    List<Terrain> fetchTerrainList();

    Terrain findTerrainById(Long terrainId);

    Terrain updateTerrain(Terrain terrain, Long terrainId);

    void deleteTerrainById(Long terrainId);

}
