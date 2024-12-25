package com.example.produitservice;

import com.example.produitservice.entiries.Produit;
import com.example.produitservice.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {

            Produit p1 = Produit.builder()
                    .libelle("T-shirt")
                    .prix(400.00)
                    .build();

            produitRepository.save(p1);
        };
    }

}
