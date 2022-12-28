package testAndMain;

import javax.swing.*;
import javax.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener{
	
		JLabel messageTitre, messagePrenom, messageNom,messageDateDeNaissance,messageGmail,messagePassword;
		JButton accepter;
		JTextField nom,prenom,gmail;
		JPasswordField password;
		JPanel panel;
		JFormattedTextField dateDeNaissance; 
			
		Interface(){
			
			messageTitre= new JLabel("Inserer vos données ");
			messageTitre.setBounds(150,30,200,20);
			
			messagePrenom= new JLabel("Prénom ");
			messagePrenom.setBounds(100,80,180,20);
			
			messageNom= new JLabel("Nom ");
			messageNom.setBounds(100,130,180,20);

			messageDateDeNaissance= new JLabel("Date de naissance ");
			messageDateDeNaissance.setBounds(100,180,200,20);
			
			messageGmail= new JLabel("Adresse mail ");
			messageGmail.setBounds(100,230,200,20);
			
			messagePassword= new JLabel("Mot de passe ");
			messagePassword.setBounds(100,280,200,20);
			
			
			prenom = new JTextField();
			prenom.setBounds(100,100,180,20);

			nom = new JTextField();
			nom.setBounds(100,150,180,20);
			
			dateDeNaissance = new JFormattedTextField("jj/mm/aaaa");
			dateDeNaissance.setBounds(100,200,68,20);
			
			gmail = new JTextField();
			gmail.setBounds(100,250,200,20);
			
			password = new JPasswordField();
			password.setBounds(100,300,200,20);
			
			accepter = new JButton("Accepter");
			accepter.setBounds(165,350,100,20);
			
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(messageTitre);
			panel.add(messagePrenom);
			panel.add(messageNom);
			panel.add(messageDateDeNaissance);
			panel.add(messageGmail);
			panel.add(messagePassword);
			panel.add(prenom);
			panel.add(nom);
			panel.add(dateDeNaissance);
			panel.add(gmail);
			panel.add(password);
			panel.add(accepter);
			
			
			add(panel);
			setSize(450,450);
			setTitle("Accez à votre espace entreprise");
		
			setVisible(true);
			
		}
		
		
		
		public static void main(String[] args) {
			Interface f = new Interface();
		}
		
		public void actionPerfomed(ActionEvent ae) {
			
			String prenomUser = prenom.getText();
			String nomUser = nom.getText();
			String dateDeNaissanceUser = dateDeNaissance.getText();
			String gmailUser = gmail.getText();
			String passwordUser = String.valueOf(password.getPassword());
			
		}
		

}
