package com.example.commandeservice.web;

import com.example.commandeservice.entities.Commande;
import com.example.commandeservice.repository.CommandeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {

    CommandeRepository commandeRepository;

    public CommandeController(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @GetMapping("/commandes")
    public List<Commande> commandes(){
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/{id}")
    public Commande commande(@PathVariable Long id){
        return commandeRepository.findById(id).get();
    }

    @PostMapping("/commandes")
    public Commande save(@RequestBody Commande commande){
        return commandeRepository.save(commande);
    }
}
