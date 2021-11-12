/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBase;

/**
 *
 * @author HP
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class  Connexion {
    private Connection con;
    private Statement stm;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public Connexion() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/guichet_auto", "root", "");
            this.stm = this.con.createStatement();
                      
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            
        }
    }
    
    public ResultSet login(String code, String nip){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM client WHERE (code=? AND nip=?)");
            q.setString(1, code);
            q.setString(2, nip);
            ResultSet res = q.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet clients(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT * FROM client");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
