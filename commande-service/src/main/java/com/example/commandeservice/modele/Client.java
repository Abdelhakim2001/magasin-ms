package com.example.commandeservice.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    @ToString
    public class Client {
        private Long idClient;
        private final String nom;
        private final String prenom;
    }


