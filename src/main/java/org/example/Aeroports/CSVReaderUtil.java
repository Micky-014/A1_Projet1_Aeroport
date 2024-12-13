package org.example.Aeroports;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {


    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    // Lire les données des vols
    public static List<Vol> readVols(String filePath) throws IOException {
        List<Vol> vols = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Lire l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                int numeroVol = Integer.parseInt(columns[0]);
                String origine = columns[1];
                String destination = columns[2];
                LocalDateTime dateHeureDepart = LocalDateTime.parse(columns[3], dateTimeFormatter);
                LocalDateTime dateHeureArrivee = LocalDateTime.parse(columns[4], dateTimeFormatter);
                String etat = columns[5];

                Vol vol = new Vol(numeroVol, origine, destination, dateHeureDepart, dateHeureArrivee);
                vol.setEtat(etat);
                vols.add(vol);
            }
        }
        return vols;
    }


    // Lire les données des passagers
    public static List<Passager> readPassagers(String filePath) throws IOException {
        List<Passager> passagers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Lire l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0]);
                String prenom = columns[1];
                String adresse = columns[2];
                String contact = columns[3];
                String passeport = columns[4];

                Passager passager = new Passager(passeport, prenom, adresse, contact);
                passagers.add(passager);
            }
        }
        return passagers;
    }

    // Lire les données des pilotes
    public static List<Pilote> readPilotes(String filePath) throws IOException {
        List<Pilote> pilotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Lire l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0]);
                String prenom = columns[1];
                String adresse = columns[2];
                String contact = columns[3];
                int numeroEmploye = Integer.parseInt(columns[4]);
                String dateEmbauche = columns[5];
                int heuresDeVol = Integer.parseInt(columns[6]);

                Pilote pilote = new Pilote(id, heuresDeVol, numeroEmploye, dateEmbauche, prenom, adresse, contact);
                pilotes.add(pilote);
            }
        }
        return pilotes;
    }

    // Lire les données des avions
    public static List<Avion> readAvions(String filePath) throws IOException {
        List<Avion> avions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Lire l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                String immatriculation = columns[0];
                String modele = columns[1];
                int capacite = Integer.parseInt(columns[2]);

                Avion avion = new Avion(immatriculation, modele, capacite);
                avions.add(avion);
            }
        }
        return avions;
    }

    // Lire les données des aéroports
    public static List<Aeroport> readAeroports(String filePath) throws IOException {
        List<Aeroport> aeroports = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Lire l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                String nom = columns[0];
                String ville = columns[1];
                String description = columns[2];

                Aeroport aeroport = new Aeroport(nom, ville, description);
                aeroports.add(aeroport);
            }
        }
        return aeroports;
    }
}