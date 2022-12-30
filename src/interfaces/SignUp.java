package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignUp {

	
	
	
	public void lancerCreerUnCompte() {
		Methodes methodes = new Methodes();
		Serveur server = new Serveur();
		Scanner scanIn = new Scanner(System.in);
		String prenom,nom,dateDeNaissance,adresseMail,motDePasse,reponseEntrerEnModeAdmin,codeSecretEmploye;
		System.out.println("Veuillez saisir votre prénom ci-dessous :");
		prenom = scanIn.nextLine();
		System.out.println("Veuillez saisir votre nom ci-dessous :");
		nom = scanIn.nextLine();
		System.out.println("Veuillez saisir votre date de naissance ci-dessous : (format:jj/MM/aaaa)");
		dateDeNaissance = scanIn.nextLine();
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = scanIn.nextLine();
		System.out.println("Voulez-vous créer un compte administrateur?: (vous aurez besoin du mot de passe secret pour y accéder)\n"
				+ "1-Oui\n"
				+ "2-Non\n");
		reponseEntrerEnModeAdmin = scanIn.nextLine();
		adresseMail = methodes.creerAdresseMail(prenom,nom);
		Menu menu = new Menu();
		if(reponseEntrerEnModeAdmin.equals("1")) {
			String codeSecret = "123456789";
			System.out.println("Saisissez le code secret (connu uniquement des administrateurs) pour créer un compte administrateur :");
			codeSecretEmploye = scanIn.nextLine();
			
			if(codeSecretEmploye.equals(codeSecret)) {
				Employe admin = new Administrateur(prenom,nom,dateDeNaissance,adresseMail,motDePasse,codeSecretEmploye);
				server.ajouterEmploye(admin);
				System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail est :" + adresseMail);
				menu.lancerMenu();
				scanIn.close();
			
			}else {
				System.out.println("Erreur: Code Sercret INCORRECTE, veuillez recommencer la création de votre compte!");
				this.lancerCreerUnCompte();
				scanIn.close();
			}
			
		} else {
			Employe employe = new Employe(prenom,nom,dateDeNaissance,adresseMail,motDePasse);
			server.ajouterEmploye(employe);
			System.out.println("Votre compte a été créé avec succès, votre nouvelle adresse e-mail est :" + adresseMail);
			menu.lancerMenu();
			scanIn.close();
		}
	}
	
	public static void main(String[] args) {SignUp creerUneNouvelleCompte = new SignUp();
	creerUneNouvelleCompte.lancerCreerUnCompte();}
}