package cyberguard;

import java.util.Random;
import java.util.Scanner;

public class CyberGuard {

    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);

        KorisnickiNalog[] bazaKorisnika = new KorisnickiNalog[10];
        int brojKorisnika = 0;

        boolean radi = true;

        while (radi) {
            System.out.println("\n=== CYBERGUARD OOP SECURITY AUDIT ===");
            System.out.println("1. Unesi novi korisnicki nalog");
            System.out.println("2. Pokreni bezbednosnu proveru (Security Scan)");
            System.out.println("3. Generisi jaku lozinku");
            System.out.println("4. Prikazi statistiku sistema");
            System.out.println("0. Izlaz");
            System.out.print("Izaberi opciju: ");

            int opcija = unos.nextInt();
            unos.nextLine(); 

            switch (opcija) {
                case 1:
                    if (brojKorisnika < bazaKorisnika.length) {
                        System.out.print("Unesi korisnicko ime: ");
                        String user = unos.nextLine();

                        System.out.print("Unesi lozinku: ");
                        String pass = unos.nextLine();

                        System.out.print("Broj neuspelih prijava: ");
                        int pokusaji = unos.nextInt();
                        unos.nextLine();

                        // Kreiranje novog objekta i smestanje u niz
                        bazaKorisnika[brojKorisnika] = new KorisnickiNalog(user, pass, pokusaji);
                        brojKorisnika++;

                        System.out.println("Korisnicki nalog je uspesno kreiran i analiziran!");
                    } else {
                        System.out.println("Baza korisnika je puna!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- REZULTATI BEZBEDNOSNE PROVERE ---");
                    if (brojKorisnika == 0) {
                        System.out.println("Nema unetih korisnika u bazi.");
                    } else {
                        for (int i = 0; i < brojKorisnika; i++) {
                            bazaKorisnika[i].prikaziIzvestaj();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Unesi zeljenu duzinu lozinke (npr. 12): ");
                    int duzina = unos.nextInt();
                    unos.nextLine();
                    System.out.println("Predlog jake lozinke: " + generisiLozinku(duzina));
                    break;

                case 4:
                    prikaziStatistiku(bazaKorisnika, brojKorisnika);
                    break;

                case 0:
                    radi = false;
                    System.out.println("Izlazak iz programa...");
                    break;

                default:
                    System.out.println("Nepostojeca opcija, pokusaj ponovo.");
            }
        }
    }

    public static String generisiLozinku(int duzina) {
        String karakteri = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        Random rand = new Random();
        String rezultat = "";

        for (int i = 0; i < duzina; i++) {
            int nasumicniIndeks = rand.nextInt(karakteri.length());
            rezultat = rezultat + karakteri.charAt(nasumicniIndeks);
        }
        return rezultat;
    }

    public static void prikaziStatistiku(KorisnickiNalog[] baza, int brojKorisnika) {
        if (brojKorisnika == 0) {
            System.out.println("Nema podataka za statistiku.");
            return;
        }

        int ugrozeni = 0;
        for (int i = 0; i < brojKorisnika; i++) {
            if (!baza[i].jeSiguran()) {
                ugrozeni++;
            }
        }

        double procenat = (ugrozeni * 100.0) / brojKorisnika;
        System.out.println("\n--- STATISTIKA SISTEMA ---");
        System.out.println("Ukupno naloga: " + brojKorisnika);
        System.out.println("Ugrozenih naloga: " + ugrozeni + " (" + procenat + "%)");
    }
}