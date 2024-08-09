
package modele;


public class Utilisateur {
 private int id_user;
 private String nom,password,statut,etat;

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getStatut() {
        return statut;
    }

    public String getEtat() {
        return etat;
    }

    public Utilisateur(int id_user, String nom, String password, String statut, String etat) {
        this.id_user = id_user;
        this.nom = nom;
        this.password = password;
        this.statut = statut;
        this.etat = etat;
    }
    public Utilisateur(){
    
    }
}
