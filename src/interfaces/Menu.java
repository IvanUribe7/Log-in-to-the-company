package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class Menu {
	
	public void lancerMenu() {
		Scanner scanIn = new Scanner(System.in);
		Serveur server = new Serveur();
		String reponse;
		System.out.println("Bonjour !\r\n"
				+ "Il s'agit de l'interface principale de l'entreprise\r\n"
				+ "Que voulez-vous faire ? (Choisissez une option en entrant le num�ro correspondant � celle-ci) :\r\n"
				+ "1-Cr�er un compte\r\n"
				+ "2-Connectez-vous avec votre compte\r\n"
				+ "3-Menu de sortie");
		reponse = scanIn.nextLine();
		
		switch(reponse) {
		case "1":
		SignUp creerUneNouvelleCompte = new SignUp();
		creerUneNouvelleCompte.lancerCreerUnCompte();
		
		case "2":
			SignIn entrerAvecCompte = new SignIn();
			entrerAvecCompte.lancerEntrerAvecCompte();
		
		case "3":
		System.out.println("Merci d'avoir test� cette D�mo!");
		scanIn.close();
	}
	
	}
}
