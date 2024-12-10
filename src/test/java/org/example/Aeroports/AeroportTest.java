package org.example.Aeroports;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class AeroportTest {

    @org.junit.jupiter.api.Test
    void getNom() {
        Aeroport aeroport = new Aeroport("Charles-de-Gaulle","Roissy","International");
        assertEquals("Charles-de-Gaulle",aeroport.getNom());
    }

    @org.junit.jupiter.api.Test
    void setNom() {
        Aeroport aeroport = new Aeroport("Charles","Roissy","International");
        aeroport.setNom("Charles-de-Gaulle");
        assertEquals("Charles-de-Gaulle",aeroport.getNom());
    }

    @org.junit.jupiter.api.Test
    void getVille() {
        Aeroport aeroport = new Aeroport("Charles-de-Gaulle","Roissy","International");
        assertEquals("Roissy",aeroport.getVille());
    }

    @org.junit.jupiter.api.Test
    void setVille() {
        Aeroport aeroport = new Aeroport("Charles-de-Gaulle","Roissy","International");
        aeroport.setVille("Roissy-en-France");
        assertEquals("Roissy-en-France",aeroport.getVille());
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        Aeroport aeroport = new Aeroport("Charles-de-Gaulle","Roissy","International");
        assertEquals("International",aeroport.getDescription());
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
        Aeroport aeroport = new Aeroport("Charles-de-Gaulle","Roissy","International");
        aeroport.setDescription("Aéroport international");
        assertEquals("Aéroport international",aeroport.getDescription());
    }

    @org.junit.jupiter.api.Test
    void affecterVol() {
        Aeroport aeroport = new Aeroport("Charles-de-Gaulle","Roissy","International");
        Vol vol = new Vol(1,
                "Paris",
                "Saint-Pétersbourg",
                LocalDateTime.of(2024,12,23,10,25),
                LocalDateTime.of(2024,12,23,18,05));
        aeroport.affecterVol(vol);
        assertEquals(vols,)
    }
}