package com.polytech.polytech.DTO;

public record ReservationDTO(Long id, Long utilisateurId, Long jeuxId, int reservation, String dateDebut,
        String dateFin) {

}
