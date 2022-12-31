package testAndMain;
import interfaces.*;
import utilisateurs.*;
public class Test {
	public static void main(String[] args) {
	Employe employe1 = new Employe("Ivan","Uribe","07/11/2003","ivan_uribe@univtlse3.fr","helloworld",100);
	Employe employe2 = new Employe("Pancho","Ostia","09/11/2003","pancho_uribe@univtlse3.fr","helloworld",101);
	Administrateur admin1 = new Administrateur("Alfredo","Espinoza","08/11/2003","alfredo_uribe@univtlse3.fr","hola",200);
	Employe.ajouterEmploye(employe1);
	Employe.ajouterEmploye(employe2);
	Employe.ajouterEmploye(admin1);
	System.out.println((Employe.getListeDeEmploye())[1].getPrenom());
	Administrateur.supprimerEmployeDeListe("pancho_uribe@univtlse3.fr");
	System.out.println((Employe.getListeDeEmploye())[1].getPrenom());
	}
}
