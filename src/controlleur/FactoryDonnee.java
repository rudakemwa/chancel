
package controlleur;
import modele.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FactoryDonnee {
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
      public static void setDonnee(Donnee d){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into java_assureur.donnee(id_donnee,produits_sortis,produits_entres,date,id_produit) values (?,?,?,?,?)");
            pstmet.setInt(1, d.getId_donnee());
            pstmet.setString(2, d.getProduits_sortis());
            pstmet.setString(3, d.getProduits_entres());
           // LocalDate date = d.getDate();
           // java.sql.Date ddate = java.sql.Date.valueOf(date);
              pstmet.setString(4, d.getDate());
              pstmet.setInt(5,d.getId_produit());
             
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Donnee> getDonnee(){
        ArrayList<Donnee> lic = new ArrayList();
        Donnee d = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.donnee");
            while(rs.next()){
                d = new Donnee();
                d.setId_donnee(rs.getInt("id_donnee"));
                d.setProduits_sortis(rs.getString("produits_sortis"));
                d.setProduits_entres(rs.getString("produits_entres"));
                String date =rs.getString("date");
                LocalDate datee =LocalDate.parse(date);
              d.setId_produit(rs.getInt("id_produit"));
          lic.add(d);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
         public static Donnee getRechdonnee(int cl){
        Donnee d = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from java_assureur.donnee where id_donnee='"+cl+"'");
            if(rs.next()){
                d = new Donnee();
                d.setId_donnee(rs.getInt("id_donnee"));
                d.setProduits_sortis(rs.getString("produits_sortis"));
                d.setProduits_entres(rs.getString("produits_entres"));
                //String date =rs.getString("date");
                 // LocalDate datee =LocalDate.parse(date);
                 d.setDate(rs.getString("date"));
                 d.setId_produit(rs.getInt("id_produit"));
              
                
            }
            conn.close();
            stm.close();
            return d;
        }
        catch(Exception e){
        return null;
        }
        }
           public static void getDeldonnee(Donnee cl){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from java_assureur.donnee where id_donnee='"+cl.getId_donnee()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
                public static void getupdate(int id_donnee,String produits_sortis,String produits_entres,String date,int id_produit){
        try{
            conn = getConnection();
            stm = conn.createStatement();
   String requete = "update java_assureur.donnee set produits_sortis='"+produits_sortis+"',produits_entres='"+produits_entres+"',date='"+date+"'where id_donnee='"+id_donnee+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
}
