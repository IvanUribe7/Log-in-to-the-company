package utilisateurs;
import  java.util.*;
import java.util.Scanner;

public class Administrateur extends Employe {
	
	/*Classe Administrateur
	 * Il s'agit de la classe fille de la classe Employe.
	 *Son rôle, comme vous vous en doutez, est de gérer les comptes des employés, 
	 *soit en gérant leurs données personnelles, soit en les supprimant de la liste 
	 *des employés ayant accès à l'interface de l'entreprise.
	 * */
	
	public Administrateur(String prenom, String nom, String dateDeNaissance,String gmail,String motDePasse,int id) {
		super(prenom,nom,dateDeNaissance,gmail,motDePasse,id);
		}
	
	/*Classe Administrateur : Méthode supprimerEmployeDeListe(int id)
	 * Cette s'encharge de supprimer l'employé de la liste des employés avec l'id en paramètre.
	 * Elle retourne un la liste sans l'employe avec l'id en paramètre
	 * */
		
	
		 public static void supprimerEmployeDeListe(int id) {
			Employe[] listeDeEmploye = Employe.getListeDeEmploye();
			Employe[] nouvelleListeDeEmploye = new Employe[100];
			int k = 0;
			for(int i = 0; i < Employe.getNbDeEmploye();i++) {
				if((listeDeEmploye[i].getId()==id)){
					k++;}
				else{
					nouvelleListeDeEmploye[i-k] = listeDeEmploye[i];
				}
			}
			Employe.setListeDeEmploye(nouvelleListeDeEmploye);
			System.out.println("L'employe n'est plus dans la liste!");
			
		}

		 /*Classe Administrateur : Méthode changerLesDonneesDeUnEmploye(Employe employe)
			 * Cette s'encharge de changer les doonées personnels de l'employé mit en paramètre
			 * */
		 
		public static void changerLesDonneesDeUnEmploye(Employe employe) {
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
