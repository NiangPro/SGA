/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBase;

/**
 *
 * @author HP
 */
import classes.Client;
import classes.Compte;
import classes.Operation;
import java.sql.*;
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
    
    public Boolean depot(String numCpt, float montant){
        try {
            PreparedStatement q = con.prepareStatement("UPDATE `compte` SET `solde`=(`solde`+?) WHERE `numCpt`=?");
            q.setFloat(1, montant);
            q.setString(2, numCpt);
            
            System.out.println(q.executeUpdate());
            if(q.executeUpdate() == 0){
                return false;
            }else{
                return true;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return false;
        }
    }
    
    public Boolean addClient(Client client){
        try {
            PreparedStatement q = con.prepareStatement("INSERT INTO client VALUES(?,?,?,?,?,?,?,?)");
            q.setString(1, client.getCode());
            q.setString(2, client.getPrenom());
            q.setString(3, client.getNom());
            q.setString(4, client.getTel());
            q.setString(5, client.getCourriel());
            q.setString(6, client.getSexe());
            q.setInt(7, client.getNip());
            q.setInt(8, client.getEstAdmin());

            q.execute();
                return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return false;
        }
    }
    
    public Boolean addOperation(Operation opt){
        try {
            PreparedStatement q = con.prepareStatement("INSERT INTO operation VALUES(?,?,NOW(),?,?,?)");
            q.setFloat(1, opt.getMontant());
            q.setString(2, opt.getTypeOpt());
            q.setString(3, opt.getNumCpt());
            q.setInt(4, opt.getNbreBillet());
            q.setString(5, opt.getNumOpt());


            q.execute();
                return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return false;
        }
    }
    
    public Boolean addCompte(Compte cpt){
        try {
            PreparedStatement q = con.prepareStatement("INSERT INTO compte(solde, etat,type,code_client, numCpt) VALUES(?,?,?,?,?)");
            q.setFloat(1, cpt.getSolde());
            q.setInt(2, cpt.getEtat());
            q.setString(3, cpt.getType());
            q.setString(4, cpt.getCode_client());
            q.setString(5, cpt.getNumCompte());

            q.execute();
                return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return false;
        }
    }
    
    public ResultSet getCompteByCode(String code_client){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM compte WHERE (code_client=?)");
            q.setString(1, code_client);
            ResultSet res = q.executeQuery();
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
        }
        return null;
    }
    
    public ResultSet getCompteByNumCpt(String numCpt){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM compte WHERE (numCpt=?)");
            q.setString(1, numCpt);
            ResultSet res = q.executeQuery();
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
        }
        return null;
    }
    
    public ResultSet getCompteByType(String type, String code_client){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM compte WHERE (type=? AND code_client=?)");
            q.setString(1, type);
            q.setString(2, code_client);

            ResultSet res = q.executeQuery();
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
        }
        return null;
    }
    
    public ResultSet getClientByCode(String code_client){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM client WHERE (code=?)");
            q.setString(1, code_client);
            ResultSet res = q.executeQuery();
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
        }
        return null;
    }
    
    public Boolean codeAlreadyUse(String code){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM client WHERE (code=?)");
            q.setString(1, code);
            ResultSet res = q.executeQuery();
            if(res.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return false;
        }
        
    }
    
    public ResultSet login(String code, String nip){
        try {
            PreparedStatement q = this.con.prepareStatement("SELECT * FROM client WHERE (code=? AND nip=?)");
            q.setString(1, code);
            q.setString(2, nip);
            ResultSet res = q.executeQuery();
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return null;
        }
        
    }
    
    public ResultSet clients(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT * FROM client WHERE estAdmin = 0 ORDER BY nom ASC");
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return null;
        }
    }
    
    public ResultSet operations(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT * FROM operation ORDER BY numOpt DESC LIMIT 10");
            
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return null;
        }
    }
    
    public ResultSet comptes(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT * FROM compte ORDER BY numCpt DESC");
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return null;
        }
    }
    
    public int nbreClients(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT COUNT(*) as nbre FROM client;");
            if(res.next()){
                return res.getInt("nbre");
            }else{
                return 0;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return 0;
        }
    }
    
    public int nbreComptes(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT COUNT(*) as nbre FROM compte");
            if(res.next()){
                return res.getInt("nbre");
            }else{
                return 0;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return 0;
        }
    }
    
    public int nbreOperations(){
        try {
            ResultSet res = this.stm.executeQuery("SELECT COUNT(*) as nbre FROM operation");
            if(res.next()){
                return res.getInt("nbre");
            }else{
                return 0;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return 0;
        }
    }
    
    public int nbreComptesByType(String typeCpt){
        try {
            ResultSet res = this.stm.executeQuery("SELECT COUNT(*) as nbre FROM compte WHERE type = '"+typeCpt+"'");
            if(res.next()){
                return res.getInt("nbre");
            }else{
                return 0;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage()+"\n SQLState: " + e.getSQLState()+"\n VendorError: " + e.getErrorCode());
            return 0;
        }
    }

}
