package GestionBank;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class CompteBancaire {
    private static Set<Integer> listCode=new HashSet<>();
    private static HashMap<String, String> table =new HashMap<String, String>();
    private static String numCompte;
    private double solde;
    private String nomTitulaire;
    private String prenomTitulaire;
    public CompteBancaire(double solde, String nomTitulaire, String prenomTitulaire) {
        numCompte = set_numCompte();
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
        this.prenomTitulaire = prenomTitulaire;
    }
    public static String getNumCompte() {return numCompte;}
    public double getSolde() {return solde;}
    public String getNomTitulaire() {return nomTitulaire;}
    public String getPrenomTitulaire() {return prenomTitulaire;}
    public void setSolde(double solde) {this.solde = solde;}
    public void setNomTitulaire(String nomTitulaire) {this.nomTitulaire = nomTitulaire;}
    public void setPrenomTitulaire(String prenomTitulaire) {this.prenomTitulaire = prenomTitulaire;}
    public double decouvrirMontant(){
        return (this.solde<0) ? -this.solde:0;
    }
    public String ajouterMontant(double montant){
        this.solde+=montant;
        return "L'opération s'est terminée avec succès";
    }
    public String retraitMontant(double montant){
        this.solde-=montant;
        return "L'opération s'est terminée avec succès";
    }
    static String set_numCompte(){
        String x="";
        ArrayList<String> array=new ArrayList<>();
        array.add("0");array.add("1");array.add("2");array.add("3");array.add("4");array.add("5");array.add("6");array.add("7");array.add("8");array.add("9");
        do {
            while (x.length() < 10) {
                x += array.get((int) (Math.random() * 10));
            }
        }
        while (listCode.contains(x));
        return x;
    }
    static void addToTable(Personne p){
        table.put(p.getId(),CompteBancaire.getNumCompte());}
}
