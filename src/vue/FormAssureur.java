
package vue;

import controlleur.*;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
public class FormAssureur extends JFrame implements ActionListener{
    
 JLabel lidassureur,lnom,lprenom,lmail,ladresse;
    JTextField tidassureur,tnom,tprenom,tmail,tadresse,trech;
   // JComboBox listenationalite;
   // String[] nationalite = {"Burundaise","Rwandaise","Francaise","Allemande"};
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    
//     ArrayList<Client> listeClient = new ArrayList();
//    JTable tableclient;
//    private final DefaultTableModel model;
//    Client c = null;
    ArrayList<Assureur> listeAssureur = new ArrayList();
    JTable tableassureur;
    private final DefaultTableModel model;
    Assureur a = null;
    
    public FormAssureur(){
    lidassureur = new JLabel("IdAssureur");
    lidassureur.setBounds(10,30,100,30);
    this.getContentPane().add(lidassureur);
        
    tidassureur = new JTextField();
    tidassureur.setBounds(120,30,100,30);
    this.getContentPane().add(tidassureur);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
        
   
    lnom = new JLabel("Nom");
    lnom.setBounds(10,70,100,30);
    this.getContentPane().add(lnom);
        
    tnom = new JTextField();
    tnom.setBounds(120,70,100,30);
    this.getContentPane().add(tnom);
//     lprenom = new JLabel("Prenom");
//    lprenom.setBounds(10,110,100,30);
//    this.getContentPane().add(lprenom);
//        
//    tprenom = new JTextField();
//    tprenom.setBounds(120,110,100,30);
//    this.getContentPane().add(tprenom);
    
    lmail = new JLabel("Mail");
    lmail.setBounds(10,110,100,30);
    this.getContentPane().add(lmail);
        
    tmail = new JTextField();
    tmail.setBounds(120,110,100,30);
    this.getContentPane().add(tmail);
    
    
     ladresse = new JLabel("Adresse");
    ladresse.setBounds(10,150,100,30);
    this.getContentPane().add(ladresse);
        
    tadresse = new JTextField();
    tadresse.setBounds(120,150,100,30);
    this.getContentPane().add(tadresse);
    
    
    
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,240,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,240,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,240,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,240,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Mettre a jour");
    bupdate.setBounds(450,240,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Supprimer");
    bdel.setBounds(560,240,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("Idassureur");
    model.addColumn("Nom");
   // model.addColumn("Prenom");
    model.addColumn("Mail");
    model.addColumn("Adresse");
    
    
    this.getContentPane().setLayout(null);
    }
      public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            int idassureur = Integer.valueOf(tidassureur.getText());
            String nom = tnom.getText();
           // String prenom= tprenom.getText();
            String mail= tmail.getText();
            String adresse = tadresse.getText();
            
           
           a = new Assureur(idassureur,nom,mail,adresse);
           FactoryAssureur.setAssureur(a);
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
                        a= FactoryAssureur.getRechassureur(rech);
                        if(a != null){
                            tidassureur.setText(String.valueOf(a.getId_assureur()));
                            tnom.setText(a.getNom());
                             //tprenom.setText(a.getPrenom());
                              tmail.setText(a.getMail());
                              tadresse.setText(a.getAdresse());
                          
                        }
                    }
                 
      
        
                   else
                           if(e.getSource()==bdel){
                               if(a != null){
                                  String msg = "Souhaitez-vous supprimer "+a.getId_assureur()+a.getNom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                 if(rep==0){
                                        FactoryAssureur.getDelassureur(a);
                                       afficher();
                                        initialiser();
                  tidassureur.setText("");
                tnom.setText("");
                // tprenom.setText("");
                 tmail.setText("");
                 tadresse.setText("");
                
                                 }
                                }
                           }
                           else if(e.getSource()==bupdate){
                           int id_assureur =Integer.valueOf(tidassureur.getText());
                           String nom =tnom.getText();
                           //String prenom =tprenom.getText();
                           String mail =tmail.getText();
                           String adresse= tadresse.getText();
                           if(JOptionPane.showConfirmDialog(null,"Voulez vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                           controlleur.FactoryAssureur.getupdate(id_assureur, nom,mail, adresse);
                           afficher();
                           }
                           }
                       }
       public void afficher(){
        model.setRowCount(0);
        listeAssureur = FactoryAssureur.getAssureur();
        for(Assureur as : listeAssureur){
            model.addRow(new Object[]{
                as.getId_assureur(),as.getNom(),as.getMail(),as.getAdresse()});
       }
      tableassureur = new JTable(model);
        JScrollPane p = new JScrollPane(tableassureur);
       p.setBounds(60,320,350,100);
        this.getContentPane().add(p);
    
}
   public void initialiser(){
        tidassureur.setText("");
        tnom.setText("");
        //tprenom.setText("");
        tmail.setText("");
         tadresse.setText("");
         
    }
}





