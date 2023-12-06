package tp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Livre{
	private int codeLivre;
	private String titreLivre;
	private Auteur auteur;
	private int nbreExemplaires;
	private int nbreExemplairesDispo;
	
	public int getCodeLivre() {
		return codeLivre;
	}

	public void setCodeLivre(int codeLivre) {
		this.codeLivre = codeLivre;
	}

	public String getTitreLivre() {
		return titreLivre;
	}

	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public int getNbreExemplaires() {
		return nbreExemplaires;
	}

	public void setNbreExemplaires(int nbreExemplaires) {
		this.nbreExemplaires = nbreExemplaires;
	}

	public int getNbreExemplairesDispo() {
		return nbreExemplairesDispo;
	}

	public void setNbreExemplairesDispo(int nbreExemplairesDispo) {
		this.nbreExemplairesDispo = nbreExemplairesDispo;
	}

	public Livre(int codeL, String titreL, Auteur auteur, int nbreExemplaires, int nbreExemplaireDispo) {
		this.codeLivre=codeL;
		this.titreLivre=titreL;
		this.auteur=auteur;
		this.nbreExemplaires=nbreExemplaires;
		this.nbreExemplairesDispo=nbreExemplaireDispo;
	}
	
	public boolean LivreDisponible() {
		return this.nbreExemplairesDispo>0;
	}
	
	public void retourLivre() {
		this.nbreExemplairesDispo++;
	}

	@Override
	public String toString() {
		return this.getCodeLivre()+" "+this.getTitreLivre()+" "+this.getNbreExemplairesDispo();
	}

	public boolean isLivreDisponible() {
		return false;
	}
	public ArrayList livresTriesExemplairesDispo(){
		ArrayList<Livre> liste_livre= new ArrayList(this.codeLivre);
		for (Livre livre: liste_livre) {
			Livre min=livre;
			for (int i=liste_livre.indexOf(min)+1;i<liste_livre.size();i++){
				if (livre.getNbreExemplairesDispo()<liste_livre.get(i).getNbreExemplairesDispo()){
					Livre temp=liste_livre.get(i);
					liste_livre.set(i,livre);
					livre=temp;
				}
			}
		}
		return liste_livre;
	}
}
