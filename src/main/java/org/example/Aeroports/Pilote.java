package org.example.Aeroports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pilote extends Employe {
    private int licence;
    private int heureDeVol;
    private HashMap<Integer,Vol> volPilote = new HashMap<>();
    public Pilote(int licence, int heureDeVol, int numeroEmploye, String dateEmbauche, String prenom, String adresse, String contact) {
        super(numeroEmploye, dateEmbauche, prenom, adresse, contact);
        this.licence = licence;
        this.heureDeVol = heureDeVol;
    }
    public int getLicence() {
        return licence;
    }
    public void setLicence(int licence) {
        this.licence = licence;
    }
    public int getHeureDeVol() {
        return heureDeVol;
    }
    public void setHeureDeVol(int heureDeVol) {
        this.heureDeVol = heureDeVol;
    }
    public void affecterVol(Vol vol){
        vol.setPilote(this);
        volPilote.put(vol.getNumeroVol(),vol);
    }
    public void obtenirVol(int NumeroVol){
        Vol vol = volPilote.get(NumeroVol);
        vol.getInfos();
    }
}
