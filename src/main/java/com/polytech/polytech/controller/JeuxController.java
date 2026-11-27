package com.polytech.polytech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.polytech.polytech.DTO.JeuxDTO;
import com.polytech.polytech.services.JeuxService;

@RestController
@RequestMapping("/jeux")
public class JeuxController {
    private final JeuxService service;

    public JeuxController(JeuxService service) {
        this.service = service;
    }

    @GetMapping
    public List<JeuxDTO> getAll() {
        return service.getAllJeux();
    }

    @GetMapping("/{id}")
    public JeuxDTO getById(@PathVariable Long id) {
        return service.findJeuxById(id);
    }

    @PostMapping
    public ResponseEntity<JeuxDTO> create(@RequestBody JeuxDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveJeux(dto));
    }

    @PutMapping("/{id}")
    public JeuxDTO update(@PathVariable Long id, @RequestBody JeuxDTO dto) {
        return service.updateJeux(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteJeuxById(id);
        return ResponseEntity.noContent().build();
    }

}
