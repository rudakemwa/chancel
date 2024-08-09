
package vue;
import controlleur.*;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;



public class FormDonnee extends JFrame implements ActionListener {
       JLabel liddonnee,lproduitssortis,lproduitsentres,ldate,lidproduit;
    JTextField tiddonnee,tproduitssortis,tproduitsentres,tdate,trech;
   // JComboBox listenationalite;
   // String[] nationalite = {"Burundaise","Rwandaise","Francaise","Allemande"};
    JComboBox listeidproduit;
    
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    
//     ArrayList<Client> listeClient = new ArrayList();
//    JTable tableclient;
//    private final DefaultTableModel model;
//    Client c = null;
    ArrayList<Produit> listeProduit = new ArrayList();
      ArrayList<Donnee> listeDonnee = new ArrayList();
    JTable tabledonnee;
    private final DefaultTableModel model;
    Donnee d = null;
    int index =0;
   // private LocalDate date;
    public FormDonnee(){
    liddonnee = new JLabel("IdDonnee");
    liddonnee.setBounds(10,30,100,30);
    this.getContentPane().add(liddonnee);
        
    tiddonnee = new JTextField();
    tiddonnee.setBounds(120,30,100,30);
    this.getContentPane().add(tiddonnee);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
        
   
    lproduitssortis = new JLabel("Produits sortis");
    lproduitssortis.setBounds(10,70,100,30);
    this.getContentPane().add(lproduitssortis);
        
    tproduitssortis = new JTextField();
    tproduitssortis.setBounds(120,70,100,30);
    this.getContentPane().add(tproduitssortis);
     lproduitsentres = new JLabel("Produits entres");
    lproduitsentres.setBounds(10,110,100,30);
    this.getContentPane().add(lproduitsentres);
        
    tproduitsentres = new JTextField();
    tproduitsentres.setBounds(120,110,100,30);
    this.getContentPane().add(tproduitsentres);
   ldate = new JLabel("Date");
    ldate.setBounds(10,150,100,30);
    this.getContentPane().add(ldate);
        
    tdate = new JTextField();
    tdate.setBounds(120,150,100,30);
    this.getContentPane().add(tdate);
    
    lidproduit=new JLabel("IdProduit");
    lidproduit.setBounds(10,190,100,30);
    this.getContentPane().add(lidproduit);
    
    listeidproduit= new JComboBox();
    listeProduit= FactoryProduit.getProduit();
    for(Produit p:listeProduit){
        listeidproduit.addItem(p.getId_produit());
       }
    listeidproduit.setBounds(120,190,100,30);
    listeidproduit.addItemListener(new ItemListener(){
    
    public void itemStateChanged(ItemEvent e){
        index = listeidproduit.getSelectedIndex();
    }
    }
    );
    this.getContentPane().add(listeidproduit);
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
    model.addColumn("IdDonnee");
    model.addColumn("Produits sortis");
    model.addColumn("Produits entres");
    model.addColumn("Date");
    model.addColumn("IdProduit");
   this.getContentPane().setLayout(null);
}
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            int id_donnee = Integer.valueOf(tiddonnee.getText());
            String produits_sortis = tproduitssortis.getText();
            String produits_entres= tproduitsentres.getText();
            //String mail= tmail.getText();
            String date= tdate.getText();
            // int id_produit = Integer.valueOf(tidproduit.getText());
             int id_produit = listeProduit.get(index).getId_produit(); 
           
           d = new Donnee(id_donnee,produits_sortis,produits_entres,date,id_produit);
           FactoryDonnee.setDonnee(d);
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
                        d= FactoryDonnee.getRechdonnee(rech);
                        if(d != null){
                            tiddonnee.setText(String.valueOf(d.getId_donnee()));
                            tproduitssortis.setText(d.getProduits_sortis());
                             tproduitsentres.setText(d.getProduits_entres());
//                           LocalDate datee;
//                              tdate.setText(d.setDate(date));
tdate.setText(d.getDate());

                              
                              //tadresse.setText(d.getAdresse());
                               listeidproduit.setSelectedItem((getproduct(d.getId_produit())).getId_produit());
                          
                        }
                    }
                 
      
        
                   else
                           if(e.getSource()==bdel){
                               if(d != null){
                                  String msg = "Souhaitez-vous supprimer "+d.getId_donnee()+d.getProduits_sortis();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                 if(rep==0){
                                        FactoryDonnee.getDeldonnee(d);
                                       afficher();
                                        initialiser();
//                  tiddonnee.setText("");
//                tproduitssortis.setText("");
//                 tproduitsentres.setText("");
//                 tdate.setText("");
//                 t.setText("");
                
                                 }
                                }
                           }
                           else if(e.getSource()==bupdate){
                           int id_donnee =Integer.valueOf(tiddonnee.getText());
                           String produits_sortis =tproduitssortis.getText();
                           String produits_entres =tproduitsentres.getText();
                           String date =tdate.getText();
                            int id_produit = listeProduit.get(index).getId_produit(); 
                           if(JOptionPane.showConfirmDialog(null,"Voulez vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                           controlleur.FactoryDonnee.getupdate(id_donnee,produits_sortis, produits_entres,date, id_produit);
                           afficher();
                           }
                           }
                       }
     public Produit getproduct(int id){
     Produit pro= null;
     for(Produit p:listeProduit){
     if(p.getId_produit()==id){
     pro= new Produit();
     pro=p;
     break;
     }
     }
     return pro;
     }

       public void afficher(){
        model.setRowCount(0);
        listeDonnee = FactoryDonnee.getDonnee();
        for(Donnee as : listeDonnee){
            model.addRow(new Object[]{
                as.getId_donnee(),as.getProduits_sortis(),as.getProduits_entres(),as.getDate(),as.getId_produit()});
       }
      tabledonnee = new JTable(model);
        JScrollPane p = new JScrollPane(tabledonnee);
       p.setBounds(60,320,350,100);
        this.getContentPane().add(p);
    
}
   public void initialiser(){
        tiddonnee.setText("");
        tproduitssortis.setText("");
        tproduitsentres.setText("");
        tdate.setText("");
         
         
    }
}
