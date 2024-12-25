package com.example.commandeservice;

import com.example.commandeservice.entities.Commande;
import com.example.commandeservice.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CommandeRepository commandeRepository){
        return args -> {

            Commande commande = Commande.builder()
                    .totalMontant(50000.00)
                    .adresseLivraison("Rabat")
                    .build();

            commandeRepository.save(commande);
        };
    }

}
