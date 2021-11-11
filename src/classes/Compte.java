/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Compte {
    protected String code;
    protected int nip;
    protected Float solde;
    protected String etat;
    protected Date dateOuverture;

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
    protected Client client;

    /**
     *
     * @param solde
     * @param etat
     * @param code
     * @param nip
     * @param client
     * @param dateOuverture
     */
    public Compte(Float solde, String etat, String code, int nip, Client client, Date dateOuverture) {
        this.solde = solde;
        this.etat = etat;
        this.code = code;
        this.nip = nip;
        this.dateOuverture = dateOuverture;
        this.client = client;
    }

    
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public int getNip() {
        return nip;
    }
    
    public void setNip(int nip) {
        this.nip = nip;
    }
    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
