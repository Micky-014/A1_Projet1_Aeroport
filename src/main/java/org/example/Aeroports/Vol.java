package org.example.Aeroports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class Vol {
    private int numeroVol;
    private String origine;
    private String destination;
    private LocalDateTime dateHeureDepart;
    private LocalDateTime dateHeureArrivee;
    private String etat;
    private Pilote pilote;
    private List<PersonnelCabine> equipageCabine = new ArrayList<>();
    private List<Passager> listePassagers = new ArrayList<>();
    private List<Reservation> listeReservation = new ArrayList<>();
    private static HashMap<Integer, Vol> reservations = new HashMap<>();
    private static List<Vol> listeVols= new LinkedList<>();
    public Vol(int numeroVol, String origine, String destination, LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "Prévu";
        reservations.put(numeroVol, this);
        listeVols.add(this);
    }
    public int getNumeroVol() {
        return numeroVol;
    }
    public String getOrigine() {
        return origine;
    }
    public String getDestination() {
        return destination;
    }
    public LocalDateTime getDateHeureDepart() {
        return dateHeureDepart;
    }
    public LocalDateTime getDateHeureArrivee() {
        return dateHeureArrivee;
    }
    public String getEtat() {
        return etat;
    }
    public Pilote getPilote() {
        return pilote;
    }
    public List<PersonnelCabine> getEquipageCabine() {
        return equipageCabine;
    }
    public List<Passager> getListePassagers() {
        return listePassagers;
    }
    public List<Reservation> getListeReservation() {
        return listeReservation;
    }
    public void setNumeroVol(int numeroVol) {
        this.numeroVol = numeroVol;
    }
    public void setOrigine(String origine) {
        this.origine = origine;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDateHeureDepart(LocalDateTime dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }
    public void setDateHeureArrivee(LocalDateTime dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }
    public void setEquipageCabine(List<PersonnelCabine> equipageCabine) {
        this.equipageCabine = equipageCabine;
    }
    public void addListePassagers(Passager passager) {
        listePassagers.add(passager);
    }
    public void addListeReservations(Reservation reservation) {
        listeReservation.add(reservation);
    }

    public void getInfos(){
        System.out.println("Numero vol: " + numeroVol);
        System.out.println("Origine: " + origine);
        System.out.println("Destination: " + destination);
        System.out.println("Date heure depart: " + dateHeureDepart);
        System.out.println("Date heure arrivee: " + dateHeureArrivee);
        System.out.println("Etat: " + etat);
        System.out.println("Pilote: " + pilote);
        System.out.println("Equipage cabine: " + equipageCabine);
        System.out.println("");
    }
    public void annulerVol(int idVol){
        Vol vol = reservations.get(idVol);
        vol.setEtat("Annulé");
        for (int i=0; i<listeReservation.size(); i++){
            Reservation reservation = listeReservation.get(i);
            Passager passager = listePassagers.get(i);
            passager.annulerReservation(reservation.getNumeroReservation());
        }
    }
    public List<Passager> listingPassager(){
        ArrayList<Passager> passagers = new ArrayList<Passager>();
        for(int i=0; i<listePassagers.size(); i++){
            Passager passager = listePassagers.get(i);
            System.out.println("Prenom :"+passager.getPrenom()+" / ID :"+passager.getID());
            passagers.add(passager);
        }
        System.out.println("");
        return passagers;
    }
    public List<Vol> planifierVol(LocalDate jour){
        System.out.println("Les vols prévu pour le "+jour.toString()+" sont les suivants:");
        ArrayList<Vol> vols = new ArrayList<Vol>();
        for (int i=0; i<listeVols.size(); i++){
            Vol vol = listeVols.get(i);
            if (vol.getDateHeureDepart().toLocalDate().equals(jour)){
                System.out.println("ID de vol : "+vol.getNumeroVol());
                vols.add(vol);
            }
        }
        System.out.println("");
        return vols;
    }
    public void modifierVol(int numeroVol, String origine, String destination, LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee, String etat){
        this.setNumeroVol(numeroVol);
        this.setOrigine(origine);
        this.setDestination(destination);
        this.setDateHeureDepart(dateHeureDepart);
        this.setDateHeureArrivee(dateHeureArrivee);
        this.setEtat(etat);
    }
}


