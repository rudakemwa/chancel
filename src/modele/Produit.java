
package modele;


public class Produit {
    private int id_produit,quantite;
    private String nom_produit;

    public Produit(int idproduit, String nom, int quantite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public Produit(int id_produit, int quantite, String nom_produit) {
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.nom_produit = nom_produit;
    }
    public Produit(){
    
    }
    
}
