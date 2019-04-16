/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultations;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

class Formulair extends JFrame{
    
    
    
	
    JPanel panHaut,panInt, panBas; 
	JMenuBar br=new JMenuBar();
          JTextField Matricule, nom;
	
	JMenu A=new JMenu("Accueil");
	JMenu C=new JMenu("Consultation");
        JMenu L=new JMenu("Patients");
        JMenu H=new JMenu("Historique");
	
	JMenuItem AJM=new JMenuItem("Ajouter Medecin");
	JMenuItem AJPAT=new JMenuItem("Ajouter Patient");
        JMenuItem AJME=new JMenuItem("Ajouter un médicament");
	JMenuItem Quitter=new JMenuItem("Quitter");
	
	
	JMenuItem NEWCONS=new JMenuItem("Nouvelle consultation");
	JMenuItem HISTCONS=new JMenuItem("Historique");
        
        JMenuItem LISTPAT=new JMenuItem("Liste des patients");
        
        JMenuItem DETAILCONS=new JMenuItem("Détails d'une consultation");
	
	 Formulair()
	{
            
             
  
  
		this.setTitle("Menu Principale");
		this.setSize(new Dimension(400,400));
                Container contenu = this.getContentPane ();
  
                
panHaut = new JPanel(new GridLayout (6,2));
panInt = new JPanel(new GridLayout (1,1));
panBas = new JPanel (new GridLayout (4,2) );
/*ajout des pannneaux au ContentPane,l'un au nord, l'autre au sud*/
//contenu.add (panHaut, BorderLayout.NORTH);
//contenu.add (panInt);
//contenu.add(panBas, BorderLayout.SOUTH);


 JTextArea hist;

hist= new JTextArea();

panInt.add (hist);

Border b = BorderFactory.createLineBorder (Color.gray .darker ( ) ,1) ;
panInt.setBorder (b);


		A.add(AJM);
		A.add(AJPAT);
                A.add(AJME);
		A.addSeparator();
		A.add(Quitter);
		
		C.add(NEWCONS);
		C.add(HISTCONS);
                
                L.add(LISTPAT);
                H.add(DETAILCONS);
                
		
		
		br.add(A);
		br.add(C);
                br.add(L);
                br.add(H);
		
		this.setJMenuBar(br);
		
		Ecouteur ec=new Ecouteur();
		
               AJM.addActionListener(ec);
	       AJPAT.addActionListener (ec);
               AJME.addActionListener (ec);
               Quitter.addActionListener(ec);
               NEWCONS.addActionListener(ec);
               HISTCONS.addActionListener(ec);
               LISTPAT.addActionListener(ec);
               DETAILCONS.addActionListener(ec);


		
		
	}
	
	
	
}

class Ecouteur implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
	String etiquette = e.getActionCommand ( );
        if(etiquette=="Quitter")
	System.exit(0);
     else if(etiquette=="Ajouter Medecin"){
         
Medecin fen = new Medecin();
fen.setVisible(true);
          
      }
               
else if(etiquette=="Ajouter Patient"){
         
Patient fen = new Patient();
fen.setVisible(true);
          
      }
        
        else if(etiquette=="Ajouter un médicament"){
         
Medicament fen = new Medicament();
fen.setVisible(true);
        
      }
        
         else if(etiquette=="Nouvelle consultation"){
         
Consulte fen = new Consulte();
fen.setVisible(true);    
      }
        
         else if(etiquette=="Liste des patients"){
         
Patient fen = new Patient(0,"*");
fen.setVisible(true);    
      }
        
        
        else if(etiquette=="Historique"){
         
Consultation fen = new Consultation(1);
fen.setVisible(true);    
      }
    
          
      }
         
	}

