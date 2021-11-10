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
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class Connexion {
         
    public static Connection Db() throws ClassNotFoundException{
        try {
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/guichet_auto", "root", "");
            JOptionPane.showMessageDialog(null, "Connexion reussi");
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
