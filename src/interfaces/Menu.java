package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class Menu {
	
	/*Classe Menu
	 * Classe qui a comme unique fonction de lancer la m�thode lancerMenu() qui 
	 * demande � l'utilisateur qu'est ce qu'il veut faire dans cette interface.
	 * */
	
	public static Menu menu;
	
	
	public static void lancerMenu() {
		String reponse;
		System.out.println("Bonjour !\r\n"
				+ "Il s'agit de l'interface principale de l'entreprise\r\n"
				+ "Que voulez-vous faire ? (Choisissez une option en entrant le num�ro correspondant � celle-ci) :\r\n"
				+ "1-Cr�er un compte\r\n"
				+ "2-Connectez-vous avec votre compte\r\n"
				+ "3-Menu de sortie");
		reponse = Scanf.getInput() ;
		
		if(reponse.equals("1")) {
		SignUp.lancerNouvelleCompte();
		}
		if(reponse.equals("2")) {
			SignIn.lancerAccesAvecCompte();}
		
		if(reponse.equals("3")) {
		System.out.println("Merci d'avoir test� cette D�mo!");
	}
	
	}
}
