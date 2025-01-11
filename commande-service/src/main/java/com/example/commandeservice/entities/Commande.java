package com.example.commandeservice.entities;


import com.example.commandeservice.modele.Client;
import com.example.commandeservice.modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Integer quantite;
    private String adresseLivraison;

    private Long idProduit;
    @Transient
    private Produit produit;

    private Long idClient;
    @Transient
    private Client client;


}
