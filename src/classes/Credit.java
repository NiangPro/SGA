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
public class Credit extends Compte {
    
    private Float marge;
    private int existeDeja;
    
    public Credit(Float solde, String etat, Client client, Date dateOuverture) {
        super(solde, etat, client, dateOuverture);
    }
    
}
