
package vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FormPrincipale extends JFrame implements ActionListener {
     JMenuBar bar; 
    JMenu mdonne,mtrait,mfich; 
    JMenuItem iassureur,iemploye,iutilisateur,iproduit,idonnee,iquit;
    
    public FormPrincipale(){
        bar = new JMenuBar(); 
        mfich = new JMenu("Fichier"); 
        mdonne = new JMenu("Donnees de base"); 
        mtrait = new JMenu("Traitement");
        iassureur = new JMenuItem("Assureur"); 
        iassureur.addActionListener(this);
        iemploye = new JMenuItem("Employe");
        iemploye.addActionListener(this);
        
          iutilisateur = new JMenuItem("Utilisateur");
        iutilisateur.addActionListener(this);
          iproduit = new JMenuItem("Produit");
        iproduit.addActionListener(this);
        
          idonnee = new JMenuItem("Donnee");
        idonnee.addActionListener(this);
        
        
        iquit = new JMenuItem("Quitter");
        mfich.add(iquit); 
        mdonne.add(iassureur); 
        mdonne.add(iemploye);
        mdonne.add(iutilisateur);
        mdonne.add(iproduit);
        mdonne.add(idonnee);
        
        bar.add(mdonne); 
        bar.add(mtrait); 
        bar.add(mfich);
        bar.setBounds(10,10,500,30);
        this.getContentPane().add(bar);
        
        this.setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==iassureur){
        FormAssureur  a = new FormAssureur();
        a.setSize(800,800);
        a.setTitle("Gestion des assureurs");
        a.setVisible(true);  
        }
        else{
            if(e.getSource()==iemploye){
                FormEmploye  t = new FormEmploye();
                t.setSize(800,800);
                t.setTitle("Gestion des employes ");
                t.setVisible(true);
            }
            else if(e.getSource()==iutilisateur){
                FormUtilisateur  m = new FormUtilisateur();
                m.setSize(800,800);
                m.setTitle("Gestion des utilisateurs ");
                m.setVisible(true);
            }
            else if(e.getSource()==iproduit){
                 FormProduit  r = new FormProduit();
                r.setSize(800,800);
               r.setTitle("Gestion des produits ");
              r.setVisible(true);
           
            }
            else if(e.getSource()==idonnee){
                 FormDonnee  d = new FormDonnee();
                d.setSize(800,800);
               d.setTitle("Gestion des donnees ");
              d.setVisible(true);
           
    }
    }
}
}
