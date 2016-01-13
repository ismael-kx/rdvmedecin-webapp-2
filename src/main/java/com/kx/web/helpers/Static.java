package com.kx.web.helpers;

import rdvmedecins.entities.Creneau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by  KX-iMac on 12/01/2016.
 */
public class Static {

    public static List<String> getErreursForException(Exception exception) {
    // on récupère la liste des messages d'erreur de l'exception
        Throwable cause = exception;
        List<String> erreurs = new ArrayList<String>();
        while (cause != null) {
            erreurs.add(cause.getMessage());
            cause = cause.getCause();
        }
        return erreurs; }

    public static List<Map<String, Object>> getListMapForCreneaux(List<Creneau> créneaux) {
// liste de dictionnaires <String,Object>
        List<Map<String, Object>> liste = new ArrayList<Map<String, Object>>();
        for (Creneau créneau : créneaux) {
            liste.add(Static.getMapForCreneau(créneau));
        }
// on rend la liste
        return liste;}
    public static Map<String, Object> getMapForCreneau(Creneau créneau) {
// qq chose à faire ?
        if (créneau == null) {
            return null;
        }
// dictionnaire <String,Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("id", créneau.getId());
        hash.put("hDebut", créneau.getHdebut());
        hash.put("mDebut", créneau.getMdebut());
        hash.put("hFin", créneau.getHfin());
        hash.put("mFin", créneau.getMfin());
        // on rend le dictionnaire
        return hash;}

}
