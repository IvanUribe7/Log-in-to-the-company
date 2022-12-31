package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignUp {

	public static SignUp signUp;
	
	
	public static void lancerNouvelleCompte() {
		Methodes methodes = new Methodes();
		Scanner scanIn = new Scanner(System.in);
		String prenom = "";
		String nom,dateDeNaissance,adresseMail,motDePasse,reponseEntrerEnModeAdmin,codeSecretEmploye;
		Scanf.openScanner();
		System.out.println("Veuillez saisir votre prénom ci-dessous :");
		prenom = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre nom ci-dessous :");
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
			System.out.println("Saisissez le code secret (connu uniquement des administrateurs) pour créer un compte administrateur :");
			codeSecretEmploye = Scanf.getInput() ;
			
			if(codeSecretEmploye.equals(codeSecret)) {
				int id = Methodes.saisirIdAdmin();
				Employe admin = new Administrateur(prenom,nom,dateDeNaissance,adresseMail,motDePasse,id);
				Employe.ajouterEmploye(admin);
				System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail est :" + adresseMail);
				Menu.lancerMenu();
			
			}else {
				System.out.println("Erreur: Code Sercret INCORRECTE, veuillez recommencer la création de votre compte!");
				SignUp.lancerNouvelleCompte();
			}
			
		} else {
			int id = Methodes.saisirIdEmploye();
			Employe employe = new Employe(prenom,nom,dateDeNaissance,adresseMail,motDePasse,id);
			Employe.ajouterEmploye(employe);
			System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail est :" + adresseMail);
			Menu.lancerMenu();
		}
	}
	}

