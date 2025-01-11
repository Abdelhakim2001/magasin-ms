package com.example.clientservice;

import com.example.clientservice.entities.Client;
import com.example.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableDiscoveryClient
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository){

        return args -> {

            Client c1 = Client.builder()
                    .nom("Akchouch")
                    .prenom("Abdelhakim")
                    .build();

             clientRepository.save(c1);

            Client c2 = Client.builder()
                    .nom("Akchouch")
                    .prenom("Mourad")
                    .build();

            clientRepository.save(c2);

            Client c3 = Client.builder()
                    .nom("Akchouch")
                    .prenom("Achraf")
                    .build();

            clientRepository.save(c3);
        };
    }

}
