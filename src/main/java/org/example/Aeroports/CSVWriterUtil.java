package org.example.Aeroports;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class CSVWriterUtil {

    public static void writeReservations(String filePath, ArrayList<Reservation> reservations) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            // En-tête
            writer.append("NumeroReservation,DateReservation,Statut,NumeroVol\n");
            for (Reservation reservation : reservations) {
                Vol vol = reservation.getResVol();
                writer.append(reservation.getNumeroReservation() + ",")
                        .append(reservation.getDateReservation() + ",")
                        .append(reservation.getStatut() + ",")
                        .append((vol != null ? vol.getNumeroVol() : "Non assigné") + "\n");
            }
        }
    }

    public static void writeVols(String filePath) throws IOException {
        List<String> villes = Arrays.asList("Paris", "Londres", "New York", "Tokyo", "Berlin", "Rome", "Madrid", "Lisbonne", "Dubai", "Singapour");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("NumeroVol,Origine,Destination,DateHeureDepart,DateHeureArrivee,Etat\n");
            for (int i = 1; i <= 10; i++) {
                writer.append(i + ",")
                        .append(villes.get(i % villes.size()) + ",")
                        .append(villes.get((i + 2) % villes.size()) + ",")
                        .append(LocalDateTime.now().plusDays(i).withNano(0) + ",") // Tronquer les nanosecondes
                        .append(LocalDateTime.now().plusDays(i).plusHours(2).withNano(0) + ",") // Tronquer les nanosecondes
                        .append("Prévu\n");
            }
        }
    }

    public static void writePassagers(String filePath) throws IOException {
        List<String> prenoms = Arrays.asList("Alice", "Bob", "Claire", "David", "Emma", "Frank", "Grace", "Hugo", "Isabelle", "Jack");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Prenom,Adresse,Contact,Passeport\n");
            for (int i = 1; i <= 10; i++) {
                writer.append(i + ",")
                        .append(prenoms.get(i - 1) + ",")
                        .append("Adresse" + i + ",")
                        .append("06" + (10000000 + i) + ",")
                        .append("P" + (1000 + i) + "\n");
            }
        }
    }

    public static void writePilotes(String filePath) throws IOException {
        List<String> prenoms = Arrays.asList("Paul", "Sophie", "Leo", "Charlotte", "Lucas", "Marie", "Nathan", "Camille", "Ethan", "Julie");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Prenom,Adresse,Contact,NumeroEmploye,DateEmbauche,HeuresDeVol\n");
            for (int i = 1; i <= 10; i++) {
                writer.append(i + ",")
                        .append(prenoms.get(i - 1) + ",")
                        .append("AdressePilote" + i + ",")
                        .append("06" + (20000000 + i) + ",")
                        .append((100 + i) + ",")
                        .append("2020-01-" + (10 + i) + ",")
                        .append((500 + i * 10) + "\n");
            }
        }
    }

    public static void writeAvions(String filePath) throws IOException {
        List<String> modeles = Arrays.asList("Boeing 737", "Airbus A320", "Embraer 190", "Boeing 777", "Airbus A380");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Immatriculation,Modele,Capacite\n");
            for (int i = 1; i <= 10; i++) {
                writer.append("F-AV" + i + ",")
                        .append(modeles.get(i % modeles.size()) + ",")
                        .append((150 + i * 10) + "\n");
            }
        }
    }

    public static void writeAeroports(String filePath) throws IOException {
        List<String> noms = Arrays.asList("Charles de Gaulle", "Heathrow", "JFK", "Narita", "Berlin Brandenburg", "Fiumicino", "Barajas", "Humberto Delgado", "DXB", "Changi");
        List<String> villes = Arrays.asList("Paris", "Londres", "New York", "Tokyo", "Berlin", "Rome", "Madrid", "Lisbonne", "Dubai", "Singapour");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Nom,Ville,Description\n");
            for (int i = 0; i < 10; i++) {
                writer.append(noms.get(i) + ",")
                        .append(villes.get(i) + ",")
                        .append("Aéroport international situé à " + villes.get(i) + "\n");
            }
        }
    }
}