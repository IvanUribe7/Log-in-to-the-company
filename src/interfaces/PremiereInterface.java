package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilisateurs.*;
import serveur.Serveur;

public class PremiereInterface extends JFrame implements ActionListener {
	JLabel messageTitre;
	JButton creerUneCompte,accederAvecVotreCompte;
	JPanel panel;
	
	PremiereInterface(){
		messageTitre = new JLabel("Que voulez-vous faire ?");
		messageTitre.setBounds(150,30,200,20);
		
		creerUneCompte = new JButton("Creer une nouvelle compte ");
		creerUneCompte.setBounds(80,80,300,20);
		creerUneCompte.addActionListener(this);
		
		accederAvecVotreCompte = new JButton("Accédez avec votre compte");
		accederAvecVotreCompte.setBounds(80,130,300,20);
		accederAvecVotreCompte.addActionListener(this);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(messageTitre);
		panel.add(creerUneCompte);
		panel.add(accederAvecVotreCompte);
		add(panel);
		setSize(450,500);
		setTitle("Choisissez une option :");
	
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Serveur serveur = new Serveur();
		PremiereInterface premiereInterface = new PremiereInterface();
		
	}
	
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == creerUneCompte) {
	    	setVisible(false);
			SignIn interfaceSignIn = new SignIn();
		}else {
			setVisible(false);
			SignUp interfaceSignUp = new SignUp();
		}
	}
	
}
