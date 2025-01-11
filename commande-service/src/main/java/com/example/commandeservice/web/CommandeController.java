package com.example.commandeservice.web;

import com.example.commandeservice.entities.Commande;
import com.example.commandeservice.feign.ClientRestClient;
import com.example.commandeservice.feign.ProduitRestClient;
import com.example.commandeservice.modele.Client;
import com.example.commandeservice.modele.Produit;
import com.example.commandeservice.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {

    CommandeRepository commandeRepository;
    ClientRestClient clientRestClient;

    ProduitRestClient produitRestClient;

    @Autowired

    public CommandeController(CommandeRepository commandeRepository, ClientRestClient clientRestClient, ProduitRestClient produitRestClient) {
        this.commandeRepository = commandeRepository;
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
    }




    @GetMapping("/commandes")
    public List<Commande> commandes(){
        List<Commande> commandes = commandeRepository.findAll();

        for (Commande c : commandes){
            Produit p = produitRestClient.getProduit(c.getIdProduit());

            c.setProduit(p);

            Client clt = clientRestClient.getClient(c.getIdClient());
            c.setClient(clt);
        }
        return commandes;

    }


    @GetMapping("/commandes/{id}")
    public Commande commande(@PathVariable Long id){

        Commande commande = commandeRepository.findById(id).get();

        Produit produit = produitRestClient.getProduit(commande.getIdProduit());

        commande.setProduit(produit);

        Client client = clientRestClient.getClient(commande.getIdClient());
        commande.setClient(client);

        return commande;





    }

    @PostMapping("/commandes")
    public Commande save(@RequestBody Commande commande){
        return commandeRepository.save(commande);
    }

}
