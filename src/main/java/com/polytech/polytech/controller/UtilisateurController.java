package com.polytech.polytech.controller;

import com.polytech.polytech.DTO.UtilisateurDTO;
import com.polytech.polytech.services.UtilisateurService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController 
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;


    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping 
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.findUtilisateurById(id);
    }

    @PostMapping 
    public UtilisateurDTO createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.saveUtilisateur(utilisateurDTO);
    }

    @PostMapping("/{id}")
    public UtilisateurDTO updateUtilisateur(@PathVariable Long id,@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.updateUtilisateur(id, utilisateurDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateurById(id);
    }
}
