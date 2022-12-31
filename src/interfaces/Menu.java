package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class Menu {
	public static Menu menu;
	public static void lancerMenu() {
		Scanner scanIn = new Scanner(System.in);
		String reponse;
		System.out.println("Bonjour !\r\n"
				+ "Il s'agit de l'interface principale de l'entreprise\r\n"
				+ "Que voulez-vous faire ? (Choisissez une option en entrant le numéro correspondant à celle-ci) :\r\n"
				+ "1-Créer un compte\r\n"
				+ "2-Connectez-vous avec votre compte\r\n"
				+ "3-Menu de sortie");
		reponse = scanIn.next();
		
		if(reponse.equals("1")) {
		Employe[] liste = Employe.getListeDeEmploye();
		System.out.println(liste[0]);
		SignUp.lancerNouvelleCompte();
		}
		if(reponse.equals("2")) {
			Employe[] liste = Employe.getListeDeEmploye();
			System.out.println(liste[0].getGmail() + "," + liste[0].getMotDePasse());
			SignIn.main(null);}
		
		if(reponse.equals("3")) {
		System.out.println("Merci d'avoir testé cette Démo!");
	}
	
	}
}
