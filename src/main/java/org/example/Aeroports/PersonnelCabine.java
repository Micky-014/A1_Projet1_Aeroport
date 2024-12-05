package org.example.Aeroports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonnelCabine extends Employe {    private int licence;
    private String qualification;
    private HashMap<Integer,Vol> volPersonnelCabine = new HashMap<>();
    public PersonnelCabine(String qualification, int numeroEmploye, String dateEmbauche, String prenom, String adresse, String contact) {
        super(numeroEmploye, dateEmbauche, prenom, adresse, contact);
        this.qualification = qualification;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public void affecterVol(Vol vol){
        List<PersonnelCabine> equipageCabine = vol.getEquipageCabine();
        equipageCabine.add(this);
        vol.setEquipageCabine(equipageCabine);
        volPersonnelCabine.put(vol.getNumeroVol(),vol);
    }
    public void obtenirVol(int NumeroVol){
        Vol vol = volPersonnelCabine.get(NumeroVol);
        vol.getInfos();
    }
}