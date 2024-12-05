package org.example.Aeroports;


import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;
    private List<LocalDateTime> heureDepart = new ArrayList<>();
    private List<LocalDateTime> heureArrive = new ArrayList<>();
    private List<Vol> vols = new ArrayList<>();
    public Avion(String immatriculation, String modele, int capacite){
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        this.heureDepart = new ArrayList<>();
        this.heureArrive = new ArrayList<>();
        this.vols = new ArrayList<>();
    }
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public boolean verifierDisponibilite(LocalDateTime depart, LocalDateTime arrive){
        for (int i=0; i<heureDepart.size(); i++) {
            if (((depart.isAfter(heureDepart.get(i))) && (depart.isBefore(heureArrive.get(i)))) || ((arrive.isAfter(heureDepart.get(i))) && (arrive.isBefore(heureArrive.get(i))))) {
                return false;
            }
            if (depart.isBefore(heureDepart.get(i)) && arrive.isAfter(heureArrive.get(i))) {
                return false;
            }
        }
        return true;
    }
    public void affecterVol(Vol vol){
        LocalDateTime depart = vol.getDateHeureDepart();
        LocalDateTime arrivee = vol.getDateHeureArrivee();
        if (verifierDisponibilite(depart, arrivee)==true){
            vols.add(vol);
        }
        else{
            System.out.println("L'avion n'est pas disponibke sur ces horaires");
            System.out.println("");
        }
    }
}