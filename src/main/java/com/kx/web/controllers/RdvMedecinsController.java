package com.kx.web.controllers;

import com.kx.web.helpers.Static;
import com.kx.web.models.ApplicationModel;
import com.kx.web.models.PostAjouterRv;
import com.kx.web.models.PostSupprimerRv;
import com.kx.web.models.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.entities.Rv;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if(messages!=null)
            return new Reponse(1,messages);
        try{
            return new Reponse(0,application.getAllMedecins());
        }
        catch(Exception e){
            return new Reponse(-1, Static.getErreursForException(e));
        }
    }

    // liste des clients
    @RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public Reponse getAllClients() {
        if(messages!=null)
            return new Reponse(1,messages);
        try{
            return new Reponse(0,application.getAllClients());
        }
        catch(Exception e){
            return new Reponse(-1, Static.getErreursForException(e));
        }
    }

    // liste des créneaux d'un médecin
    @RequestMapping(value = "/getAllCreneaux/{idMedecin}", method = RequestMethod.GET)
    public Reponse getAllCreneaux(@PathVariable("idMedecin") long idMedecin) {
        if(messages!=null)
            return new Reponse(1,messages);
        Reponse reponse = getMedecinById(idMedecin);
            if (reponse.getStatus()!=0)
                return new Reponse(1,messages);
            Medecin medecin = (Medecin) reponse.getData();
            List<Creneau> creneaux = null;
        try{
            creneaux = application.getAllCreneaux(medecin.getId());
        }
        catch(Exception e){
            return new Reponse(-1, Static.getErreursForException(e));
        }
        return new Reponse(0,Static.getListMapForCreneaux(creneaux));
    }

    // liste des rendez-vous d'un médecin
    @RequestMapping(value = "/getRvMedecinJour/{idMedecin}/{jour}", method = RequestMethod.GET)
    public Reponse getRvMedecinJour(@PathVariable("idMedecin") long idMedecin, @PathVariable("jour") String jour) {
        if (messages != null) {
            return new Reponse(-1, messages);
        }
// on vérifie la date
        Date jourAgenda = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            jourAgenda = sdf.parse(jour);
        } catch (ParseException e) {
            return new Reponse(3, null);
        }
        // on récupère le médecin
        Reponse réponse = getMedecinById(idMedecin);
        if (réponse.getStatus() != 0) {
            return réponse;
        }
        Medecin médecin = (Medecin) réponse.getData();
        // liste de ses rendez-vous
        List<Rv> rvs = null;
        try {
            rvs = application.getRvMedecinJour(médecin.getId(), jourAgenda);
        } catch (Exception e1) {
            return new Reponse(4, Static.getErreursForException(e1));
        }
        // on rend la réponse
        return new Reponse(0, Static.getListMapForRvs(rvs));
    }
    }
    @RequestMapping(value = "/getClientById/{id}", method = RequestMethod.GET)
    public Reponse getClientById(@PathVariable("id") long id) {  
    }

    @RequestMapping(value = "/getMedecinById/{id}", method = RequestMethod.GET)
    public Reponse getMedecinById(@PathVariable("id") long id) {
        Medecin medecin = null;
        try{
            medecin = application.getMedecinById(id);
            }
        catch (Exception e){
                return new Reponse(-1,Static.getErreursForException(e));
        }
    return new Reponse(0,medecin);
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