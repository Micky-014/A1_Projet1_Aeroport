package org.example.Aeroports;

import java.util.HashMap;

public class Passager extends Personne{
    private String passeport;
    private HashMap<Integer,Vol> volReserve;
    private HashMap<Integer,Reservation> listeReservation;
    public Passager(String passeport, String prenom, String adresse, String contact){
        super(prenom, adresse, contact);
        this.passeport = passeport;
        this.volReserve = new HashMap<>();
        this.listeReservation = new HashMap<>();
    }
    public String getPasseport() {
        return passeport;
    }
    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }
    public void ObtenirInfos(){
        super.ObtenirInfos();
        System.out.println("Passeport: " + passeport);
        System.out.println("");
    }
    public void reserverVol(Vol vol){
        volReserve.put(vol.getNumeroVol(),vol);
        Reservation reservation = new Reservation();
        listeReservation.put(reservation.getNumeroReservation(),reservation);
        reservation.getVol(vol);
        reservation.addResVol(vol);
        vol.addListeReservations(reservation);
        vol.addListePassagers(this);
    }
    public void annulerReservation(int idRes){
        Reservation reservation = listeReservation.get(idRes);
        listeReservation.remove(idRes);
        Vol vol =reservation.getResVol();
        volReserve.remove(vol.getNumeroVol());
        reservation.suprimerResVol(vol);
        reservation.suprimerVol(vol);
        reservation.annulerReservation(idRes);
    }
    public void confirmerReservation(int idRes){
        Reservation reservation = listeReservation.get(idRes);
        reservation.setStatut("Annulée");
    }
    public Reservation obtenirReservation(int idRes){
        System.out.println(listeReservation.toString());
        Reservation reservation = listeReservation.get(idRes);
        reservation.getInfos();
        return reservation;
    }
}
