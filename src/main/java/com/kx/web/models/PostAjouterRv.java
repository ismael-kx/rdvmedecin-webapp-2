package com.kx.web.models;

/**
 * Created by  KX-iMac on 12/01/2016.
 */
public class PostAjouterRv {

    // données du post
    private String jour;
    private long idClient;
    private long idCreneau;

    public PostAjouterRv() {
    }

    public long getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(long idCreneau) {
        this.idCreneau = idCreneau;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }
}
