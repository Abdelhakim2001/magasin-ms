package com.example.commandeservice.feign;

import com.example.commandeservice.modele.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "client-service", url = "http://localhost:8090")
public interface ClientRestClient {

    @GetMapping("/clients")
    List<Client> getClients();

    @GetMapping("/clients/{id}")
    Client getClient(@PathVariable("id") Long id);
}
