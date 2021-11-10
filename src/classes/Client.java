/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Mariéme
 */
public class Client {
    String code;
    int nip;
    String nom;
    String prenom;
    String telephone;
    String courriel;

    public Client(String code, int nip, String nom, String prenom, String telephone, String courriel) {
        this.code = code;
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
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
 
    public String getNom() {
        return nom;
    }
    
public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
 public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
 
    public String getTelephone() {
        return telephone;
    }
    
public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }
        
public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

}
