package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignIn{
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
