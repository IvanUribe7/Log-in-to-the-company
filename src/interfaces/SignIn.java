package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignIn{
	
	/*Classe SignIn 
	 * Classe qui a comme unique fonction de lancer la m�thode lancerAccesAvecCompte() qui 
	 * demande � l'utilisateur une adresse �lectronique et un mot de passe pour acc�der � son profil.
	 * Vous devez cr�er un compte avant de pouvoir utiliser cette m�thode, sinon elle donne une erreur.
	 * Si vous ne saisissez pas les donn�es correctement, le programme vous demande de les saisir � nouveau.
	 * */
	
	public static SignIn signin;
	
	
	public static void lancerAccesAvecCompte() {
		
		String adresseMail,motDePasse;
		System.out.println("Veuillez saisir votre adresse �lectronique ci-dessous :");
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
