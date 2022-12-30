package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignIn{
	
	public void lancerEntrerAvecCompte() {
		Methodes methodes = new Methodes();
		Scanner scanIn = new Scanner(System.in);
		String adresseMail,motDePasse;
		System.out.println("Veuillez saisir votre adresse électronique ci-dessous :");
		adresseMail = scanIn.nextLine();
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = scanIn.nextLine();
		if(methodes.estDansLaListeDesEmployes(adresseMail,motDePasse)==true) {
			scanIn.close();
			Employe employe = methodes.employeDansLaListe(adresseMail,motDePasse);
			employe.lancerProfil();
		}else {scanIn.close();
		System.out.println("Erreur: Adresse mail ou mot de passe incorecte");
			this.lancerEntrerAvecCompte();
		}
		
		
	}
			
}
