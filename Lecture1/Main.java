import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    static List<Kontakt> kontakty = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String plikKontaktow = "kontakty.txt";

    public static void main(String[] args) {
        wczytajZPliku();
        
        boolean dzialaj = true;
        while (dzialaj) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj kontakt");
            System.out.println("2. Usun kontakt");
            System.out.println("3. Szukaj kontakt");
            System.out.println("4. Pokaz wszystkie");
            System.out.println("5. Wyjdz");
            System.out.print("Wybierz: ");
            
            String wybor = scanner.nextLine();
            
            switch (wybor) {
                case "1":
                    dodajKontakt();
                    break;
                case "2":
                    usunKontakt();
                    break;
                case "3":
                    szukajKontakt();
                    break;
                case "4":
                    pokazWszystkie();
                    break;
                case "5":
                    zapiszDoPliku();
                    dzialaj = false;
                    System.out.println("Do widzenia!");
                    break;
                default:
                    System.out.println("Zly wybor");
            }
        }
    }

    static void dodajKontakt() {
        System.out.print("Imie: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();
        
        kontakty.add(new Kontakt(imie, nazwisko, telefon));
        System.out.println("Dodano kontakt");
    }

    static void usunKontakt() {
        System.out.print("Podaj nazwisko do usuniecia: ");
        String nazwisko = scanner.nextLine();
        
        boolean usunieto = kontakty.removeIf(k -> k.nazwisko.equalsIgnoreCase(nazwisko));
        
        if (usunieto) {
            System.out.println("Usunieto");
        } else {
            System.out.println("Nie znaleziono");
        }
    }

    static void szukajKontakt() {
        System.out.print("Szukaj (imie lub nazwisko): ");
        String fraza = scanner.nextLine().toLowerCase();
        
        boolean znaleziono = false;
        for (Kontakt k : kontakty) {
            if (k.imie.toLowerCase().contains(fraza) || k.nazwisko.toLowerCase().contains(fraza)) {
                System.out.println(k);
                znaleziono = true;
            }
        }
        
        if (!znaleziono) {
            System.out.println("Nic nie znaleziono");
        }
    }

    static void pokazWszystkie() {
        if (kontakty.isEmpty()) {
            System.out.println("Brak kontaktow");
            return;
        }
        for (Kontakt k : kontakty) {
            System.out.println(k);
        }
    }

    static void zapiszDoPliku() {
        try {
            List<String> linie = new ArrayList<>();
            for (Kontakt k : kontakty) {
                linie.add(k.doZapisu());
            }
            Files.write(Path.of(plikKontaktow), linie);
        } catch (IOException e) {
            System.out.println("Blad zapisu: " + e.getMessage());
        }
    }

    static void wczytajZPliku() {
        try {
            if (Files.exists(Path.of(plikKontaktow))) {
                List<String> linie = Files.readAllLines(Path.of(plikKontaktow));
                for (String linia : linie) {
                    String[] dane = linia.split(";");
                    if (dane.length == 3) {
                        kontakty.add(new Kontakt(dane[0], dane[1], dane[2]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Blad odczytu: " + e.getMessage());
        }
    }
}
