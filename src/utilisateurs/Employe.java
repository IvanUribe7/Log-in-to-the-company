package utilisateurs;

import java.util.Scanner;

public class Employe{
	private String prenom;
	private String nom;
	private String dateDeNaissance;
	private String gmail;
	private String motDePasse;
	
	public Employe(String prenom,String nom,String dateDeNaissance,String gmail,String motDePasse) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.gmail = gmail;
		this.motDePasse = motDePasse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public void changerSesDonnees() {
		Scanner scanIn = new Scanner(System.in);
		String prenom,nom,motDePasse;
		System.out.println("Veuillez saisir votre prénom ci-dessous :");
		prenom = scanIn.nextLine();
		System.out.println("Veuillez saisir votre nom ci-dessous :");
		nom = scanIn.nextLine();		
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = scanIn.nextLine();
		scanIn.close();	
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setMotDePasse(motDePasse);
		
	}
	
	public void lancerProfil() {
		Scanner scanIn = new Scanner(System.in);
		String reponse;
		System.out.println("Votre prenom est: " + this.getPrenom());
		System.out.println("Votre nom est: " + this.getNom());
		System.out.println("Votre date de naissance est: " + this.getDateDeNaissance());
		System.out.println("Votre adresse mail est: " + this.getGmail());
		System.out.println("Que voulez-vous faire ?"
				+ "1-Changer mes données personnels "
				+ "2-Fermer le programme ");
			reponse = scanIn.nextLine();
		switch(reponse) {
		
		case "1":this.changerSesDonnees();
				this.lancerProfil();
		case "2":System.out.println("Merci d'avoir testé cette Démo!");
		scanIn.close();
		}
			
		}
	
}

