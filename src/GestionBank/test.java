package GestionBank;

public class test {
    public static void main(String[] args){
        CompteBancaire X=new CompteBancaire(20.0,"AITHSSAINE","simo");
        Personne Y= new Personne("ait hssaine","mohamed","rabat","0664398415","02-05-2004");
        Personne Z= new Personne("sbaiti","mohammed","rabat","0606929996","null");
        System.out.println(Z.getId());
    }
}