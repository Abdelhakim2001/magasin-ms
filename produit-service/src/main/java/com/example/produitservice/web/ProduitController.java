package com.example.produitservice.web;

import com.example.produitservice.entiries.Produit;
import com.example.produitservice.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    ProduitRepository produitRepository;

    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

     @GetMapping("/produits")
    public List<Produit> allProducts(){
        return produitRepository.findAll();
    }

    @GetMapping("produits/{id}")
    public Produit aProduit(@PathVariable Long id){
        return produitRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produit not found with ID : "+id));
    }

    @PostMapping("/produits")
    public Produit save(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }


}
