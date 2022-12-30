package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignUp {

	public static SignUp signUp;
	
	
	public static void main(String[] args) {
		Methodes methodes = new Methodes();
		Serveur server = new Serveur();
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
		
		adresseMail = methodes.creerAdresseMail(prenom,nom);
		
		if(reponseEntrerEnModeAdmin.equals("1")) {
			String codeSecret = "123456789";
			System.out.println("Saisissez le code secret (connu uniquement des administrateurs) pour créer un compte administrateur :");
			codeSecretEmploye = Scanf.getInput() ;
			
			if(codeSecretEmploye.equals(codeSecret)) {
				Employe admin = new Administrateur(prenom,nom,dateDeNaissance,adresseMail,motDePasse,codeSecretEmploye);
				Administrateur.ajouterEmploye(admin);
				System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail est :" + adresseMail);
				Menu.main(null);
			
			}else {
				System.out.println("Erreur: Code Sercret INCORRECTE, veuillez recommencer la création de votre compte!");
				SignUp.main(null);
			}
			
		} else {
			Employe employe = new Employe(prenom,nom,dateDeNaissance,adresseMail,motDePasse);
			Employe.ajouterEmploye(employe);
			System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail est :" + adresseMail);
			Menu.main(null);
		}
	}
	}

