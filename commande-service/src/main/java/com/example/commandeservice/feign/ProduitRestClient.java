package com.example.commandeservice.feign;

import com.example.commandeservice.modele.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "produit-service", url = "http://localhost:8091")
public interface ProduitRestClient {

    @GetMapping("/produits")
    List<Produit> getProduits();

    @GetMapping("/produits/{id}")
    Produit getProduit(@PathVariable("id") Long id);
}
