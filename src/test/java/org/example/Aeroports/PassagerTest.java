package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void obtenirInfos() {
    }

    @Test
    void reserverVol() {
    }

    @Test
    void annulerReservation() {
    }

    @Test
    void confirmerReservation() {
    }

    @Test
    void obtenirReservation() {
    }
}