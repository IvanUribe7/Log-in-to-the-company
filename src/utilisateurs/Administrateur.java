package utilisateurs;
import  java.util.*;
import java.util.Scanner;

public class Administrateur extends Employe {
	
	/*Classe Administrateur
	 * Il s'agit de la classe fille de la classe Employe.
	 *Son r�le, comme vous vous en doutez, est de g�rer les comptes des employ�s, 
	 *soit en g�rant leurs donn�es personnelles, soit en les supprimant de la liste 
	 *des employ�s ayant acc�s � l'interface de l'entreprise.
	 * */
	
	public Administrateur(String prenom, String nom, String dateDeNaissance,String gmail,String motDePasse,int id) {
		super(prenom,nom,dateDeNaissance,gmail,motDePasse,id);
		}
	
	/*Classe Administrateur : M�thode supprimerEmployeDeListe(int id)
	 * Cette s'encharge de supprimer l'employ� de la liste des employ�s avec l'id en param�tre.
	 * Elle retourne un la liste sans l'employe avec l'id en param�tre
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

		 /*Classe Administrateur : M�thode changerLesDonneesDeUnEmploye(Employe employe)
			 * Cette s'encharge de changer les doon�es personnels de l'employ� mit en param�tre
			 * */
		 
		public static void changerLesDonneesDeUnEmploye(Employe employe) {
			String prenom,nom,dateDeNaissance,adresseMail,motDePasse;
			System.out.println("Veuillez saisir le pr�nom ci-dessous :");
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
