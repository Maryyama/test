/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultations;


import static consultations.Medicament.con;
import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cheikh THIOUB
 */
public class Consulte extends JFrame implements ActionListener {
    
     static Connection con;
	  static Statement st;
	  static ResultSet rs;
    
    JPanel panHaut,panInt, panBas;  
   
    JComboBox medecin,patient,medicament;
    JTextField date,nombre_jour;
   
    
     public Consulte ( ){
        
super ( );
this.setSize (new Dimension (300,400));
this.setResizable ( false ); //on ne pourra pas agrandir la fenetre
/*recuperation du ContentPane*/
Container contenu = this.getContentPane ();

/*creation des JPanel avec leur Layout Manager*/
panHaut = new JPanel(new GridLayout (5,2));
panInt = new JPanel(new GridLayout (1,2));
panBas = new JPanel (new GridLayout (4,2) );

/*ajout des pannneaux au ContentPane,l'un au nord, l'autre au sud*/
contenu.add (panHaut, BorderLayout.NORTH);
//contenu.add (panInt);
contenu.add(panBas, BorderLayout.SOUTH);


panHaut.setBorder ( new TitledBorder("Nouvelle consultation"));
panBas.setBorder ( new TitledBorder("Médicament prescrit"));


medecin=new JComboBox();
patient=new JComboBox();
medicament=new JComboBox();
date = new JTextField();
nombre_jour = new JTextField();
JTextArea hist= new JTextArea();

/*ajout de trois label et de trois zones de texte a panHaut*/
String[] items = {"Selectionner"};
patient.addItem(items[0]);
medecin.addItem(items[0]);
medicament.addItem(items[0]);



panHaut.add( new JLabel("Nom du Medecin")); panHaut.add(medecin);
panHaut.add( new JLabel("Nom du patient")); panHaut.add(patient);
panHaut.add( new JLabel("Date de consultation")); panHaut.add(date);

JButton create_medecin;
create_medecin = new JButton("Ajouter");
panHaut.add( new JLabel("Nouvelle consultation")); panHaut.add (create_medecin);
create_medecin.addActionListener ((ActionListener) this);

panBas.add( new JLabel("code du médicament")); panBas.add(medicament);
panBas.add( new JLabel("Nombre de jour")); panBas.add(nombre_jour);


JButton create_medicament;
create_medicament = new JButton("Ajouter médicament");
panBas.add (create_medicament);
create_medicament.addActionListener ((ActionListener) this);


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
          rs = st.executeQuery("select * from medecin") ;
	         int col= rs.getMetaData().getColumnCount();
                rs.getMetaData();
	        int ligne=rs.getRow();
	             while( rs.next()) { // tant qu'il y a des enregistrements, on se positionne sur le prochain
 
 
             medecin.addItem(rs.getString("matricule")); // là, on va chercher la valeur du champ qui s'appelle désignation dans l'enregistrement actuellement positionné
                     }
                     
                     
            rs = st.executeQuery("select * from patient") ;
	             while( rs.next()) { // tant qu'il y a des enregistrements, on se positionne sur le prochain
                     patient.addItem(rs.getString("num_ss")); // là, on va chercher la valeur du champ qui s'appelle désignation dans l'enregistrement actuellement positionné
                     }
                     
                                 
            rs = st.executeQuery("select * from medicament") ;
	             while( rs.next()) { // tant qu'il y a des enregistrements, on se positionne sur le prochain
                     medicament.addItem(rs.getString("code")); // là, on va chercher la valeur du champ qui s'appelle désignation dans l'enregistrement actuellement positionné
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
   
    //String matricule= Matricule.getText ( ) ;
String Medecin=medecin.getSelectedItem().toString();
String Patient=patient.getSelectedItem().toString();
String Date=date.getText ( );
String Nombre_jour=nombre_jour.getText ( );
String Medicament=medicament.getSelectedItem().toString();

    if ( etiquette.equals ("Ajouter" ) )
{
    



 if(medecin.getSelectedItem().toString().equals("Selectionner"))
          JOptionPane.showMessageDialog(this,"Vous devez selectionner un medecin");
 else if(medecin.getSelectedItem().toString().equals("Selectionner"))
JOptionPane.showMessageDialog(this,"Vous devez selectionner un patient");
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
              
              
String sql="INSERT INTO consulte (medecin_matricule,patient_num_ss) VALUES ('"+Medecin+"','"+Patient+"')";
                st.executeUpdate(sql);
                
                String sql2="INSERT INTO consultation (medecin_has_patient_medecin_matricule,medecin_has_patient_patient_num_ss,date) VALUES ('"+Medecin+"','"+Patient+"','"+Date+"')";
                st.executeUpdate(sql2);
                
                 JOptionPane.showMessageDialog(this,"La consultation a bien été ajouté");
               
         
     }     catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
          
     }
         
                
}
    
    
   if ( etiquette.equals ("Ajouter médicament" ) ) {
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
              
 int Nombre_jours=Integer.parseInt(Nombre_jour);             
String sql="insert into prescrit (select code,numero,"+Nombre_jours+" from medicament,consultation where date='"+Date+"' and code='"+Medicament+"' and medecin_has_patient_medecin_matricule='"+Medecin+"' and medecin_has_patient_patient_num_ss='"+Patient+"')";
st.executeUpdate(sql);
                
                
JOptionPane.showMessageDialog(this,"Le médicament a bien été ajouté pour la consultation");
               
         
     }     catch (SQLException t){System.out.println ("Erreur de Statement"+t.getMessage());}
          
          
   } 
    
    }
    
}
