
package vue;

import controlleur.FactoryUtilisateur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modele.*;


public class FormUtilisateur extends JFrame implements ActionListener {
  


     JLabel liduser,lnom,lpassword,lstatut,letat;
    JTextField tiduser,tnom,tpassword,tstatut,tetat,trech;
    JComboBox listeetat;
    String[] etat={"active","desactive"};
    
   // JComboBox listenationalite;
   // String[] nationalite = {"Burundaise","Rwandaise","Francaise","Allemande"};
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    
//     ArrayList<Client> listeClient = new ArrayList();
//    JTable tableclient;
//    private final DefaultTableModel model;
//    Client c = null;
    ArrayList<Utilisateur> listeUtilisateur = new ArrayList();
    JTable tableutilisateur;
    private final DefaultTableModel model;
    Utilisateur u = null;
    
    public FormUtilisateur(){
    liduser = new JLabel("IdUser");
    liduser.setBounds(10,30,100,30);
    this.getContentPane().add(liduser);
        
    tiduser = new JTextField();
    tiduser.setBounds(120,30,100,30);
    this.getContentPane().add(tiduser);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
        
   
    lnom = new JLabel("Nom");
    lnom.setBounds(10,70,100,30);
    this.getContentPane().add(lnom);
        
    tnom = new JTextField();
    tnom.setBounds(120,70,100,30);
    this.getContentPane().add(tnom);
     lpassword = new JLabel("Password");
    lpassword.setBounds(10,110,100,30);
    this.getContentPane().add(lpassword);
        
    tpassword = new JTextField();
    tpassword.setBounds(120,110,100,30);
    this.getContentPane().add(tpassword);
   lstatut = new JLabel("Statut");
    lstatut.setBounds(10,150,100,30);
    this.getContentPane().add(lstatut);
        
    tstatut = new JTextField();
    tstatut.setBounds(120,150,100,30);
    this.getContentPane().add(tstatut);
     letat = new JLabel("Etat");
    letat.setBounds(10,200,100,30);
    this.getContentPane().add(letat);
        
    listeetat = new JComboBox(etat);
    listeetat.setBounds(120,200,100,30);
    listeetat.addActionListener(this);
    this.getContentPane().add(listeetat);
    
    
    
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,270,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,270,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,270,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,270,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Mettre a jour");
    bupdate.setBounds(450,270,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Supprimer");
    bdel.setBounds(560,270,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("Iduser");
    model.addColumn("Nom");
    model.addColumn("Password");
    model.addColumn("Statut");
    model.addColumn("Etat");
    
   this.getContentPane().setLayout(null);
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            int iduser = Integer.valueOf(tiduser.getText());
            String nom = tnom.getText();
            String password= tpassword.getText();
             String statut = tstatut.getText();
             String etat = listeetat.getSelectedItem().toString();
            
           
           u = new Utilisateur(iduser,nom,password,statut,etat);
           FactoryUtilisateur.setUtilisateur(u);
        }
      else
         if(e.getSource()==bvisua){
             afficher();
            
        }
        
          
        else if(e.getSource()==binitia){
               
                    initialiser();
              
                }
      
          //Bouton rechercher
               
          else
                   
                    if(e.getSource()==brech){
                       int rech = Integer.valueOf(trech.getText());
                        u= FactoryUtilisateur.getRechutilisateur(rech);
                        if(u != null){
                            tiduser.setText(String.valueOf(u.getId_user()));
                            tnom.setText(u.getNom());
                             tpassword.setText(u.getPassword());
                            tstatut.setText(u.getStatut());
                            listeetat.setSelectedItem(u.getEtat());
                          
                        }
                    }
                 
      
        
                   else
                           if(e.getSource()==bdel){
                               if(u != null){
                                  String msg = "Souhaitez-vous supprimer "+u.getId_user()+u.getNom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                 if(rep==0){
                                        FactoryUtilisateur.getDelutilisateur(u);
                                       afficher();
                                        initialiser();
                  tiduser.setText("");
                tnom.setText("");
                 tpassword.setText("");
                tstatut.setText("");
                tetat.setText("");
                
                
                                 }
                                }
                           }
                           else if(e.getSource()==bupdate){
                           int id_user =Integer.valueOf(tiduser.getText());
                           String nom =tnom.getText();
                           String password =tpassword.getText();
                          
                           String statut= tstatut.getText();
                          // listeetat.setSelectedItem(u.getEtat());
                           if(JOptionPane.showConfirmDialog(null,"Voulez vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                           controlleur.FactoryUtilisateur.getupdate(id_user,nom,password,statut,etat);
                           afficher();
                           }
                           }
                       }
       public void afficher(){
        model.setRowCount(0);
        listeUtilisateur = FactoryUtilisateur.getUtilisateur();
        for(Utilisateur ut : listeUtilisateur){
            model.addRow(new Object[]{
                ut.getId_user(),ut.getNom(),ut.getPassword(),ut.getStatut(),ut.getEtat()});
       }
      tableutilisateur = new JTable(model);
        JScrollPane p = new JScrollPane(tableutilisateur);
       p.setBounds(60,320,350,100);
        this.getContentPane().add(p);
    
}
   public void initialiser(){
        tiduser.setText("");
        tnom.setText("");
        tpassword.setText("");
      tstatut.setText("");
         
    }
}


