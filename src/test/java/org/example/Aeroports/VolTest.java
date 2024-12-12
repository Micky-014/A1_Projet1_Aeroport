package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalDate;
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
    void getListePasagers(){
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        assert(vol.getListePassagers().isEmpty());
    }

    @Test
    void addListePassagers() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        Passager passager1 = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        Passager passager2 = new Passager("DE789123F",
                "Alexis",
                "12 Rue de Vanves",
                "0600000000");
        List<Passager> listePassagers = new ArrayList<>();
        listePassagers.add(passager1);
        vol.addListePassagers(passager1);
        assertEquals(listePassagers, vol.getListePassagers());
        listePassagers.add(passager2);
        vol.addListePassagers(passager2);
        assertEquals(listePassagers, vol.getListePassagers());
    }

    @Test
    void addListeReservations() {
    }

    @Test
    void annulerVol() {
    }

    @Test
    void listingPassager() {
        Vol vol = new Vol(1256,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        Passager passager1 = new Passager("AB123456C",
                "Nastassia",
                "12 Rue de Vanves",
                "0600000000");
        Passager passager2 = new Passager("DE789123F",
                "Alexis",
                "12 Rue de Vanves",
                "0600000000");
        List<Passager> listePassagers = new ArrayList<>();
        listePassagers.add(passager1);
        vol.addListePassagers(passager1);
        listePassagers.add(passager2);
        vol.addListePassagers(passager2);
        assertEquals(listePassagers, vol.listingPassager());
    }

    @Test
    void planifierVol() {
        Vol vol1 = new Vol(1,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,1,23,10,25),
                LocalDateTime.of(2024,1,23,18,05));
        Vol vol2 = new Vol(2,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,1,23,10,25),
                LocalDateTime.of(2024,1,23,18,05));
        Vol vol3 = new Vol(3,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,2,24,10,25),
                LocalDateTime.of(2024,2,24,18,05));
        Vol vol4 = new Vol(4,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,2,24,10,25),
                LocalDateTime.of(2024,2,24,18,05));
        Vol vol5 = new Vol(5,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,3,25,10,25),
                LocalDateTime.of(2024,3,25,18,05));
        Vol vol6 = new Vol(6,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,2,24,10,25),
                LocalDateTime.of(2024,2,24,18,05));
        ArrayList<Vol> vols1 = new ArrayList<Vol>();
        ArrayList<Vol> vols2 = new ArrayList<Vol>();
        ArrayList<Vol> vols3 = new ArrayList<Vol>();
        vols1.add(vol1);
        vols1.add(vol2);
        vols2.add(vol3);
        vols2.add(vol4);
        vols3.add(vol5);
        vols2.add(vol6);
        assertEquals(vol1.planifierVol(LocalDate.of(2024,1,23)),vols1);
        assertEquals(vol2.planifierVol(LocalDate.of(2024,2,24)),vols2);
        assertEquals(vol3.planifierVol(LocalDate.of(2024,3,25)),vols3);

    }

    @Test
    void modifierVol() {
        Vol vol1 = new Vol(1,
                "Charles-de-Gaulle",
                "Rome",
                LocalDateTime.of(2024,1,23,10,25),
                LocalDateTime.of(2024,1,23,18,05));
        vol1.modifierVol(2,
                "Orly",
                "Héraklion",
                LocalDateTime.of(2024,2,23,10,25),
                LocalDateTime.of(2024,2,23,18,05),
                "En attente");
        assertEquals(vol1.getNumeroVol(),2);
        assertEquals(vol1.getOrigine(),"Orly");
        assertEquals(vol1.getDestination(),"Héraklion");
        assertEquals(vol1.getDateHeureDepart(),LocalDateTime.of(2024,2,23,10,25));
        assertEquals(vol1.getDateHeureArrivee(),LocalDateTime.of(2024,2,23,18,05));
        assertEquals(vol1.getEtat(),"En attente");
    }
}