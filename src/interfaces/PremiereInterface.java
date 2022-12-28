package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PremiereInterface extends JFrame implements ActionListener {
	JLabel messageTitre;
	JButton creerUneCompte,accederAvecVotreCompte;
	JPanel panel;
	
	PremiereInterface(){
		messageTitre = new JLabel("Que voulez-vous faire ?");
		messageTitre.setBounds(150,30,200,20);
		
		creerUneCompte = new JButton("Creer une nouvelle compte ");
		creerUneCompte.setBounds(80,80,300,20);
		
		accederAvecVotreCompte = new JButton("Accédez avec votre compte");
		accederAvecVotreCompte.setBounds(80,130,300,20);
		
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
		PremiereInterface premiereInterface = new PremiereInterface();
		
	}
	
}
