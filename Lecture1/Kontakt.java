public class Kontakt {
    String imie;
    String nazwisko;
    String telefon;

    public Kontakt(String imie, String nazwisko, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public String toString() {
        return imie + " " + nazwisko + " - " + telefon;
    }

    public String doZapisu() {
        return imie + ";" + nazwisko + ";" + telefon;
    }
}