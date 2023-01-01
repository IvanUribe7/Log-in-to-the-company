package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignIn{
	
	/*Classe SignIn 
	 * Classe qui a comme unique fonction de lancer la méthode lancerAccesAvecCompte() qui 
	 * demande à l'utilisateur une adresse électronique et un mot de passe pour accéder à son profil.
	 * Vous devez créer un compte avant de pouvoir utiliser cette méthode, sinon elle donne une erreur.
	 * Si vous ne saisissez pas les données correctement, le programme vous demande de les saisir à nouveau.
	 * */
	
	public static SignIn signin;
	
	
	public static void lancerAccesAvecCompte() {
		
		String adresseMail,motDePasse;
		System.out.println("Veuillez saisir votre adresse électronique ci-dessous :");
		adresseMail =Scanf.getInput();
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = Scanf.getInput();
		
		if(Methodes.estDansLaListeDesEmployes(adresseMail,motDePasse)) {
			Employe employe = Methodes.employeDansLaListe(adresseMail,motDePasse);
			employe.lancerProfil();
		
		}else {
		System.out.println("Erreur: Adresse mail ou mot de passe incorecte");
		SignIn.lancerAccesAvecCompte();
		}
	}		
}
