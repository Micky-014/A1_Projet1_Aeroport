package org.example.Aeroports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Reservation {
    static private int numRes = 0;
    private int numeroReservation;
    private LocalDate dateReservation;
    private String statut;
    private static HashMap<Integer,Reservation> listeReservations = new HashMap<Integer,Reservation>();
    private static HashMap<Reservation,Vol> resVol = new HashMap<Reservation,Vol>();
    private static ArrayList<Vol> reservations = new ArrayList<>();
    private static ArrayList<Reservation> listeAEcrire = new ArrayList<>();
    public Reservation() {
        this.numeroReservation = setNumeroReservation();
        setDateReservation();
        this.statut = "En attente de confirmation";
        listeReservations.put(numeroReservation, this);
        listeAEcrire.add(this);
    }
    public Reservation (int numeroReservation) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = LocalDate.of(2024,12,10);
        this.statut = "En attente de confirmation";
        listeReservations.put(numeroReservation, this);
    }
    public static ArrayList<Reservation> getListeAEcrire() {
        return listeAEcrire;
    }
    public int getNumeroReservation() {
        return numeroReservation;
    }
    public int setNumeroReservation() {
        return ++numRes;
    }
    public LocalDate getDateReservation() {
        return dateReservation;
    }
    public void setDateReservation() {
        this.dateReservation = LocalDate.now();
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    public void getVol(Vol vol){
        reservations.add(vol);
    }
    public void suprimerVol(Vol vol){
        reservations.remove(vol);
    }
    public Vol getResVol(){
        return resVol.get(this);
    }
    public void addResVol(Vol vol){
        resVol.put(this,vol);
    }
    public HashMap<Reservation,Vol> recupererResVol(){
        return resVol;
    }
    public void suprimerResVol(Vol vol){
        reservations.remove(vol);
    }
    public void getInfos(){
        Vol vol = getResVol();
        System.out.println("Numéro de réservation :"+ numeroReservation);
        System.out.println("Date reservation :"+ dateReservation);
        System.out.println("Statut :"+ statut);
        vol.getInfos();
    }
    public void annulerReservation(int numero) {
        listeReservations.get(numero).setStatut("Annulée");
    }
    public void confirmeReservation(int numero) {
        listeReservations.get(numero).setStatut("Confirmée");
    }
    public ArrayList<Vol> getReservations() {
        return reservations;
    }
}