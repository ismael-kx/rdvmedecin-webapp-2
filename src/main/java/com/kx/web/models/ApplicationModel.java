package com.kx.web.models;

import com.kx.web.helpers.Static;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rdvmedecins.domain.AgendaMedecinJour;
import rdvmedecins.entities.Client;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.entities.Rv;
import rdvmedecins.metier.IMetier;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by  KX-iMac on 12/01/2016.
 */
@Component
public class ApplicationModel {
    @Autowired
    private IMetier metier;
    // données provenant de la couche [metier]
    private List<Medecin> medecins;
    private List<Client> clients; // messages d'erreur
    private List<String> messages;

    @PostConstruct
    public void init() {
// on récupère les medecins et les clients
    try {
        medecins = metier.getAllMedecins();
        clients = metier.getAllClients();
    } catch (Exception ex) {
        messages = Static.getErreursForException(ex); }
}
    // getter
    public List<String> getMessages() {
        return messages; }
    // ------------------------- interface couche [metier]
    
    public List<Client> getAllClients() {
        return clients; }
      
    public List<Medecin> getAllMedecins() {
        return medecins;
    }
      
    public List<Creneau> getAllCreneaux(long idMedecin) {
        return metier.getAllCreneaux(idMedecin); }
      
    public List<Rv> getRvMedecinJour(long idMedecin, Date jour) {
        return metier.getAllRvMedecinJour(idMedecin, jour);
    }
      
    public Client getClientById(long id) {
        return metier.getClientById(id); }
      
    public Medecin getMedecinById(long id) {
        return metier.getMedecinById(id);
    }

      
    public Rv getRvById(long id) {
        return metier.getRvById(id); }
      
    public Creneau getCreneauById(long id)
    {
        return metier.getCreneauByid(id);
    }

      
    public Rv ajouterRv(Date jour, Creneau creneau, Client client) {

        return metier.ajouterRv(jour, creneau, client);
    }

      
    public void supprimerRv(Rv rv)
    {
        metier.supprimerRv(rv);
    }


    public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour) {
        return metier.getAgendaMedecinJour(idMedecin, jour);
    }
}
