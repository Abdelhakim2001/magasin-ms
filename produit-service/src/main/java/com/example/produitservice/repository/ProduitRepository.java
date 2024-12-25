package com.example.produitservice.repository;

import com.example.produitservice.entiries.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
