package utilisateurs;
import interfaces.*;
import java.util.Scanner;

public class Employe{
	private String prenom;
	private String nom;
	private String dateDeNaissance;
	private String gmail;
	private String motDePasse;
	private int id;
	public static int nbDeEmploye;
	public static Employe[] listeDeEmploye = new Employe[100];
	
	/*Classe Employe 
	 * Classe d�finit par un pr�nom, nom, date de naissance, adresse e-mail, mot de passe, et un id
	 * */
	
	public Employe(String prenom,String nom,String dateDeNaissance,String gmail,String motDePasse,int id) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.gmail = gmail;
		this.motDePasse = motDePasse;
		this.id = id;
	}
	
	/*Classe Employe 
	 * Getters and setters des variables en param�tre de la classe
	 * */

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
	
	public static void setListeDeEmploye(Employe[] listeDeEmploye) {
		Employe.listeDeEmploye = listeDeEmploye;
	}

	public int getId() {
		return id;
	}
	
	public static int getNbDeEmploye() {
		return nbDeEmploye;
	}

	public static Employe[] getListeDeEmploye() {
		return listeDeEmploye;
	}
	
	/*Classe Employe : M�thode changerSesDonnees()
	 * Methode qui s'encharge de pouvoir changer les donn�es personnels de l'utilisateurs comme il veut
	 * Il fait appel aux getters des variables qui d�finissent la classe Employe
	 * */
	
	public void changerSesDonnees() {
		Scanner scanIn = new Scanner(System.in);
		String prenom,nom,motDePasse;
		System.out.println("Veuillez saisir votre pr�nom ci-dessous :");
		prenom = Scanf.getInput() ;
		System.out.println("Veuillez saisir votre nom ci-dessous :");
		nom = Scanf.getInput() ;		
		System.out.println("Veuillez saisir votre mot de passe ci-dessous :");
		motDePasse = Scanf.getInput() ;
		scanIn.close();	
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setMotDePasse(motDePasse);
		
	}
	
	/*Classe Employe : M�thode ajouterEmploye(Employe employe)
	 * Methode qui s'encharge de pouvoir ajouter l'employ� en param�tre dans la liste des employ�
	 * Renvoit: "Serveur: Nombre maximal d'employ�s atteint" si le nombre d'employ� est atteint
	 * Renvoit: "Serveur: L'employ� " + employe.getPrenom() + " " + employe.getNom() + " a �t� ajout� avec succ�s!" si il l'a ajout� sans probl�mes
	 * */
	
	public static String ajouterEmploye(Employe employe) {
		String resultat;
		if(nbDeEmploye==100) {
			resultat = "Serveur: Nombre maximal d'employ�s atteint";
			return resultat;
		}
		else {
			Employe.listeDeEmploye[nbDeEmploye] = employe;
			nbDeEmploye++;
			resultat = "Serveur: L'employ� " + employe.getPrenom() + " " + employe.getNom() + " a �t� ajout� avec succ�s!";
			return resultat;
		}
	}
	
	/*Classe Employe : M�thode lancerProfil()
	 * Methode qui s'encharge montrer les donn�es personnels de la compte
	 * Si la compte c'est d'un employ� il lui appara�tra 2 option, 3 si c'est administrateur
	 * La option 1 permet de changer les donn�es personnels de la compte utilis�
	 * La option 2 renvoit l'utilisateur au Menu
	 * La option 3 permet l'administrateur de supprimer ou changer les donn�es personnels d'un compte a son election
	 * Il fait appel � la m�thode employeEnListe() qui montre tous les employ�s sans compter les administrateurs 
	 * Il peut donc v�rifier le id de la compte qui veut traiter
	 */
	
	public void lancerProfil() {
		String reponse;
		System.out.println("Votre prenom est: " + this.getPrenom());
		System.out.println("Votre nom est: " + this.getNom());
		System.out.println("Votre date de naissance est: " + this.getDateDeNaissance());
		System.out.println("Votre adresse e-mail est: " + this.getGmail());
		System.out.println("Votre id est: " + this.getId());
		if(this.getId()>=200) {
		System.out.println("Que voulez-vous faire ?:\n"
				+ "1-Changer mes donn�es personnels\n"
				+ "2-Aller au Menu\n"
				+ "3-Gestion des comptes");
				reponse = Scanf.getInput();
		}else {
			System.out.println("Que voulez-vous faire ?:\n"
					+ "1-Changer mes donn�es personnels\n"
					+ "2-Aller au Menu\n");
					reponse = Scanf.getInput();
		}
		if(reponse.equals("1")){this.changerSesDonnees();
				this.lancerProfil();}
			
		if(reponse.equals("2")){Menu.lancerMenu();}
		
		if(reponse.equals("3")) { System.out.println("Que voulez-vous faire ?\n"
				+ "1-Changer les donn�es personnels d'un employ�\n"
				+ "2-Suprim� un employ�\n");
				String reponseAdminOptions = Scanf.getInput();
				if(reponseAdminOptions.equals("1")) {
					System.out.println("Quels est l'id de l'employ� vous voulez travailler avec:");
					Methodes.employeEnListe();
					int reponse2 = Scanf.getInputInt();
					Employe employe = Methodes.estDansLaListeDesEmployesAvecId(reponse2);
					Administrateur.changerLesDonneesDeUnEmploye(employe);
					this.lancerProfil();
				}else {
					System.out.println("Quels est l'id de l'employ� vous voulez travailler avec:");
					Methodes.employeEnListe();
					int reponse2 = Scanf.getInputInt();
					Administrateur.supprimerEmployeDeListe(reponse2);
					this.lancerProfil();
				}
		}
		}
		
	
}

