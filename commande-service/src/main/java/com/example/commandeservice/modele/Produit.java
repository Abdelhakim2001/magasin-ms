package com.example.commandeservice.modele;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Produit {
    private Long idProduit;
    private final String libelle;
    private final Double prix;
}
