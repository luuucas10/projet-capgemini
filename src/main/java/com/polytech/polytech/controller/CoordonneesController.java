package com.polytech.polytech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.polytech.DTO.CoordonneesDTO;
import com.polytech.polytech.services.CoordonneesService;

@RestController
@RequestMapping("/coordonnees")
public class CoordonneesController {
    private final CoordonneesService service;

    public CoordonneesController(CoordonneesService service) {
        this.service = service;
    }

    @GetMapping
    public List<CoordonneesDTO> getAll() {
        return service.getAllCoordonnees();
    }

    @GetMapping("/{id}")
    public CoordonneesDTO getById(@PathVariable Long id) {
        return service.findCoordonneesById(id);
    }

    @PostMapping
    public ResponseEntity<CoordonneesDTO> create(@RequestBody CoordonneesDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCoordonnees(dto));
    }

    @PutMapping("/{id}")
    public CoordonneesDTO update(@PathVariable Long id, @RequestBody CoordonneesDTO dto) {
        return service.updateCoordonnees(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCoordonneesById(id);
        return ResponseEntity.noContent().build();
    }

}
