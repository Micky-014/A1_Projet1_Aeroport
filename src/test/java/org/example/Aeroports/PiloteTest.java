package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PiloteTest {

    @Test
    void getLicence() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        assertEquals(3,pilote.getLicence());
    }

    @Test
    void setLicence() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        pilote.setLicence(5);
        assertEquals(5,pilote.getLicence());
    }

    @Test
    void getHeureDeVol() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        assertEquals(1200,pilote.getHeureDeVol());
    }

    @Test
    void setHeureDeVol() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        pilote.setHeureDeVol(2000);
        assertEquals(2000,pilote.getHeureDeVol());
    }

    @Test
    void obtenirVols() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        HashMap<Integer,Vol> volPilote = new HashMap<>();
        assertEquals(volPilote,pilote.obtenirVols());
    }

    @Test
    void affecterVol() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        Vol vol = new Vol(1,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        pilote.affecterVol(vol);
        HashMap<Integer,Vol> volPilote = new HashMap<>();
        volPilote.put(1,vol);
        assertEquals(volPilote,pilote.obtenirVols());
    }

    @Test
    void obtenirVol() {
        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        Vol vol1 = new Vol(1,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        Vol vol2 = new Vol(2,
                "Paris",
                "Shanghai",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        pilote.affecterVol(vol1);
        pilote.affecterVol(vol2);
        assertEquals(vol2,pilote.obtenirVol(2));
        assertEquals(vol1,pilote.obtenirVol(1));
    }
}