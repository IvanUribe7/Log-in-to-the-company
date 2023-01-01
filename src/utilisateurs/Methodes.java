package utilisateurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Methodes{
	
	/*Classe Methodes:
	 * Classe qui s'encharge de faire appel à des méthodes pour le bon foctionnement du programme
	 */
	
	public static Methodes methode;
	
	/*Classe Methodes: Méthode saisirIdEmploye() et saisirIdAdmin()
	 * Méthode qui s'encharge de donner une id aux comptes selon son roles
	 * 	 */
	
	public static int saisirIdEmploye() {
		return 100 + Employe.getNbDeEmploye();
	}
	
	public static int saisirIdAdmin() {
		return 200 + Employe.getNbDeEmploye();
	}
	
	/*Classe Methodes: Méthode estDansLaListeDesEmployes(String adresseMail,String motDePasse) et employeDansLaListe(String adresseMail,String motDePasse) 
	 * La première méthode qui s'encharge de chercher dans la liste des employé s'il existe un qu'a le même e-mail et mot de passe en paramètre
	 * La deuxième méthode qui s'encharge de chercher dans la liste des employé s'il existe un qu'a le même e-mail et mot de passe et il renvoit ce employé s'il existe
	 * 	 */
	
	public static boolean estDansLaListeDesEmployes(String adresseMail,String motDePasse) {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if((listeDeEmploye[i].getGmail()).equals(adresseMail)&&(listeDeEmploye[i].getMotDePasse()).equals(motDePasse)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static Employe employeDansLaListe(String adresseMail,String motDePasse) {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if((listeDeEmploye[i].getGmail()).equals(adresseMail)&&(listeDeEmploye[i].getMotDePasse()).equals(motDePasse)) {
				return listeDeEmploye[i];
			}
		}
		return null;
		
	}
	
	/*Classe Methodes: Méthode estDansLaListeDesEmployes(String adresseMail,String motDePasse) 
	 * Méthode qui s'encharge de chercher dans la liste des employé et de retourner l'employé avec l'id en paramètre
	 * 	 */
	
	public static Employe estDansLaListeDesEmployesAvecId(int id) {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if(listeDeEmploye[i].getId()==id) {
				return listeDeEmploye[i];
			}
			}
		return null;
	}
	
	/*Classe Methodes: Méthode employeEnListe()
	 * Méthode qui s'encharge de montrer les données personnels des employés seulement
	 * 	 */
	
	public static void employeEnListe() {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if(listeDeEmploye[i].getId()>=200) {
				continue;
			}else { 
				int numeroEmploye = i + 1;
				System.out.println("Employe numéro " + numeroEmploye + ": " + listeDeEmploye[i].getPrenom() + " " + listeDeEmploye[i].getNom() + ", adresse e-mail: " + listeDeEmploye[i].getGmail() + ", id: " + listeDeEmploye[i].getId() + "\n" );
			}
		}
	}
	
	/*Classe Methodes: Méthode creerAdresseMail(String prenom, String nom)
	 * Méthode qui s'encharge de générer une adresse e-mail aux comptes
	 * 	 */
	
	public static String creerAdresseMail(String prenom, String nom) {
		prenom = prenom.substring(0,1).toLowerCase() + prenom.substring(1).toLowerCase();
		nom = nom.substring(0,1).toLowerCase() + nom.substring(1).toLowerCase();
		return prenom + "_" + nom + "@univtls3.fr";
	}
	
	/*Classe Methodes: Méthode estAuBonFormatDate(String date)
	 * Méthode qui s'encharge de vérifier si une date en paramètre est au bon format
	 * 	 */
	
	public static boolean estAuBonFormatDate(String date) {
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            formatDate.setLenient(false);
            formatDate.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
        }
	
	/*Classe Methodes: Méthode estAuBonFormatNommage(String nom)
	 * Méthode qui s'encharge de vérifier si un prénom ou nom en paramètre est au bon format
	 * 	 */
	
	public boolean estAuBonFormatNommage(String nom) {
		for (int x = 0; x < nom.length(); x++) {
	        char c = nom.charAt(x);
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	            return false;
	        }
	    }
	    return true;	
	}
	
	/*Classe Methodes: Méthode estAuBonFormatNommage(String nom)
	 * Méthode qui s'encharge regroupé les deux méthodes d'avant
	 * 	 */
	
	public boolean estAuBonFormatFormulaireSignUp(String date,String prenom,String nom) {
		boolean resultat1,resultat2,resultat3;
		resultat1 = estAuBonFormatDate(date);
		resultat2 = estAuBonFormatNommage(prenom);
		resultat3 = estAuBonFormatNommage(nom);
		if(resultat1&&resultat2&&resultat3) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
	}
	
	
}
