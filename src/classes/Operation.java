/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import dataBase.Connexion;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author HP
 */
public class Operation {
    private Float montant;
    private TypeOp type;
    private Date dateOp;    
    private String numCpt;
    private Connexion db;
    private Compte compte;

    public Connexion getDb() {
        return db;
    }

    public void setDb(Connexion db) {
        this.db = db;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getNumCpt() {
        return numCpt;
    }

    public void setNumCpt(String numCpt) {
        this.numCpt = numCpt;
    }


    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public TypeOp getType() {
        return type;
    }

    public void setType(TypeOp type) {
        this.type = type;
    }

    public Date getDateOp() {
        return dateOp;
    }

    public void setDateOp(Date dateOp) {
        this.dateOp = dateOp;
    }

    public Operation(String numCpt, Float montant, TypeOp type, Date dateOp) {
        this.montant = montant;
        this.type = type;
        this.dateOp = dateOp;
        this.numCpt = numCpt;
        
        try {
            this.db = new Connexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = this.db.getCompteByNumCpt(this.numCpt);
        
        try {
            if(rs.next()){
                this.compte = new Compte(rs.getFloat("solde"), rs.getInt("etat"), rs.getString("code_client"), rs.getString("type"), rs.getDate("dateOuverture"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public static enum TypeOp{
        Depot, Retrait, Transfert,PaiementFacture
    }
    
    public void depotArgent(Float montant){
        
    }
    
     public int retrait(int somme) {
        montant = montant-somme;
        return somme;
    }
    
}
    