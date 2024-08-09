
package vue;
import controlleur.*;

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

public class FormProduit extends JFrame implements ActionListener {
      JLabel lidproduit,lnom,lquantite;
    JTextField tidproduit,tnom,tquantite,trech;
  
   // JComboBox listenationalite;
   // String[] nationalite = {"Burundaise","Rwandaise","Francaise","Allemande"};
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    
//     ArrayList<Client> listeClient = new ArrayList();
//    JTable tableclient;
//    private final DefaultTableModel model;
//    Client c = null;
    ArrayList<Produit> listeProduit = new ArrayList();
    JTable tableproduit;
    private final DefaultTableModel model;
    Produit p = null;
    
    public FormProduit(){
    lidproduit = new JLabel("IdProduit");
    lidproduit.setBounds(10,30,100,30);
    this.getContentPane().add(lidproduit);
        
    tidproduit = new JTextField();
    tidproduit.setBounds(120,30,100,30);
    this.getContentPane().add(tidproduit);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
        
   
    lnom = new JLabel("Nom");
    lnom.setBounds(10,70,100,30);
    this.getContentPane().add(lnom);
        
    tnom = new JTextField();
    tnom.setBounds(120,70,100,30);
    this.getContentPane().add(tnom);
     lquantite = new JLabel("Quantite");
    lquantite.setBounds(10,110,100,30);
    this.getContentPane().add(lquantite);
        
    tquantite = new JTextField();
    tquantite.setBounds(120,110,100,30);
    this.getContentPane().add(tquantite);
  
    
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,180,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,180,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,180,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,180,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Mettre a jour");
    bupdate.setBounds(450,180,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Supprimer");
    bdel.setBounds(560,180,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("IdProduit");
    model.addColumn("Nom");
    model.addColumn("Quantite");
   
   this.getContentPane().setLayout(null);
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            int idproduit = Integer.valueOf(tidproduit.getText());
            String nom = tnom.getText();
            int quantite= Integer.valueOf(tquantite.getText());
            
           
           p = new Produit(idproduit,nom,quantite);
           
           FactoryProduit.setProduit(p);
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
                        p= FactoryProduit.getRechproduit(rech);
                        if(p != null){
                            tidproduit.setText(String.valueOf(p.getId_produit()));
                            tnom.setText(p.getNom_produit());
                             tquantite.setText(String.valueOf(p.getQuantite()));
                           
                        }
                    }
                 
      
        
                   else
                           if(e.getSource()==bdel){
                               if(p != null){
                                  String msg = "Souhaitez-vous supprimer "+p.getId_produit()+p.getNom_produit();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                 if(rep==0){
                                        FactoryProduit.getDelproduit(p);
                                       afficher();
                                        initialiser();
                  tidproduit.setText("");
                tnom.setText("");
                 tquantite.setText("");
             }
                    }
                           }
                           else if(e.getSource()==bupdate){
                           int id_produit =Integer.valueOf(tidproduit.getText());
                           String nom_produit =tnom.getText();
                           int quantite =Integer.valueOf(tquantite.getText());
                          
                         
                           if(JOptionPane.showConfirmDialog(null,"Voulez vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                           controlleur.FactoryProduit.getupdate(id_produit,nom_produit,quantite);
                           afficher();
                           }
                           }
                       }
       public void afficher(){
        model.setRowCount(0);
        listeProduit = FactoryProduit.getProduit();
        for(Produit pro : listeProduit){
            model.addRow(new Object[]{
                pro.getId_produit(),pro.getNom_produit(),pro.getQuantite()});
       }
      tableproduit = new JTable(model);
        JScrollPane p = new JScrollPane(tableproduit);
       p.setBounds(60,320,350,100);
        this.getContentPane().add(p);
    
}
   public void initialiser(){
        tidproduit.setText("");
        tnom.setText("");
        tquantite.setText("");
    
         
    }
}
