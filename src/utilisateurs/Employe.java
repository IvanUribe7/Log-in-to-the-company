package utilisateurs;

public class Employe {
	private String prenom;
	private String nom;
	private String dateDeNaissance;
	private String gmail;
	private String motDePasse;
	
	public Employe(String prenom,String nom,String dateDeNaissance,String gmail,String motDePasse) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.gmail = gmail;
		this.motDePasse = motDePasse;
	}

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
	
	
}
