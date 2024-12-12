package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void getNumeroReservation() {
        Reservation reservation = new Reservation(1);
        assertEquals(1, reservation.getNumeroReservation());
    }
    @Test
    void getDateReservation() {
        Reservation reservation = new Reservation(1);
        assertEquals(LocalDate.of(2024,12,10), reservation.getDateReservation());
    }

    @Test
    void setDateReservation() {
        Reservation reservation = new Reservation(1);
        reservation.setDateReservation();
        assertEquals(LocalDate.now(), reservation.getDateReservation());
    }

    @Test
    void getStatut() {
        Reservation reservation = new Reservation(1);
        assertEquals("En attente de confirmation", reservation.getStatut());
    }

    @Test
    void setStatut() {
        Reservation reservation = new Reservation(1);
        reservation.setStatut("Ca fonctionne?");
        assertEquals("Ca fonctionne?", reservation.getStatut());
    }

    @Test
    void getVol_suprVol() {
        Reservation reservation = new Reservation(1);
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        reservation.getVol(vol);
        ArrayList<Vol> vols = new ArrayList<>();
        vols.add(vol);
        assertEquals(vols,reservation.getReservations());
        assertEquals(reservation.getReservations().isEmpty(),false);
        reservation.suprimerVol(vol);
        assert(reservation.getReservations().isEmpty());
    }

    @Test
    void getResVol() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        passager.reserverVol(vol);
        Reservation reservation = passager.obtenirReservation(1);
        assertEquals(reservation.getResVol(),vol);
    }

    @Test
    void addResVol() {
        Reservation reservation = new Reservation(20);
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        reservation.addResVol(vol);
        assertEquals(reservation.getResVol(),vol);
    }

    @Test
    void suprimerResVol() {
        Reservation reservation = new Reservation(25);
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        reservation.getVol(vol);
        assertEquals(reservation.getReservations().isEmpty(),false);
        reservation.suprimerResVol(vol);
    }

    @Test
    void annulerReservation() {
        Reservation reservation = new Reservation(30);
        assertEquals(reservation.getStatut(),"En attente de confirmation");
        reservation.annulerReservation(30);
        assertEquals(reservation.getStatut(),"Annulée");
    }

    @Test
    void confirmeReservation() {
        Reservation reservation = new Reservation(30);
        assertEquals(reservation.getStatut(),"En attente de confirmation");
        reservation.confirmeReservation(30);
        assertEquals(reservation.getStatut(),"Confirmée");
    }
}