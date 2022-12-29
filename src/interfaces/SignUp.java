package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilisateurs.*;
import serveur.Serveur;

public class SignUp extends JFrame implements ActionListener{

	
	JLabel messageTitre,messageGmail,messagePassword,messageQuestionAdmin;
	JButton accepter;
	JTextField gmail;
	JPasswordField password;
	ButtonGroup groupeBoutton;
	JPanel panel;
	JRadioButton ouiAdmin,nonAdmin;
	
	SignUp(){
		
		messageTitre = new JLabel("Inserer vos données ");
		messageTitre.setBounds(150,30,200,20);
		
		messageGmail = new JLabel("Adresse mail ");
		messageGmail.setBounds(100,80,180,20);
		
		messagePassword= new JLabel("Mot de passe ");
		messagePassword.setBounds(100,130,180,20);
		
		messageQuestionAdmin = new JLabel("Voulez-vous créer un compte administrateur ?");
		messageQuestionAdmin.setBounds(100,180,300,20);
		
		gmail = new JTextField();
		gmail.setBounds(100,100,180,20);

		password = new JPasswordField();
		password.setBounds(100,150,180,20);
		
		ouiAdmin = new JRadioButton("Oui");
		ouiAdmin.setBounds(180,200,200,20);

		nonAdmin = new JRadioButton("Non");
		nonAdmin.setBounds(110,200,200,20);
		
		accepter = new JButton("Accepter");
		accepter.setBounds(165,250,100,20);
		accepter.addActionListener(this);
		
		
		panel = new JPanel();
		groupeBoutton = new ButtonGroup();
		groupeBoutton.add(ouiAdmin);
		groupeBoutton.add(nonAdmin);
		panel.setLayout(null);
		panel.add(messageTitre);
		panel.add(messageGmail);
		panel.add(messagePassword);
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
		SignUp interfaceSignUp = new SignUp();
	}
	
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == accepter) {
	    Serveur server = new Serveur();
	    boolean employeDansListe = false;
	    while(employeDansListe == false) {
		String passwordUser = String.valueOf(password.getPassword());
		String gmailUser = gmail.getText();
		for(int i = 1; i < 2;i++){
			if((server.listeDeEmploye[i].getGmail()).equals(gmailUser)&&(server.listeDeEmploye[i].getMotDePasse()).equals(passwordUser)) {
				employeDansListe = true;
			}
		}if(employeDansListe == true) {
			
		}else {
			JOptionPane.showMessageDialog(null, "Adresse ou mot de passe incorrecte!");
			setVisible(false);
			SignUp interfaceSignUp = new SignUp();
		}
		
	  }
	   
	}
}
}