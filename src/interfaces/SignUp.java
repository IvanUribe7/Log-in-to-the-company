package interfaces;

import utilisateurs.*;

import java.util.Scanner;

public class SignUp {
	
	/*Classe SignUp 
	 * Classe qui a comme unique fonction de lancer la m�thode lancerNouvelleCompte() qui 
	 * demande � l'utilisateur ses donn�es pour cr�er son compte (Employe ou Administrateur) et ensuite l'enregistrer dans la liste des employ�s.
	 * Si on veut cr�er une compte administrateur il faut saisir le code (SUPER) secret 123456789
	 * Le programme verifie si la date, le pr�nom et le nom son au bon format.
	 * Il gen�re au utilisateur son id et son adresse e-mail.
	 * En cas d'erreur de saisie le programme oblige l'utilisateurs � remettre ses donn�es
	 * En cas de succ�s le programme va renvoyer l'utilisateur au Menu
	 * */

	public static SignUp signUp;
	
	
	public static void lancerNouvelleCompte() {
		Methodes methodes = new Methodes();
		String prenom = "";
		String nom,dateDeNaissance,adresseMail,motDePasse,reponseEntrerEnModeAdmin,codeSecretEmploye;
		Scanf.openScanner();
		System.out.println("Veuillez saisir votre pr�nom ci-dessous :(Seulement votre premier prenom est necessaire)");
		prenom = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre nom ci-dessous :(Seulement votre premier nom est necessaire)");
		nom = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre date de naissance ci-dessous : (format:jj/MM/aaaa)");
		dateDeNaissance = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = Scanf.getInput() ;
		System.out.println("Voulez-vous cr�er un compte administrateur?: (vous aurez besoin du mot de passe secret pour y acc�der)\n"
				+ "1-Oui\n"
				+ "2-Non\n");
		reponseEntrerEnModeAdmin = Scanf.getInput() ;
		
		adresseMail = Methodes.creerAdresseMail(prenom,nom);
		
		if(reponseEntrerEnModeAdmin.equals("1")) {
			String codeSecret = "123456789";
			System.out.println("Saisissez le code secret (connu uniquement par les administrateurs) pour cr�er un compte administrateur :");
			codeSecretEmploye = Scanf.getInput() ;
			
			if(codeSecretEmploye.equals(codeSecret)) {
				int id = Methodes.saisirIdAdmin();
				Administrateur admin = new Administrateur(prenom,nom,dateDeNaissance,adresseMail,motDePasse,id);
				Employe.ajouterEmploye(admin);
				System.out.println("Votre compte a �t� cr�� avec succ�s, votre nouvelle adresse e-mail et id sont :" + adresseMail + ", " + id);
				Menu.lancerMenu();
			
			}else {
				System.out.println("Erreur: Code Sercret INCORRECTE, veuillez recommencer la cr�ation de votre compte!");
				SignUp.lancerNouvelleCompte();
			}
			
		} else {
			int id = Methodes.saisirIdEmploye();
			Employe employe = new Employe(prenom,nom,dateDeNaissance,adresseMail,motDePasse,id);
			Employe.ajouterEmploye(employe);
			System.out.println("Votre compte a �t� cr�� avec succ�s, votre nouvelle adresse e-mail et id sont :" + adresseMail + ", " + id);
			Menu.lancerMenu();
		}
	}
}

