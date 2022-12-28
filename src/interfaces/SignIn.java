package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilisateurs.*;
import serveur.Serveur;

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
				
				messageGmail = new JLabel("Adresse mail ");
				messageGmail.setBounds(100,230,200,20);
				
				messagePassword = new JLabel("Mot de passe ");
				messagePassword.setBounds(100,280,200,20);
				
				messageQuestionAdmin = new JLabel("Voulez-vous créer un compte administrateur ?");
				messageQuestionAdmin.setBounds(100,330,300,20);
				
				
				prenom = new JTextField();
				prenom.setBounds(100,100,180,20);

				nom = new JTextField();
				nom.setBounds(100,150,180,20);
				
				dateDeNaissance = new JFormattedTextField("jj/MM/aaaa");
				dateDeNaissance.setBounds(100,200,68,20);
				
				gmail = new JTextField();
				gmail.setBounds(100,250,200,20);
				
				password = new JPasswordField();
				password.setBounds(100,300,200,20);
				
				ouiAdmin = new JRadioButton("Oui");
				ouiAdmin.setBounds(180,350,200,20);

				nonAdmin = new JRadioButton("Non");
				nonAdmin.setBounds(110,350,200,20);
				
				accepter = new JButton("Accepter");
				accepter.setBounds(165,400,100,20);
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
				panel.add(messageGmail);
				panel.add(messagePassword);
				panel.add(prenom);
				panel.add(nom);
				panel.add(dateDeNaissance);
				panel.add(gmail);
				panel.add(password);
				panel.add(ouiAdmin);
				panel.add(nonAdmin);
				panel.add(messageQuestionAdmin);
				panel.add(accepter);
				
				
				add(panel);
				setSize(450,500);
				setTitle("Accez à votre espace entreprise");
			
				setVisible(true);
			}
			
			
			public static void main(String[] args) {
				SignIn interfaceSignIn = new SignIn();
				
			}
			
			public void actionPerformed(ActionEvent e) {
			    if (e.getSource() == accepter) {
				String prenomUser = prenom.getText();
				String nomUser = nom.getText();
				String dateDeNaissanceUser = dateDeNaissance.getText();
				String gmailUser = gmail.getText();
				String passwordUser = String.valueOf(password.getPassword());
				
				Employe employe = new Employe(prenomUser,nomUser,dateDeNaissanceUser,gmailUser,passwordUser);
				
				String messageServeur = serveur.ajouterEmploye(employe);
				
				JOptionPane.showMessageDialog(null, messageServeur);
				
				
			}
		}

}
