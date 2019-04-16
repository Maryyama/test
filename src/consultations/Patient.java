/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultations;

import static consultations.Consulte.con;
import static consultations.Medecin.con;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cheikh THIOUB
 */
public class Patient extends JFrame implements ActionListener {
    static Connection con;
	  static Statement st;
	  static ResultSet rs;
          
          private int num_pat;
          private String all;
          
   JPanel panHaut,panInt, panBas;  
    JTextField Num_ss, nom;  
     JComboBox patient;
     JTable listeCons;
    public Patient ( ){
        
super ( );
this.setSize (new Dimension (300,200));
this.setResizable ( false ); //on ne pourra pas agrandir la fenetre
/*recuperation du ContentPane*/
Container contenu = this.getContentPane ();

/*creation des JPanel avec leur Layout Manager*/
panHaut = new JPanel(new GridLayout (6,2));
panInt = new JPanel(new GridLayout (1,1));
panBas = new JPanel (new GridLayout (4,2) );

/*ajout des pannneaux au ContentPane,l'un au nord, l'autre au sud*/
contenu.add (panHaut, BorderLayout.NORTH);
contenu.add (panInt);
contenu.add(panBas, BorderLayout.SOUTH);


Num_ss = new JTextField();
nom = new JTextField();

/*ajout de trois label et de trois zones de texte a panHaut*/
//panHaut.add( new JLabel ("Numéro SS")); panHaut.add (Num_ss);
panHaut.add( new JLabel("Prénom et Nom")); panHaut.add(nom);


JButton create_medecin;
create_medecin = new JButton("Ajouter");
panHaut.add (create_medecin);
create_medecin.addActionListener ((ActionListener) this);
    }
    
    public Patient(int num_pat){
     num_pat=this.num_pat;
     
     
     this.setSize (new Dimension (600,500));
this.setResizable ( false ); //on ne pourra pas agrandir la fenetre
/*recuperation du ContentPane*/
Container contenu = this.getContentPane ();

/*creation des JPanel avec leur Layout Manager*/
panHaut = new JPanel(new GridLayout (1,1));
panInt = new JPanel(new GridLayout (1,1));
panBas = new JPanel (new GridLayout (4,2) );

/*ajout des pannneaux au ContentPane,l'un au nord, l'autre au sud*/
contenu.add (panHaut, BorderLayout.NORTH);
contenu.add (panInt);
contenu.add(panBas, BorderLayout.SOUTH);

/*ajout d une bordure avec intiutlé a panHaut*/
panHaut.setBorder ( new TitledBorder("Informations patient"));
panBas.setBorder ( new TitledBorder("Consultations"));
panInt.setBorder ( new TitledBorder("Liste des consultations"));
/*ajout d une bordure epaisse a panBas*/
Border b = BorderFactory.createLineBorder (Color.gray .darker ( ) ,1) ;
panInt.setBorder (b);
contenu.setVisible(true);

patient=new JComboBox();
//listeCons=new JTable();


JButton create_medecin;
create_medecin = new JButton("Consulter dossier");

create_medecin.addActionListener ((ActionListener) this);

try {  /*chargement du driver*/
	            Class.forName("com.mysql.jdbc.Driver").newInstance ( )  ;
	           // System.out.println("driver charger");
	         }
	  catch (Exception mes){System.out .println("Erreur driver:  "+mes.getMessage ( ) ) ;}
	  // ou 3306
	try {con =DriverManager.getConnection ("jdbc:mysql://localhost/centre_medical","root","") ;
	       }
	  catch (Exception ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
	  try {  st = con.createStatement() ;
	        }
	  catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
          
          
          
          try {
              
          System.out.println(num_pat);       
ResultSet rs = st.executeQuery( "SELECT *from vue_consultation" );
        ResultSetTableModel rtm = new ResultSetTableModel( rs );
        
        TablePanel tablePanel = new TablePanel( rtm );
        
        listeCons = new JTable(); 
        listeCons.setBounds(30, 40, 200, 150); 
        JScrollPane sp = new JScrollPane(listeCons); 

/*ajout de trois label et de trois zones de texte a panHaut*/
//panHaut.add( new JLabel ("Numéro SS")); panHaut.add (Num_ss);
panHaut.add(tablePanel);
//panInt.add(tablePanel);
panBas.add (create_medecin);
             
                     
                     }     catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
 
     
    }
 
    public Patient(int num_pat,String all){
    this.num_pat=0;
     all=this.all;
     
     this.setSize (new Dimension (300,200));
this.setResizable ( false ); //on ne pourra pas agrandir la fenetre
/*recuperation du ContentPane*/
Container contenu = this.getContentPane ();

/*creation des JPanel avec leur Layout Manager*/
panHaut = new JPanel(new GridLayout (6,2));
panInt = new JPanel(new GridLayout (1,1));
panBas = new JPanel (new GridLayout (4,2) );

/*ajout des pannneaux au ContentPane,l'un au nord, l'autre au sud*/
contenu.add (panHaut, BorderLayout.NORTH);
contenu.add (panInt);
contenu.add(panBas, BorderLayout.SOUTH);


patient=new JComboBox();

String[] items = {"Selectionner"};
patient.addItem(items[0]);

/*ajout de trois label et de trois zones de texte a panHaut*/
//panHaut.add( new JLabel ("Numéro SS")); panHaut.add (Num_ss);
panHaut.add( new JLabel("Numéro patient")); panHaut.add(patient);


JButton create_medecin;
create_medecin = new JButton("Consulter dossier");
panHaut.add (create_medecin);
create_medecin.addActionListener ((ActionListener) this);

try {  /*chargement du driver*/
	            Class.forName("com.mysql.jdbc.Driver").newInstance ( )  ;
	           // System.out.println("driver charger");
	         }
	  catch (Exception mes){System.out .println("Erreur driver:  "+mes.getMessage ( ) ) ;}
	  // ou 3306
	try {con =DriverManager.getConnection ("jdbc:mysql://localhost/centre_medical","root","") ;
	       }
	  catch (Exception ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
	  try {  st = con.createStatement() ;
	        }
	  catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
          
          
          
          try {
          rs = st.executeQuery("select * from patient") ;
	         int col= rs.getMetaData().getColumnCount();
                rs.getMetaData();
	        int ligne=rs.getRow();
	             while( rs.next()) { // tant qu'il y a des enregistrements, on se positionne sur le prochain
 
 
             patient.addItem(rs.getString("num_ss")); // là, on va chercher la valeur du champ qui s'appelle désignation dans l'enregistrement actuellement positionné
                     }
             
                     
                     }     catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
   
    
    
    }


  @Override
    public void actionPerformed(ActionEvent e) {
         try {  /*chargement du driver*/
	            Class.forName("com.mysql.jdbc.Driver").newInstance ( )  ;
	           // System.out.println("driver charger");
	         }
	  catch (Exception mes){System.out .println("Erreur driver:  "+mes.getMessage ( ) ) ;}
	  // ou 3306
	try {con =DriverManager.getConnection ("jdbc:mysql://localhost/compte_test","root","") ;
	       }
	  catch (Exception ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
	  try {  st = con.createStatement() ;
	        }
	  catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
        
    String etiquette = e.getActionCommand ( );
    
    if ( etiquette.equals ("Ajouter" ) )
{
    
//String matricule= Matricule.getText ( ) ;

String Nom=nom.getText ( );

     if(nom.getText ( ).equals(""))
          JOptionPane.showMessageDialog(this,"Vous devez renseigner tous les champs");

  else
     {
        

	
                 try {  /*chargement du driver*/
	            Class.forName("com.mysql.jdbc.Driver").newInstance ( )  ;
	           // System.out.println("driver charger");
	         }
	  catch (Exception mes){System.out .println("Erreur driver:  "+mes.getMessage ( ) ) ;}
	  // ou 3306
	try {con =DriverManager.getConnection ("jdbc:mysql://localhost/centre_medical","root","") ;
	       }
	  catch (Exception ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
	  try {  st = con.createStatement() ;
	        }
	  catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
	  try {
              
              
                String sql="INSERT INTO patient (nom) VALUES ('"+Nom+"')";
                st.executeUpdate(sql);
                
                 JOptionPane.showMessageDialog(this,"Le patient "+Nom+" a été bien ajouté");
                // Matricule.setText("") ;
                 nom.setText("") ;
         
     }     catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
          
     }
         
                
}
    
     else if(etiquette.equals ("Consulter dossier" ) ){
     Patient fen = new Patient(4);
     fen.setVisible(true);     
    }
    
    }
    
    
}
