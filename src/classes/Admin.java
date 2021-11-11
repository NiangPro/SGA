/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Mariéme
 */
public class Admin extends Client{
    private int isAdmin;
    public Admin(String code, int nip, String nom, String prenom, String telephone, String courriel, TypeSexe sexe, int isAdmin) {
        super(code, nip, nom, prenom, telephone, courriel, sexe);
        this.isAdmin = isAdmin;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
