package com.example.commandeservice.feign;

import com.example.commandeservice.modele.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {

    @GetMapping("/clients")
    public List<Client> getClients();

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id);
}
