package com.polytech.polytech.repository;
import com.polytech.polytech.entity.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Long> {
    boolean existsByUsername(String username);
}