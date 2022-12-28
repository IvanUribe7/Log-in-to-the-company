package serveur;
import utilisateurs.*;
public class Serveur {
	private int nbDeEmploye;
	private Employe[] listeDeEmploye;
	
	public Serveur() {
		this.nbDeEmploye = 0;
		this.listeDeEmploye = new Employe[100];	
	}
	
	public String ajouterEmploye(Employe employe) {
		String resultat;
		if(nbDeEmploye==100) {
			resultat = "Serveur: Nombre maximal d'employés atteint";
			return resultat;
		}
		else {
			this.listeDeEmploye[nbDeEmploye] = employe;
			nbDeEmploye++;
			resultat = "Serveur: L'employé " + employe.getPrenom() + " " + employe.getNom() + " a été ajouté avec succès!";
			return resultat;
		}
	}
	
}
