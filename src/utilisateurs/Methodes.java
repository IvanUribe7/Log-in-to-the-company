package utilisateurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Methodes{
	
	public static Methodes methode;
	
	public boolean estDansLaListeDesEmployes(String adresseMail,String motDePasse) {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if((listeDeEmploye[i].getGmail()).equals(adresseMail)&&(listeDeEmploye[i].getMotDePasse()).equals(motDePasse)) {
				return true;
			}
		}
		return false;
	}
	
	public Employe employeDansLaListe(String adresseMail,String motDePasse) {
		Employe[] listeDeEmploye = Employe.getListeDeEmploye();
		for(int i = 0; i < Employe.getNbDeEmploye();i++) {
			if((listeDeEmploye[i].getGmail()).equals(adresseMail)&&(listeDeEmploye[i].getMotDePasse()).equals(motDePasse)) {
				return listeDeEmploye[i];
			}
		}
		return null;
		
	}
	
	public String creerAdresseMail(String prenom, String nom) {
		prenom = prenom.substring(0,1).toLowerCase() + prenom.substring(1).toLowerCase();
		nom = nom.substring(0,1).toLowerCase() + nom.substring(1).toLowerCase();
		return prenom + "_" + nom + "@univtls3.fr";
	}
	
	public boolean estAuBonFormatDate(String date) {
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            formatDate.setLenient(false);
            formatDate.parse(date);
        } catch (ParseException e) {
            return true;
        }
        return false;
    }
	
	public boolean estAuBonFormatNommage(String nom) {
		for (int x = 0; x < nom.length(); x++) {
	        char c = nom.charAt(x);
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	            return true;
	        }
	    }
	    return false;	
	}
	
	public boolean estAuBonFormatFormulaireSignIn(String date,String prenom,String nom) {
		boolean resultat;
		resultat = estAuBonFormatDate(date);
		resultat = estAuBonFormatNommage(prenom);
		resultat = estAuBonFormatNommage(nom);
		return resultat;
	}
	
	public static void main(String[] args) {
	}
	
	
}
