package org.example.Aeroports;


import java.util.ArrayList;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;
    private ArrayList<Vol> vols = new ArrayList<>();
    public Aeroport (String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.vols = new ArrayList<Vol>();
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void affecterVol(Vol vol) {
        vols.add(vol);
    }
}