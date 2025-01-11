package com.example.commandeservice.feign;

import com.example.commandeservice.modele.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitRestClient {

    @GetMapping("/produits")
    public List<Produit> getProduits();

    @GetMapping("/produits/{id}")
    public Produit getProduit(@PathVariable Long id);
}
