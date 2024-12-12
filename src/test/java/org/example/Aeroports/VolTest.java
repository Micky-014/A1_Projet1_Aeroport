package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VolTest {

    @Test
    void getNumeroVol() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertEquals(1256, vol.getNumeroVol());
    }

    @Test
    void getOrigine() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertEquals("Charles-de-Gaulle", vol.getOrigine());
    }

    @Test
    void getDestination() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertEquals("Rome", vol.getDestination());
    }

    @Test
    void getDateHeureDepart() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertEquals(LocalDateTime.of(2024,12,23,10,25), vol.getDateHeureDepart());
    }

    @Test
    void getDateHeureArrivee() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertEquals(LocalDateTime.of(2024,12,23,18,05), vol.getDateHeureArrivee());
    }

    @Test
    void getEtat() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertEquals("Prévu", vol.getEtat());
    }

    @Test
    void getPilote() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assertNull(vol.getPilote());

        Pilote pilote = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        pilote.affecterVol(vol);
        assertEquals(vol.getPilote(), pilote);
    }

    @Test
    void getEquipageCabine() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assert(vol.getEquipageCabine().isEmpty());

        PersonnelCabine stewart = new PersonnelCabine("Stewart",
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        List<PersonnelCabine> equipageCabine = new ArrayList<>();
        equipageCabine.add(stewart);
        stewart.affecterVol(vol);
        assertEquals(vol.getEquipageCabine(), equipageCabine);
    }

    @Test
    void setNumeroVol() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        vol.setNumeroVol(5085);
        assertEquals(5085, vol.getNumeroVol());
    }

    @Test
    void setOrigine() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        vol.setOrigine("Orly");
        assertEquals("Orly", vol.getOrigine());
    }

    @Test
    void setDestination() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        vol.setDestination("Naples");
        assertEquals("Naples", vol.getDestination());
    }

    @Test
    void setDateHeureDepart() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        vol.setDateHeureDepart(LocalDateTime.of(2024,1,12,10,25));
        assertEquals(LocalDateTime.of(2024,1,12,10,25), vol.getDateHeureDepart());
    }

    @Test
    void setDateHeureArrivee() {
        Vol vol = new Vol(1256,
            "Charles-de-Gaulle",
            "Rome",
            LocalDateTime.of(2024,12,23,10,25),
            LocalDateTime.of(2024,12,23,18,05));
        vol.setDateHeureArrivee(LocalDateTime.of(2024,1,12,10,25));
        assertEquals(LocalDateTime.of(2024,1,12,10,25), vol.getDateHeureArrivee());
    }

    @Test
    void setEtat() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        vol.setEtat("Retardé");
        assertEquals("Retardé", vol.getEtat());
    }

    @Test
    void setPilote() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        Pilote pilote1 = new Pilote(3,
                1200,
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        Pilote pilote2 = new Pilote(3,
                1200,
                3,
                "12/10/2020",
                "Micky",
                "10 rue de Vanves",
                "0600000000");
        vol.setPilote(pilote1);
        assertEquals(pilote1, vol.getPilote());
        vol.setPilote(pilote2);
        assertEquals(pilote2, vol.getPilote());
    }

    @Test
    void setEquipageCabine() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        PersonnelCabine stewart = new PersonnelCabine("Stewart",
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        PersonnelCabine cuisinier = new PersonnelCabine("Cuisinier",
                3,
                "12/10/2020",
                "Victor",
                "10 rue de Vanves",
                "0600000000");
        assert(vol.getEquipageCabine().isEmpty());
        List<PersonnelCabine> equipageCabine = new ArrayList<>();
        equipageCabine.add(stewart);
        stewart.affecterVol(vol);
        assertEquals(equipageCabine, vol.getEquipageCabine());
        equipageCabine.add(cuisinier);
        cuisinier.affecterVol(vol);
        assertEquals(equipageCabine, vol.getEquipageCabine());
    }

    @Test
    void addListePassagers() {
    }

    @Test
    void addListeReservations() {
    }

    @Test
    void annulerVol() {
    }

    @Test
    void listingPassager() {
    }

    @Test
    void planifierVol() {
    }

    @Test
    void modifierVol() {
    }
}