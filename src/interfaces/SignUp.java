package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignUp {
	
	/*Classe SignUp 
	 * Classe qui a comme unique fonction de lancer la méthode lancerNouvelleCompte() qui 
	 * demande à l'utilisateur ses données pour créer son compte (Employe ou Administrateur) et ensuite l'enregistrer dans la liste des employés.
	 * Si on veut créer une compte administrateur il faut saisir le code (SUPER) secret 123456789
	 * Le programme verifie si la date, le prénom et le nom son au bon format.
	 * Il genère au utilisateur son id et son adresse e-mail.
	 * En cas d'erreur de saisie le programme oblige l'utilisateurs à remettre ses données
	 * En cas de succès le programme va renvoyer l'utilisateur au Menu
	 * */

	public static SignUp signUp;
	
	
	public static void lancerNouvelleCompte() {
		Methodes methodes = new Methodes();
		String prenom = "";
		String nom,dateDeNaissance,adresseMail,motDePasse,reponseEntrerEnModeAdmin,codeSecretEmploye;
		Scanf.openScanner();
		System.out.println("Veuillez saisir votre prénom ci-dessous :(Seulement votre premier prenom est necessaire)");
		prenom = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre nom ci-dessous :(Seulement votre premier nom est necessaire)");
		nom = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre date de naissance ci-dessous : (format:jj/MM/aaaa)");
		dateDeNaissance = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = Scanf.getInput() ;
		System.out.println("Voulez-vous créer un compte administrateur?: (vous aurez besoin du mot de passe secret pour y accéder)\n"
				+ "1-Oui\n"
				+ "2-Non\n");
		reponseEntrerEnModeAdmin = Scanf.getInput() ;
		
		adresseMail = Methodes.creerAdresseMail(prenom,nom);
		
		if(reponseEntrerEnModeAdmin.equals("1")) {
			String codeSecret = "123456789";
			System.out.println("Saisissez le code secret (connu uniquement par les administrateurs) pour créer un compte administrateur :");
			codeSecretEmploye = Scanf.getInput() ;
			
			if(codeSecretEmploye.equals(codeSecret)) {
				int id = Methodes.saisirIdAdmin();
				Administrateur admin = new Administrateur(prenom,nom,dateDeNaissance,adresseMail,motDePasse,id);
				Employe.ajouterEmploye(admin);
				System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail et id sont :" + adresseMail + ", " + id);
				Menu.lancerMenu();
			
			}else {
				System.out.println("Erreur: Code Sercret INCORRECTE, veuillez recommencer la création de votre compte!");
				SignUp.lancerNouvelleCompte();
			}
			
		} else {
			int id = Methodes.saisirIdEmploye();
			Employe employe = new Employe(prenom,nom,dateDeNaissance,adresseMail,motDePasse,id);
			Employe.ajouterEmploye(employe);
			System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail et id sont :" + adresseMail + ", " + id);
			Menu.lancerMenu();
		}
	}
}

