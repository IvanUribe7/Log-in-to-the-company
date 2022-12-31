package utilisateurs;
import  java.util.*;
import java.util.Scanner;

public class Administrateur extends Employe {
	
	private String codeSecret;
	
	public Administrateur(String prenom, String nom, String dateDeNaissance,String gmail,String motDePasse,int id) {
		super(prenom,nom,dateDeNaissance,gmail,motDePasse,id);
		}
		
	
		 public static void supprimerEmployeDeListe(String adresseMail) {
			Employe[] listeDeEmploye = Employe.getListeDeEmploye();
			for(int i = 0; k = 0; i < Employe.getNbDeEmploye();i++) {
				if((listeDeEmploye[i].getGmail()).equals(adresseMail)) {
						continue;}
				else{
						listeDeEmploye[i] = listeDeEmploye[i+1];
				}
			}
			
			
		}

		
		private static void changerLesDonneesDeUnEmploye(Employe employe) {
			String prenom,nom,dateDeNaissance,adresseMail,motDePasse;
			System.out.println("Veuillez saisir le prénom ci-dessous :");
			prenom = Scanf.getInput() ;
			System.out.println("Veuillez saisir le nom ci-dessous :");
			nom = Scanf.getInput() ;
			System.out.println("Veuillez saisir la date de naissance ci-dessous :");
			dateDeNaissance = Scanf.getInput() ;
			System.out.println("Veuillez saisir l'adresse e-mail ci-dessous :");
			adresseMail = Scanf.getInput() ;
			System.out.println("Veuillez saisir le mot de passe ci-dessous :");
			motDePasse = Scanf.getInput() ;
			employe.setPrenom(prenom);
			employe.setNom(nom);
			employe.setDateDeNaissance(dateDeNaissance);
			employe.setGmail(adresseMail);
			employe.setMotDePasse(motDePasse);
			
		}
}
