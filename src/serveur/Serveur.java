package serveur;
import utilisateurs.*;
public class Serveur {
	public int nbDeEmploye;
	public Employe[] listeDeEmploye = new Employe[100];
	
	public Serveur() {	
	}
	
	public String ajouterEmploye(Employe employe) {
		String resultat;
		if(nbDeEmploye==100) {
			resultat = "Serveur: Nombre maximal d'employ�s atteint";
			return resultat;
		}
		else {
			this.listeDeEmploye[nbDeEmploye] = employe;
			nbDeEmploye++;
			resultat = "Serveur: L'employ� " + employe.getPrenom() + " " + employe.getNom() + " a �t� ajout� avec succ�s!";
			return resultat;
		}
	}
	
}
