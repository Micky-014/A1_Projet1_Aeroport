package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonnelCabineTest {

    @Test
    void getQualification() {
        PersonnelCabine stewart = new PersonnelCabine("Stewart",
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        assertEquals("Stewart",stewart.getQualification());
    }

    @Test
    void setQualification() {
        PersonnelCabine stewart = new PersonnelCabine("Stewart",
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        stewart.setQualification("Cuisinier");
        assertEquals("Cuisinier",stewart.getQualification());
    }

    @Test
    void obtenirVols(){
        PersonnelCabine stewart = new PersonnelCabine("Stewart",
                2,
                "12/10/2020",
                "Theotim",
                "10 rue de Vanves",
                "0600000000");
        stewart.setQualification("Cuisinier");
        assertEquals("Cuisinier",stewart.getQualification());
        HashMap<Integer,Vol> volPersonnelCabine = new HashMap<>();
        assertEquals(volPersonnelCabine,stewart.obtenirVols());
    }

    @Test
    void affecterVol() {
        PersonnelCabine stewart = new PersonnelCabine("Stewart",
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
        stewart.affecterVol(vol);
        HashMap<Integer,Vol> volPersonnelCabine = new HashMap<>();
        volPersonnelCabine.put(1,vol);
        assertEquals(volPersonnelCabine,stewart.obtenirVols());
    }

    @Test
    void obtenirVol() {
        PersonnelCabine stewart = new PersonnelCabine("Stewart",
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
        stewart.affecterVol(vol1);
        stewart.affecterVol(vol2);
        assertEquals(vol2,stewart.obtenirVol(2));
        assertEquals(vol1,stewart.obtenirVol(1));
    }
}