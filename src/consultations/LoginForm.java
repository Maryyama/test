/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultations;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Cheikh THIOUB
 */
public class LoginForm extends JFrame implements ActionListener{
    
    JLabel l1, l2, l3;
 JTextField tf1;
 JButton btn1;
 JPasswordField p1;
  JFrame frame = new JFrame("Page d'authentification");
 LoginForm() {
 
  l1 = new JLabel("Veuillez entrer votre login et un mot de passe");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 20));
 
  l2 = new JLabel("Login");
  l3 = new JLabel("Mot de passe");
  tf1 = new JTextField();
  p1 = new JPasswordField();
  btn1 = new JButton("Login");
 
  l1.setBounds(100, 30, 400, 30);
  l2.setBounds(80, 70, 200, 30);
  l3.setBounds(80, 110, 200, 30);
  tf1.setBounds(300, 70, 200, 30);
  p1.setBounds(300, 110, 200, 30);
  btn1.setBounds(150, 160, 100, 30);
 
  frame.add(l1);
  frame.add(l2);
  frame.add(tf1);
  frame.add(l3);
  frame.add(p1);
  frame.add(btn1);
 btn1.addActionListener ((ActionListener) this);
  frame.setSize(600, 500);
  frame.setLayout(null);
  frame.setVisible(true);
 }
 public void actionPerformed(ActionEvent ae)
 {
   String uname = tf1.getText();
   String pass = p1.getText();
   if(uname.equals("cheikh") && pass.equals("passer"))
   {
       frame.setVisible(false);
      Formulair wel = new Formulair();
      wel.setVisible(true);
      JLabel label = new JLabel("Utilisateur connecté: "+uname);
      wel.getContentPane().add(label);
    }
    else
    {
      JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE); 
    }
  }

   
    
}
