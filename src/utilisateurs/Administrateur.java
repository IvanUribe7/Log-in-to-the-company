package utilisateurs;

public class Administrateur extends Employe {
	
	private String codeSecret;
	
	public Administrateur(String prenom, String nom, String dateDeNaissance,String gmail,String motDePasse,String codeSecret) {
		super(prenom,nom,dateDeNaissance,gmail,motDePasse);
		this.codeSecret = codeSecret;
	}

}
