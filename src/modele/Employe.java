
package modele;


public class Employe {
  private int id_employe;
private String nom,prenom,adresse;  

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId_employe() {
        return id_employe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Employe(int id_employe, String nom, String prenom, String adresse) {
        this.id_employe = id_employe;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    public Employe(){
    
    }
}
