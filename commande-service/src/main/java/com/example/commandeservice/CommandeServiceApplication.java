package com.example.commandeservice;

import com.example.commandeservice.entities.Commande;
import com.example.commandeservice.feign.ClientRestClient;
import com.example.commandeservice.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CommandeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CommandeRepository commandeRepository, ClientRestClient clientRestClient){
        return args -> {

            Commande commande = Commande.builder()
                    .quantite(500)
                    .adresseLivraison("Rabat")
                    .build();

            commandeRepository.save(commande);

            System.out.println("Quantité des produits : "+commande.getQuantite());
            System.out.println("http://localhost:8090");
            System.out.println(clientRestClient.getClients());

        };


    }

}
