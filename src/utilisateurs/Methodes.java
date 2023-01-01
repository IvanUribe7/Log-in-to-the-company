package utilisateurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Methodes{
	
	/*Classe Methodes:
	 * Classe qui s'encharge de faire appel � des m�thodes pour le bon foctionnement du programme
	 */
	
	public static Methodes methode;
	
	/*Classe Methodes: M�thode saisirIdEmploye() et saisirIdAdmin()
	 * M�thode qui s'encharge de donner une id aux comptes selon son roles
	 * 	 */
	
	public static int saisirIdEmploye() {
		return 100 + Employe.getNbDeEmploye();
	}
	
	public static int saisirIdAdmin() {
		return 200 + Employe.getNbDeEmploye();
	}
	
	/*Classe Methodes: M�thode estDansLaListeDesEmployes(String adresseMail,String motDePasse) et employeDansLaListe(String adresseMail,String motDePasse) 
	 * La premi�re m�thode qui s'encharge de chercher dans la liste des employ� s'il existe un qu'a le m�me e-mail et mot de passe en param�tre
	 * La deuxi�me m�thode qui s'encharge de chercher dans la liste des employ� s'il existe un qu'a le m�me e-mail et mot de passe et il renvoit ce employ� s'il existe
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
	
	/*Classe Methodes: M�thode estDansLaListeDesEmployes(String adresseMail,String motDePasse) 
	 * M�thode qui s'encharge de chercher dans la liste des employ� et de retourner l'employ� avec l'id en param�tre
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
	
	/*Classe Methodes: M�thode employeEnListe()
	 * M�thode qui s'encharge de montrer les donn�es personnels des employ�s seulement
	 * 	 */
	
	public static void employeEnListe() {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if(listeDeEmploye[i].getId()>=200) {
				continue;
			}else { 
				int numeroEmploye = i + 1;
				System.out.println("Employe num�ro " + numeroEmploye + ": " + listeDeEmploye[i].getPrenom() + " " + listeDeEmploye[i].getNom() + ", adresse e-mail: " + listeDeEmploye[i].getGmail() + ", id: " + listeDeEmploye[i].getId() + "\n" );
			}
		}
	}
	
	/*Classe Methodes: M�thode creerAdresseMail(String prenom, String nom)
	 * M�thode qui s'encharge de g�n�rer une adresse e-mail aux comptes
	 * 	 */
	
	public static String creerAdresseMail(String prenom, String nom) {
		prenom = prenom.substring(0,1).toLowerCase() + prenom.substring(1).toLowerCase();
		nom = nom.substring(0,1).toLowerCase() + nom.substring(1).toLowerCase();
		return prenom + "_" + nom + "@univtls3.fr";
	}
	
	/*Classe Methodes: M�thode estAuBonFormatDate(String date)
	 * M�thode qui s'encharge de v�rifier si une date en param�tre est au bon format
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
	
	/*Classe Methodes: M�thode estAuBonFormatNommage(String nom)
	 * M�thode qui s'encharge de v�rifier si un pr�nom ou nom en param�tre est au bon format
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
	
	/*Classe Methodes: M�thode estAuBonFormatNommage(String nom)
	 * M�thode qui s'encharge regroup� les deux m�thodes d'avant
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
