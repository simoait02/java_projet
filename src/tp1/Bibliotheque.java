package tp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bibliotheque {
	private List livres = new ArrayList<>();
	private List adherents = new ArrayList<>();
	private List emprunts = new ArrayList<>();

	public Bibliotheque() {
	}

	public Adherent rechercherAdherent(int codeAd) {
		for(int i=0;i<this.adherents.size();i++) {
			if( ((Adherent) adherents.get(i)).getCodeAdherent()==codeAd) {
				return (Adherent) this.adherents.get(i);
			}
		}
		return null;
	}

	public Livre rechercherLivre(int codeL){
		for(int i=0;i<this.livres.size();i++) {
			if(((Livre)this.livres.get(i)).getCodeLivre()==codeL) {
				return (Livre) this.livres.get(i);
			}
		}
		return null;
	}

	public void ajouterLivre(int codeL, String titreL, Auteur auteurL, int nbreExemplaires) {
		Livre l=this.rechercherLivre(codeL);
		if(l!=null) {
			l.setNbreExemplaires(l.getNbreExemplaires()+nbreExemplaires);
			l.setNbreExemplairesDispo(l.getNbreExemplairesDispo()+nbreExemplaires);
		}
		else {
			l = new Livre(codeL, titreL, auteurL, nbreExemplaires, nbreExemplaires);
			this.livres.add(l);
		}
	}

	public void ajouterAdherent(String nom, String prenom) {
		Adherent adherent = new Adherent(nom, prenom);
		this.livres.add(adherent);
		//possible de contôler l'ajout ; unicité de la clé (nom,prénom)
	}


	public void ajouterEmprunt(int codeA, int codeL){
		Livre livre = this.rechercherLivre(codeL);
		if(livre!=null && livre.LivreDisponible()) {
			Adherent adherent = this.rechercherAdherent(codeA);
			if(adherent!=null) {
				Date dateEmprunt= new Date();
				Date dateRetourPrevue = new Date();
				dateRetourPrevue.setDate(dateEmprunt.getDate()+3);
				Emprunt emprunt = new Emprunt(livre, adherent,dateEmprunt,dateRetourPrevue);
				emprunt.getLivre().setNbreExemplairesDispo(emprunt.getLivre().getNbreExemplairesDispo()-1);
				//possible de decrémenter le nombre d'exemplaires disponibles à l'instanciation ou une méthode dédiée (Livre, Emprunt??) Discussion sur l'affectation des responsabilités
				this.emprunts.add(emprunt);
			}
		}
	}

	public void retourLivre(int codeE) {
		if(codeE<=this.emprunts.size()+1 && codeE>0) {
			Emprunt emprunt= (Emprunt) this.emprunts.get(codeE-1);
			emprunt.retourEmprunt();
		}
	}
	public String DetailsEmprunt(int codeE) {
		if(codeE<=this.emprunts.size()+1 && codeE>0) {
			return this.emprunts.get(codeE-1).toString();
		}
		return "Aucun Emprunt";
	}
}
