package org.example.Aeroports;

import java.util.ArrayList;
import java.util.List;

public class Employe extends Personne{
    static private int numEmploye=0;
    private int numeroEmploye;
    private String dateEmbauche;
    private static List<Employe> listEmployes = new ArrayList<Employe>();
    public Employe(int numeroEmploye, String dateEmbauche, String prenom, String adresse, String contact){
        super(prenom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
        listEmployes.add(this);
    }
    public int getNumeroEmploye() {
        return numeroEmploye;
    }
    public void setNumeroEmploye(int numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }
    public String getDateEmbauche() {
        return dateEmbauche;
    }
    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public void ObtenirInfos(){
        super.ObtenirInfos();
        System.out.println("Numéro Employé: " + numeroEmploye);
        System.out.println("Date Embauche: " + dateEmbauche);
        System.out.println("");
    }
    public void ObtenirRole(int iD){
        for (int i = 0; i < listEmployes.size(); i++){
            if (listEmployes.get(i).getNumeroEmploye()==iD){
                System.out.println("Role: "+listEmployes.get(i).getClass());
                break;
            }
        }
        System.out.println("");
    }
}
