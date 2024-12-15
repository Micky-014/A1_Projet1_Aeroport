package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassagerTest {

    @Test
    void getPasseport() {
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        assertEquals("AB123456C",passager.getPasseport());
    }

    @Test
    void setPasseport() {
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        passager.setPasseport("DE789123F");
        assertEquals("DE789123F",passager.getPasseport());
    }
    @Test
    void getVolReserve(){
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        assert(passager.getVolReserve().isEmpty());
    }

    @Test
    void getListeResertation(){
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        assert(passager.getListeReservation().isEmpty());
    }

    @Test
    void reserverVol() {
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        passager.reserverVol(vol);
        HashMap<Integer,Vol> volReserve = new HashMap<>();
        volReserve.put(1256,vol);
        assertEquals(volReserve,passager.getVolReserve());
        assertEquals(passager.getVolReserve().isEmpty(),false);
    }

    @Test
    void annulerReservation() {
    }

    @Test
    void confirmerReservation() {
        Passager passager = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        passager.reserverVol(vol);
        passager.confirmerReservation(1);
        assertEquals("Confirmé",passager.obtenirReservation(1).getStatut());
    }
}