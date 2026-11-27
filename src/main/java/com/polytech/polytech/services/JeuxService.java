package com.polytech.polytech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.polytech.DTO.JeuxDTO;
import com.polytech.polytech.entity.Jeux;
import com.polytech.polytech.mapper.Mapper;
import com.polytech.polytech.repository.JeuxRepository;

@Service
public class JeuxService {
    private final JeuxRepository jeuxRepository;

    public JeuxService(JeuxRepository jeuxRepository) {
        this.jeuxRepository = jeuxRepository;
    }

    public List<JeuxDTO> getAllJeux() {
        return jeuxRepository.findAll().stream()
                .map(Mapper::toJeuxDTO)
                .toList();
    }

    public JeuxDTO findJeuxById(Long id) {
        Jeux jeux = jeuxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jeux not found with id: " + id));
        return Mapper.toJeuxDTO(jeux);
    }

    public JeuxDTO saveJeux(JeuxDTO jeuxDTO) {
        if (jeuxDTO.id() != null && jeuxRepository.existsById(jeuxDTO.id())) {
            throw new RuntimeException("Jeux already exists with id: " + jeuxDTO.id());
        }
        Jeux saved = jeuxRepository.save(Mapper.toJeuxEntity(jeuxDTO));
        return Mapper.toJeuxDTO(saved);
    }

    public JeuxDTO updateJeux(Long id, JeuxDTO jeuxDTO) {
        Jeux existing = jeuxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jeux not found with id: " + id));

        existing.setNom(jeuxDTO.nom());
        existing.setQuantite(jeuxDTO.quantite());
        existing.setDescription(jeuxDTO.description());

        return Mapper.toJeuxDTO(jeuxRepository.save(existing));
    }

    public void deleteJeuxById(Long id) {
        if (!jeuxRepository.existsById(id)) {
            throw new RuntimeException("Jeux not found with id: " + id);
        }
        jeuxRepository.deleteById(id);
    }

}
