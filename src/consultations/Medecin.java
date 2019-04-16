/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultations;

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
//import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Cheikh THIOUB
 */
public class Medecin extends JFrame implements ActionListener{
    
    static Connection con;
	  static Statement st;
	  static ResultSet rs;
    
    JPanel panHaut,panInt, panBas;  
    JTextField Matricule, nom;
    
    public Medecin ( ){
        
super ( );
this.setSize (new Dimension (300,250));
//this.setResizable ( false ); //on ne pourra pas agrandir la fenetre
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


//Matricule = new JTextField();
nom = new JTextField();

/*ajout de trois label et de trois zones de texte a panHaut*/
//panHaut.add( new JLabel ("Prénom")); panHaut.add (Matricule);
panHaut.add( new JLabel("Prénom & nom")); panHaut.add(nom);

Border b = BorderFactory.createLineBorder (Color.gray .darker ( ) ,4) ;
panHaut.setBorder (b);

JButton create_medecin;
create_medecin = new JButton("Ajouter Médecin");
create_medecin.setPreferredSize(new Dimension(40, 40));
panHaut.add (create_medecin);
create_medecin.addActionListener ((ActionListener) this);
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
              
              
                String sql="INSERT INTO medecin (nom) VALUES ('"+Nom+"')";
                st.executeUpdate(sql);
                
                 JOptionPane.showMessageDialog(this,"Le medecin "+Nom+" a été bien ajouté");
                // Matricule.setText("") ;
                 nom.setText("") ;
         
     }     catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
          
     }
         
                
}
    
    }
    
}
