
package modele;


public class Assureur {
    private int id_assureur;
    private String nom,mail,adresse;

    public void setId_assureur(int id_assureur) {
        this.id_assureur = id_assureur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId_assureur() {
        return id_assureur;
    }

    public String getNom() {
        return nom;
    }

   

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public Assureur(int id_assureur, String nom, String mail, String adresse) {
        this.id_assureur = id_assureur;
        this.nom = nom;
       // this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
    }
    public Assureur(){
    
    }
}
