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
    protected Float solde;
    protected int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    protected Date dateOuverture;
    protected String code_client;    
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getCode_client() {
        return code_client;
    }

    public void setCode_client(String code_client) {
        this.code_client = code_client;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
    

    /**
     *
     * @param solde
     * @param etat
     * @param code_client
     * @param type
     * @param dateOuverture
     */
    public Compte(Float solde, int etat, String code_client,String type, Date dateOuverture) {
        this.solde = solde;
        this.etat = etat;
        this.type = type;
        this.dateOuverture = dateOuverture;
        this.code_client = code_client;
    }

    
    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

}
