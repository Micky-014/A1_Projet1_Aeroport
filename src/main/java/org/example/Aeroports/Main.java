package org.example.Aeroports;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Personne personne = new Personne("Micky", "Paris", "0611111111");
        personne.ObtenirInfos();
        Passager passager = new Passager("Français",personne.getPrenom(), personne.getAdresse(), personne.getContact());

        Pilote pilote = new Pilote( 1,  5000,1,"12/05/2004", "Theotim", "Paris", "0622222222");
        pilote.ObtenirInfos();
        pilote.ObtenirRole(1);


        PersonnelCabine personnelCabine = new PersonnelCabine("Hotesse",2,"15/10/2015","Carine","Paris", "0633333333");
        personnelCabine.ObtenirInfos();
        personnelCabine.ObtenirRole(2);
        Vol vol = new Vol(1,"Paris","Shanghai",LocalDateTime.of(2024,12,3,14,30),LocalDateTime.of(2024,12,3,17,45));
        passager.reserverVol(vol);

        passager.obtenirReservation(1);
        Reservation reservation = passager.obtenirReservation(1);
        reservation.confirmeReservation(1);
        System.out.println("");
        System.out.println(reservation.getStatut());
        System.out.println("");
        passager.annulerReservation(1);
        System.out.println(reservation.getStatut());
        System.out.println("");

        personnelCabine.affecterVol(vol);
        personnelCabine.obtenirVol(vol.getNumeroVol());
        pilote.affecterVol(vol);

        pilote.obtenirVol(vol.getNumeroVol());
        vol.getEquipageCabine();
        vol.getPilote();

        vol.listingPassager();

        Avion avion = new Avion("A7050","Boeing737",220);
        avion.affecterVol(vol);

        Vol vol2 = new Vol(2,"Paris","Shanghai",LocalDateTime.of(2024,12,3,13,30),LocalDateTime.of(2024,12,3,18,45));
        avion.affecterVol(vol2);
        passager.reserverVol(vol2);
        passager.obtenirReservation(2);

        vol2.annulerVol(2);
        vol2.getInfos();


    }
}