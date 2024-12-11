package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {

    @Test
    void getImmatriculation() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        assertEquals("A7050", avion.getImmatriculation());
    }

    @Test
    void setImmatriculation() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        avion.setImmatriculation("B7050");
        assertEquals("B7050", avion.getImmatriculation());
    }

    @Test
    void getModele() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        assertEquals("Boeing737", avion.getModele());
    }

    @Test
    void setModele() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        avion.setModele("Airbus A380");
        assertEquals("Airbus A380", avion.getModele());
    }

    @Test
    void getCapacite() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        assertEquals(220, avion.getCapacite());
    }

    @Test
    void setCapacite() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        avion.setCapacite(180);
        assertEquals(180, avion.getCapacite());
    }

    @Test
    void getVols() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        List<Vol> vols = new ArrayList<>();
        assertEquals(vols,avion.getVols());
    }

    @Test
    void affecterVol() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        Vol vol = new Vol(1,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        avion.affecterVol(vol);
        List<Vol> vols = new ArrayList<>();
        vols.add(vol);
        assertEquals(vols,avion.getVols());
    }

    @Test
    void verifierDisponibilite() {
        Avion avion = new Avion("A7050",
                "Boeing737",
                220);
        Vol vol1 = new Vol(1,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        avion.affecterVol(vol1);
        List<Vol> vols = new ArrayList<>();
        vols.add(vol1);
        Vol vol2 = new Vol(2,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,9,25),
                LocalDateTime.of(2024,12,23,19,05));
        avion.affecterVol(vol2);
        assertEquals(vols,avion.getVols());
        Vol vol3 = new Vol(2,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,11,25),
                LocalDateTime.of(2024,12,23,17,05));
        avion.affecterVol(vol3);
        assertEquals(vols,avion.getVols());
        Vol vol4 = new Vol(2,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,11,25),
                LocalDateTime.of(2024,12,23,19,05));
        avion.affecterVol(vol4);
        assertEquals(vols,avion.getVols());
        Vol vol5 = new Vol(2,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,2,25),
                LocalDateTime.of(2024,12,23,8,05));
        vols.add(vol5);
        avion.affecterVol(vol5);
        assertEquals(vols,avion.getVols());
    }
}