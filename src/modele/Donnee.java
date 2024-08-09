
package modele;
public class Donnee {
    private int id_donnee,id_produit;
    private String produits_sortis,produits_entres,date;
  

//    public Donnee(int id_donnee, String produits_sortis, String produits_entres, String date, String id_produit) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public Donnee(int id_donnee, String produits_sortis, String produits_entres, String date, int id_produit) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void setId_donnee(int id_donnee) {
        this.id_donnee = id_donnee;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setProduits_sortis(String produits_sortis) {
        this.produits_sortis = produits_sortis;
    }

    public void setProduits_entres(String produits_entres) {
        this.produits_entres = produits_entres;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_donnee() {
        return id_donnee;
    }

    public int getId_produit() {
        return id_produit;
    }

    public String getProduits_sortis() {
        return produits_sortis;
    }

    public String getProduits_entres() {
        return produits_entres;
    }

    public String getDate() {
        return date;
    }

    public Donnee(int id_donnee,String produits_sortis, String produits_entres, String date,int id_produit) {
        this.id_donnee = id_donnee;
        this.id_produit = id_produit;
        this.produits_sortis = produits_sortis;
        this.produits_entres = produits_entres;
        this.date = date;
    }
    public Donnee(){
    
    }

//    public void setProduit(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public int getProduit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
