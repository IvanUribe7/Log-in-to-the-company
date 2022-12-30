package utilisateurs;

import java.util.Scanner;

public class Administrateur extends Employe {
	
	private String codeSecret;
	
	public Administrateur(String prenom, String nom, String dateDeNaissance,String gmail,String motDePasse,String codeSecret) {
		super(prenom,nom,dateDeNaissance,gmail,motDePasse);
		this.codeSecret = "123456789";
		}
		
	
		private void supprimerEmployeDeListe(Employe employe) {
			Serveur server = new Serveur();
			Employe[] listeDeEmploye = server.getListeDeEmploye();
			for(int i = 0; i < server.getNbDeEmploye();i++) {
				if(listeDeEmploye[i].equals(employe)) {
					listeDeEmploye[i] = null;
					for(int j = i; j < server.getNbDeEmploye()-1;j++) {
						listeDeEmploye[j] = listeDeEmploye[j+1];
				}
			}
			
			
		}
}


		public String getCodeSecret() {
			return codeSecret;
		}
		
		private void changerLesDonneesDeUnEmploye(Employe employe) {
			Scanner scanIn = new Scanner(System.in);
			String prenom,nom,dateDeNaissance,adresseMail,motDePasse;
			System.out.println("Veuillez saisir le prénom ci-dessous :");
			prenom = scanIn.nextLine();
			System.out.println("Veuillez saisir le nom ci-dessous :");
			nom = scanIn.nextLine();
			System.out.println("Veuillez saisir la date de naissance ci-dessous :");
			dateDeNaissance = scanIn.nextLine();
			System.out.println("Veuillez saisir l'adresse e-mail ci-dessous :");
			adresseMail = scanIn.nextLine();
			System.out.println("Veuillez saisir le mot de passe ci-dessous :");
			motDePasse = scanIn.nextLine();
			scanIn.close();	
			employe.setPrenom(prenom);
			employe.setNom(nom);
			employe.setDateDeNaissance(dateDeNaissance);
			employe.setGmail(adresseMail);
			employe.setMotDePasse(motDePasse);
			
		}
}
