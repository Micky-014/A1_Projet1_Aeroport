package org.example.Aeroports;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Personne personne = new Personne("Micky", "Paris", "0611111111");
        personne.ObtenirInfos();
        Passager passager = new Passager("Français",personne.getPrenom(), personne.getAdresse(), personne.getContact());

        Pilote pilote = new Pilote( 1,  5000,1,"12/05/2004", "Theotim", "Paris", "0622222222");
        pilote.ObtenirInfos();
        pilote.ObtenirRole(1);


        PersonnelCabine personnelCabine = new PersonnelCabine("Hotesse",2,"15/10/2015","Carine","Paris", "0633333333");
        personnelCabine.ObtenirInfos();
        personnelCabine.ObtenirRole(2);
        Vol vol = new Vol(1,"Paris","Shanghai",LocalDateTime.of(2024,12,3,14,30),LocalDateTime.of(2024,12,3,17,45));
        passager.reserverVol(vol);

        passager.obtenirReservation(1);
        Reservation reservation = passager.obtenirReservation(1);
        reservation.confirmeReservation(1);
        System.out.println("");
        System.out.println(reservation.getStatut());
        System.out.println("");
        passager.annulerReservation(1);
        System.out.println(reservation.getStatut());
        System.out.println("");

        personnelCabine.affecterVol(vol);
        personnelCabine.obtenirVol(vol.getNumeroVol());
        pilote.affecterVol(vol);

        pilote.obtenirVol(vol.getNumeroVol());
        vol.getEquipageCabine();
        vol.getPilote();

        vol.listingPassager();

        Avion avion = new Avion("A7050","Boeing737",220);
        avion.affecterVol(vol);

        Vol vol2 = new Vol(2,"Paris","Shanghai",LocalDateTime.of(2024,12,3,13,30),LocalDateTime.of(2024,12,3,18,45));
        avion.affecterVol(vol2);
        passager.reserverVol(vol2);
        passager.obtenirReservation(2);

        vol2.annulerVol(2);
        vol2.getInfos();
        Passager passager1 = new Passager("AB123456", "Jean Dupont", "Paris", "0612345678");
        Passager passager2 = new Passager("CD789012", "Claire Martin", "Lyon", "0623456789");
        Passager passager3 = new Passager("EF345678", "Alice Durand", "Marseille", "0634567890");
        Passager passager4 = new Passager("GH901234", "Bob Leroy", "Nice", "0645678901");

        passager1.ObtenirInfos();
        passager2.ObtenirInfos();
        passager3.ObtenirInfos();
        passager4.ObtenirInfos();


        passager1.reserverVol(vol2);
        passager2.reserverVol(vol2);
        passager3.reserverVol(vol2);
        passager4.reserverVol(vol2);
        System.out.println(Reservation.getListeAEcrire());
        try {
            CSVWriterUtil.writeVols("vols.csv");
            CSVWriterUtil.writePassagers("passagers.csv");
            CSVWriterUtil.writePilotes("pilotes.csv");
            CSVWriterUtil.writeAvions("avions.csv");
            CSVWriterUtil.writeAeroports("aeroports.csv");
            CSVWriterUtil.writeReservations("reservations.csv",Reservation.getListeAEcrire());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Vol> vols = CSVReaderUtil.readVols("vols.csv");
            List<Passager> passagers = CSVReaderUtil.readPassagers("passagers.csv");
            List<Pilote> pilotes = CSVReaderUtil.readPilotes("pilotes.csv");
            List<Avion> avions = CSVReaderUtil.readAvions("avions.csv");
            List<Aeroport> aeroports = CSVReaderUtil.readAeroports("aeroports.csv");

            System.out.println("Vols importés : ");
            for (Vol vole : vols) {
                vole.getInfos();
            }

            System.out.println("Passagers importés : ");
            for (Passager passagere : passagers) {
                passagere.ObtenirInfos();
            }

            System.out.println("Pilotes importés : ");
            for (Pilote pilotee : pilotes) {
                pilotee.ObtenirInfos();
            }

            System.out.println("Avions importés : ");
            for (Avion avione : avions) {
                System.out.println("Immatriculation: " + avione.getImmatriculation() + ", Modèle: " + avione.getModele() + ", Capacité: " + avione.getCapacite());
            }

            System.out.println("Aéroports importés : ");
            for (Aeroport aeroport : aeroports) {
                System.out.println("Nom: " + aeroport.getNom() + ", Ville: " + aeroport.getVille() + ", Description: " + aeroport.getDescription());
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des fichiers CSV : " + e.getMessage());
        }
    }
}