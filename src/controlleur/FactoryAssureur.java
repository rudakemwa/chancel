
package controlleur;
import modele.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FactoryAssureur {
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
        public static void setAssureur(Assureur a){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into java_assureur.assureurs(id_assureur,nom,mail,adresse) values (?,?,?,?)");
            pstmet.setInt(1, a.getId_assureur());
            pstmet.setString(2, a.getNom());
          //  pstmet.setString(3, a.getPrenom());
             pstmet.setString(3, a.getMail());
            pstmet.setString(4, a.getAdresse());
             
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Assureur> getAssureur(){
        ArrayList<Assureur> lic = new ArrayList();
        Assureur a = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.assureurs");
            while(rs.next()){
                a = new Assureur();
                a.setId_assureur(rs.getInt("id_assureur"));
                a.setNom(rs.getString("nom"));
               // a.setPrenom(rs.getString("prenom"));
                a.setMail(rs.getString("mail"));
                a.setAdresse(rs.getString("adresse"));
               
                
                lic.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
         public static Assureur getRechassureur(int cl){
        Assureur a = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.assureurs where id_assureur='"+cl+"'");
            if(rs.next()){
                a = new Assureur();
                a.setId_assureur(rs.getInt("id_assureur"));
                a.setNom(rs.getString("nom"));
               // a.setPrenom(rs.getString("prenom"));
                  a.setMail(rs.getString("mail"));
                a.setAdresse(rs.getString("adresse"));
              
                
            }
            conn.close();
            stm.close();
            return a;
        }
        catch(Exception e){
        return null;
        }
        }
           public static void getDelassureur(Assureur cl){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from java_assureur.assureurs where id_assureur='"+cl.getId_assureur()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
                public static void getupdate(int id_assureur,String nom,String mail,String adresse){
        try{
            conn = getConnection();
            stm = conn.createStatement();
   String requete = "update java_assureur.assureurs set nom='"+nom+"',mail='"+mail+"',adresse='"+adresse+"'where id_assureur='"+id_assureur+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
}
