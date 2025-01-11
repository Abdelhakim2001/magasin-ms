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
                    .idClient(1L)
                    .idProduit(1L)
                    .quantite(500)
                    .build();

            commandeRepository.save(commande);


            Commande cm2 = Commande.builder()
                    .idClient(1L)
                    .idProduit(2L)
                    .quantite(30)
                    .build();

            commandeRepository.save(cm2);
            Commande cm3 = Commande.builder()
                    .idClient(1L)
                    .idProduit(1L)
                    .quantite(5)
                    .build();
            commandeRepository.save(cm3);

            Commande cm4 = Commande.builder()
                    .idClient(2L)
                    .idProduit(2L)
                    .quantite(7)
                    .build();
            commandeRepository.save(cm4);

            Commande cm5 = Commande.builder()
                    .idClient(3L)
                    .idProduit(3L)
                    .quantite(10)
                    .build();
            commandeRepository.save(cm5);
        };


    }

}
