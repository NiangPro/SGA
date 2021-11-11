/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Date;

/**
 *
 * @author Mariéme
 */
public class Epargne extends Compte{
    
    public Epargne(Float solde, String etat, String code, int nip, Client client, Date dateOuverture) {
        super(solde, etat, code, nip, client, dateOuverture);
    }
    
}
