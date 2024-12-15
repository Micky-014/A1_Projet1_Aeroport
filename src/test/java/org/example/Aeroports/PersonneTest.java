package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void getPrenom() {
        Personne personne = new Personne("Micky", "10 rue de Vanves","0600000000");
        assertEquals("Micky", personne.getPrenom());
    }

    @Test
    void setPrenom() {
        Personne personne = new Personne("Micky", "10 rue de Vanves","0600000000");
        personne.setPrenom("Theotim");
        assertEquals("Theotim", personne.getPrenom());
    }

    @Test
    void getAdresse() {
        Personne personne = new Personne("Micky", "10 rue de Vanves","0600000000");
        assertEquals("10 rue de Vanves", personne.getAdresse());
    }

    @Test
    void setAdresse() {
        Personne personne = new Personne("Micky", "10 rue de Vanves","0600000000");
        personne.setAdresse("12 rue de Vanves");
        assertEquals("12 rue de Vanves", personne.getAdresse());
    }

    @Test
    void getContact() {
        Personne personne = new Personne("Micky", "10 rue de Vanves","0600000000");
        assertEquals("0600000000", personne.getContact());
    }
    @Test
    void setContact() {
        Personne personne = new Personne("Micky", "10 rue de Vanves","0600000000");
        personne.setContact("0600000001");
        assertEquals("0600000001", personne.getContact());
    }
}