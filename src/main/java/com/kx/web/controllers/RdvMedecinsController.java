package com.kx.web.controllers;

import com.kx.web.models.ApplicationModel;
import com.kx.web.models.PostAjouterRv;
import com.kx.web.models.PostSupprimerRv;
import com.kx.web.models.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by  KX-iMac on 12/01/2016.
 */

@RestController
public class RdvMedecinsController {
    @Autowired
    private ApplicationModel application;
    private List<String> messages;

    @PostConstruct
    public void init() {
    // messages d'erreur de l'application
        messages = application.getMessages();
    }

    // liste des médecins
    @RequestMapping(value = "/getAllMedecins", method = RequestMethod.GET)
    public Reponse getAllMedecins() {  
    }

    // liste des clients
    @RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public Reponse getAllClients() {  
    }

    // liste des créneaux d'un médecin
    @RequestMapping(value = "/getAllCreneaux/{idMedecin}", method = RequestMethod.GET)
    public Reponse getAllCreneaux(@PathVariable("idMedecin") long idMedecin) {  
    }

    // liste des rendez-vous d'un médecin
    @RequestMapping(value = "/getRvMedecinJour/{idMedecin}/{jour}", method = RequestMethod.GET)
    public Reponse getRvMedecinJour(@PathVariable("idMedecin") long idMedecin, @PathVariable("jour") String jour) {
    }
    @RequestMapping(value = "/getClientById/{id}", method = RequestMethod.GET)
    public Reponse getClientById(@PathVariable("id") long id) {  
    }

    @RequestMapping(value = "/getMedecinById/{id}", method = RequestMethod.GET)
    public Reponse getMedecinById(@PathVariable("id") long id) {
    }

    @RequestMapping(value = "/getRvById/{id}", method = RequestMethod.GET)
    public Reponse getRvById(@PathVariable("id") long id) { 
    }

    @RequestMapping(value = "/getCreneauById/{id}", method = RequestMethod.GET)
    public Reponse getCreneauById(@PathVariable("id") long id) {  
    }

    @RequestMapping(value = "/ajouterRv", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public Reponse ajouterRv(@RequestBody PostAjouterRv post) {
    }

    @RequestMapping(value = "/supprimerRv", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public Reponse supprimerRv(@RequestBody PostSupprimerRv post) {
    }

    @RequestMapping(value = "/getAgendaMedecinJour/{idMedecin}/{jour}", method = RequestMethod.GET)
    public Reponse getAgendaMedecinJour( @PathVariable("idMedecin") long idMedecin, @PathVariable("jour") String jour) {
    }
}