
package controlleur;
import modele.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FactoryUtilisateur {
        public static Connection conn = null;
    public static Statement stm;
    public static PreparedStatement pstmet = null;
    public static ResultSet rs = null;
//    Methode pour la connection avec la base de donnee
    public static Connection getConnection(){
        String serveur = "localhost";
        int port = 3306;
        String database = "java_assureur";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + serveur + ":" + port +"/"+ database;
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        } 
    }
//        Get & Set pour le Formulaire Chambre
        public static void setUtilisateur(Utilisateur u){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into java_assureur.user(id_user,nom,password,statut,etat) values (?,?,?,?,?)");
            pstmet.setInt(1, u.getId_user());
            pstmet.setString(2, u.getNom());
            pstmet.setString(3, u.getPassword());
              pstmet.setString(4, u.getStatut());
                 pstmet.setString(5, u.getEtat());
             
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Utilisateur> getUtilisateur(){
        ArrayList<Utilisateur> lic = new ArrayList();
        Utilisateur u = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.user");
            while(rs.next()){
                u = new Utilisateur();
                u.setId_user(rs.getInt("id_user"));
                u.setNom(rs.getString("nom"));
                u.setPassword(rs.getString("password"));
              u.setStatut(rs.getString("statut"));
               u.setEtat(rs.getString("etat"));
               
                
                lic.add(u);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
         public static Utilisateur getRechutilisateur(int cl){
        Utilisateur u = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.user where id_user='"+cl+"'");
            if(rs.next()){
                u = new Utilisateur();
                u.setId_user(rs.getInt("id_user"));
                u.setNom(rs.getString("nom"));
                u.setPassword(rs.getString("password"));
                u.setStatut(rs.getString("statut"));
                u.setEtat(rs.getString("etat"));
              
                
            }
            conn.close();
            stm.close();
            return u;
        }
        catch(Exception e){
        return null;
        }
        }
           public static void getDelutilisateur(Utilisateur cl){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from java_assureur.user where id_user='"+cl.getId_user()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
                public static void getupdate(int id_user,String nom,String password,String statut,String[] etat){
        try{
            conn = getConnection();
            stm = conn.createStatement();
   String requete = "update java_assureur.user set nom='"+nom+"',password='"+password+"',statut='"+statut+"',etat='"+etat+"' where id_user='"+id_user+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }

//    public static void getupdate(int id_user, String nom, String password, String statut, String[] etat) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
