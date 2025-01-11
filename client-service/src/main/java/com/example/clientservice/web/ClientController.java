package com.example.clientservice.web;

import com.example.clientservice.entities.Client;
import com.example.clientservice.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public List<Client> allClients(){

        return clientRepository.findAll();
    }


    @GetMapping("clients/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
    }

    @PostMapping("/client")
    public Client save(@RequestBody Client client){
        return clientRepository.save(client);
    }
}
