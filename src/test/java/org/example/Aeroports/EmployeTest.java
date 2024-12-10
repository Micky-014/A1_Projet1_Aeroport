package org.example.Aeroports;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void getNumeroEmploye() {
        Employe employe = new Employe(12,
                "15/10/2020",
                "Micky",
                "10 rue de Vanves",
                "0600000000");
        assertEquals(12, employe.getNumeroEmploye());
    }

    @Test
    void setNumeroEmploye() {
        Employe employe = new Employe(12,
                "15/10/2020",
                "Micky",
                "10 rue de Vanves",
                "0600000000");
        employe.setNumeroEmploye(18);
        assertEquals(18, employe.getNumeroEmploye());
    }

    @Test
    void getDateEmbauche() {
        Employe employe = new Employe(12,
                "15/10/2020",
                "Micky",
                "10 rue de Vanves",
                "0600000000");
        assertEquals("15/10/2020", employe.getDateEmbauche());
    }

    @Test
    void setDateEmbauche() {
        Employe employe = new Employe(12,
                "15/10/2020",
                "Micky",
                "10 rue de Vanves",
                "0600000000");
        employe.setDateEmbauche("12/10/2020");
        assertEquals("12/10/2020", employe.getDateEmbauche());
    }


    @Test
    void obtenirRole() {
        Employe employe = new Employe(12,
            "15/10/2020",
            "Micky",
            "10 rue de Vanves",
            "0600000000");
        assertEquals(Employe.class, employe.getClass());
    }
}