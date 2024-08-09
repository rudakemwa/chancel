
package controlleur;
import modele.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FactoryProduit {
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
        public static void setProduit(Produit p){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into java_assureur.produit(id_produit,nom_produit,quantite) values (?,?,?)");
            pstmet.setInt(1, p.getId_produit());
            pstmet.setString(2, p.getNom_produit());
            pstmet.setInt(3, p.getQuantite());
              
             
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Produit> getProduit(){
        ArrayList<Produit> lic = new ArrayList();
        Produit p = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.produit");
            while(rs.next()){
                p = new Produit();
                p.setId_produit(rs.getInt("id_produit"));
                p.setNom_produit(rs.getString("nom_produit"));
                p.setQuantite(rs.getInt("quantite"));
            lic.add(p);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
         public static Produit getRechproduit(int cl){
        Produit p = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.produit where id_produit='"+cl+"'");
            if(rs.next()){
                p = new Produit();
                p.setId_produit(rs.getInt("id_produit"));
                p.setNom_produit(rs.getString("nom_produit"));
                p.setQuantite(rs.getInt("quantite"));
              
                
            }
            conn.close();
            stm.close();
            return p;
        }
        catch(Exception e){
        return null;
        }
        }
           public static void getDelproduit(Produit cl){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from java_assureur.produit where id_produit='"+cl.getId_produit()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
                public static void getupdate(int id_produit,String nom_produit,int quantite){
        try{
            conn = getConnection();
            stm = conn.createStatement();
   String requete = "update java_assureur.produit set nom_produit='"+nom_produit+"',quantite='"+quantite+"' where id_user='"+id_produit+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }


}
