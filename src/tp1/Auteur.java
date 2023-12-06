package tp1;

public class Auteur extends Personne {
	private String codeAuteur;

	private Auteur(String nom,String prenom, String codeAuteur) {
		super(nom,prenom);
		this.codeAuteur=codeAuteur;
	}
	
	public String getCodeAuteur() {
		return codeAuteur;
	}

	public void setCodeAuteur(String codeAuteur) {
		this.codeAuteur = codeAuteur;
	}
	
	@Override
	public String toString() {
		return this.getCodeAuteur()+"_"+super.toString();
	}

}
