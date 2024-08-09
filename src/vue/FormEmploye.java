
package vue;
import controlleur.*;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class FormEmploye extends JFrame implements ActionListener {
     JLabel lidemploye,lnom,lprenom,ladresse;
    JTextField tidemploye,tnom,tprenom,tadresse,trech;
   // JComboBox listenationalite;
   // String[] nationalite = {"Burundaise","Rwandaise","Francaise","Allemande"};
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    
//     ArrayList<Client> listeClient = new ArrayList();
//    JTable tableclient;
//    private final DefaultTableModel model;
//    Client c = null;
    ArrayList<Employe> listeEmploye = new ArrayList();
    JTable tableemploye;
    private final DefaultTableModel model;
    Employe em = null;
    
    public FormEmploye(){
    lidemploye = new JLabel("IdEmploye");
    lidemploye.setBounds(10,30,100,30);
    this.getContentPane().add(lidemploye);
        
    tidemploye = new JTextField();
    tidemploye.setBounds(120,30,100,30);
    this.getContentPane().add(tidemploye);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
        
   
    lnom = new JLabel("Nom");
    lnom.setBounds(10,70,100,30);
    this.getContentPane().add(lnom);
        
    tnom = new JTextField();
    tnom.setBounds(120,70,100,30);
    this.getContentPane().add(tnom);
     lprenom = new JLabel("Prenom");
    lprenom.setBounds(10,110,100,30);
    this.getContentPane().add(lprenom);
        
    tprenom = new JTextField();
    tprenom.setBounds(120,110,100,30);
    this.getContentPane().add(tprenom);
   ladresse = new JLabel("Adresse");
    ladresse.setBounds(10,150,100,30);
    this.getContentPane().add(ladresse);
        
    tadresse = new JTextField();
    tadresse.setBounds(120,150,100,30);
    this.getContentPane().add(tadresse);
    
    
    
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
    model.addColumn("Idemploye");
    model.addColumn("Nom");
    model.addColumn("Prenom");
    model.addColumn("Adresse");
   this.getContentPane().setLayout(null);
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            int idemploye = Integer.valueOf(tidemploye.getText());
            String nom = tnom.getText();
            String prenom= tprenom.getText();
             String adresse = tadresse.getText();
            
           
           em = new Employe(idemploye,nom,prenom,adresse);
           FactoryEmploye.setEmploye(em);
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
                        em= FactoryEmploye.getRechemploye(rech);
                        if(em != null){
                            tidemploye.setText(String.valueOf(em.getId_employe()));
                            tnom.setText(em.getNom());
                             tprenom.setText(em.getPrenom());
                            tadresse.setText(em.getAdresse());
                          
                        }
                    }
                 
      
        
                   else
                           if(e.getSource()==bdel){
                               if(em != null){
                                  String msg = "Souhaitez-vous supprimer "+em.getId_employe()+em.getNom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                 if(rep==0){
                                        FactoryEmploye.getDelemploye(em);
                                       afficher();
                                        initialiser();
                  tidemploye.setText("");
                tnom.setText("");
                 tprenom.setText("");
                tadresse.setText("");
                
                                 }
                                }
                           }
                           else if(e.getSource()==bupdate){
                           int id_employe =Integer.valueOf(tidemploye.getText());
                           String nom =tnom.getText();
                           String prenom =tprenom.getText();
                          
                           String adresse= tadresse.getText();
                           if(JOptionPane.showConfirmDialog(null,"Voulez vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                           controlleur.FactoryEmploye.getupdate(id_employe,nom,prenom,adresse);
                           afficher();
                           }
                           }
                       }
       public void afficher(){
        model.setRowCount(0);
        listeEmploye = FactoryEmploye.getEmploye();
        for(Employe emp : listeEmploye){
            model.addRow(new Object[]{
                emp.getId_employe(),emp.getNom(),emp.getPrenom(),emp.getAdresse()});
       }
      tableemploye = new JTable(model);
        JScrollPane p = new JScrollPane(tableemploye);
       p.setBounds(60,320,350,100);
        this.getContentPane().add(p);
    
}
   public void initialiser(){
        tidemploye.setText("");
        tnom.setText("");
        tprenom.setText("");
      tadresse.setText("");
         
    }
}
