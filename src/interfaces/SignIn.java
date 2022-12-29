package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilisateurs.*;
import serveur.Serveur;
import testAndMain.*;

public class SignIn extends JFrame implements ActionListener{
		
			JLabel messageTitre, messagePrenom, messageNom,messageDateDeNaissance,messageGmail,messagePassword,messageQuestionAdmin;
			JButton accepter;
			JTextField nom,prenom,gmail;
			JPasswordField password;
			JPanel panel;
			ButtonGroup groupeBoutton;
			JFormattedTextField dateDeNaissance; 
			JRadioButton ouiAdmin,nonAdmin;
				
			SignIn(){
				
				messageTitre = new JLabel("Inserer vos données ");
				messageTitre.setBounds(150,30,200,20);
				
				messagePrenom = new JLabel("Prénom ");
				messagePrenom.setBounds(100,80,180,20);
				
				messageNom= new JLabel("Nom ");
				messageNom.setBounds(100,130,180,20);

				messageDateDeNaissance = new JLabel("Date de naissance ");
				messageDateDeNaissance.setBounds(100,180,200,20);
				
				messagePassword = new JLabel("Mot de passe ");
				messagePassword.setBounds(100,230,200,20);
				
				messageQuestionAdmin = new JLabel("Voulez-vous créer un compte administrateur ?");
				messageQuestionAdmin.setBounds(100,280,300,20);
				
				
				prenom = new JTextField();
				prenom.setBounds(100,100,180,20);

				nom = new JTextField();
				nom.setBounds(100,150,180,20);
				
				dateDeNaissance = new JFormattedTextField("jj/MM/aaaa");
				dateDeNaissance.setBounds(100,200,68,20);
				
				password = new JPasswordField();
				password.setBounds(100,250,200,20);
				
				ouiAdmin = new JRadioButton("Oui");
				ouiAdmin.setBounds(180,300,200,20);
				ouiAdmin.addActionListener(this);
				
				nonAdmin = new JRadioButton("Non");
				nonAdmin.setBounds(110,300,200,20);
				nonAdmin.addActionListener(this);
				
				accepter = new JButton("Accepter");
				accepter.setBounds(165,350,100,20);
				accepter.addActionListener(this);
				
				
				panel = new JPanel();
				groupeBoutton = new ButtonGroup();
				groupeBoutton.add(ouiAdmin);
				groupeBoutton.add(nonAdmin);
				panel.setLayout(null);
				panel.add(messageTitre);
				panel.add(messagePrenom);
				panel.add(messageNom);
				panel.add(messageDateDeNaissance);
				panel.add(messagePassword);
				panel.add(prenom);
				panel.add(nom);
				panel.add(dateDeNaissance);
				panel.add(password);
				panel.add(ouiAdmin);
				panel.add(nonAdmin);
				panel.add(messageQuestionAdmin);
				panel.add(accepter);
				
				
				add(panel);
				setSize(450,500);
				setTitle("Enregistrement des données en cours...");
			
				setVisible(true);
			}
			
			
			public static void main(String[] args) {
				SignIn interfaceSignIn = new SignIn();
				
			}
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ouiAdmin) {
					JOptionPane.showMessageDialog(null, "je sui god");
				}
			    if (e.getSource() == accepter) {
			    	
			    	
			    	
			
			    Serveur server = new Serveur();
			    Methodes methodes = new Methodes();
				String prenomUser = prenom.getText();
				String nomUser = nom.getText();
				String dateDeNaissanceUser = dateDeNaissance.getText();
				String passwordUser = String.valueOf(password.getPassword());
				String gmailUser = creerAdresseMail(prenomUser,nomUser);
				
				if(methodes.estAuBonFormatFormulaireSignIn(dateDeNaissanceUser,prenomUser,nomUser)) {
					JOptionPane.showMessageDialog(null, "Erreur: Les données fournis sont pas au bon format");
					setVisible(false);
					SignIn interfaceSignIn = new SignIn();

				}else {
					
				JOptionPane.showMessageDialog(null, "Ton adresse mail est: " + gmailUser + "\n Votre compte employé a été creer avec succès!");
				Employe employe = new Employe(prenomUser,nomUser,dateDeNaissanceUser,gmailUser,passwordUser);
				server.ajouterEmploye(employe);
				}
				
			}
		}
			
			public String creerAdresseMail(String prenom, String nom) {
				prenom = prenom.substring(0,1).toLowerCase() + prenom.substring(1).toLowerCase();
				nom = nom.substring(0,1).toLowerCase() + nom.substring(1).toLowerCase();
				return prenom + "_" + nom + "@univtls3.fr";
			}

}
