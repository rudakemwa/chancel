
package controlleur;
import modele.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FactoryEmploye {
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
        public static void setEmploye(Employe em){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into java_assureur.employe(id_employe,nom,prenom,adresse) values (?,?,?,?)");
            pstmet.setInt(1, em.getId_employe());
            pstmet.setString(2, em.getNom());
            pstmet.setString(3, em.getPrenom());
              pstmet.setString(4, em.getAdresse());
             
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Employe> getEmploye(){
        ArrayList<Employe> lic = new ArrayList();
        Employe em = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.employe");
            while(rs.next()){
                em = new Employe();
                em.setId_employe(rs.getInt("id_employe"));
                em.setNom(rs.getString("nom"));
                em.setPrenom(rs.getString("prenom"));
              em.setAdresse(rs.getString("adresse"));
               
                
                lic.add(em);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
         public static Employe getRechemploye(int cl){
        Employe em = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.employe where id_employe='"+cl+"'");
            if(rs.next()){
                em = new Employe();
                em.setId_employe(rs.getInt("id_employe"));
                em.setNom(rs.getString("nom"));
                em.setPrenom(rs.getString("prenom"));
                em.setAdresse(rs.getString("adresse"));
              
                
            }
            conn.close();
            stm.close();
            return em;
        }
        catch(Exception e){
        return null;
        }
        }
           public static void getDelemploye(Employe cl){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from java_assureur.employe where id_employe='"+cl.getId_employe()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
                public static void getupdate(int id_employe,String nom,String prenom,String adresse){
        try{
            conn = getConnection();
            stm = conn.createStatement();
   String requete = "update java_assureur.employe set nom='"+nom+"',prenom='"+prenom+"',adresse='"+adresse+"'where id_employe='"+id_employe+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
}
