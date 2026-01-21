import java.time.Instant;

public class Zdarzenie implements Walidowalny {
    private final String identyfikatorProcesu;
    private final String nazwaAktywnosci;
    private final Instant czas;

    public Zdarzenie(String identyfikatorProcesu, String nazwaAktywnosci, Instant czas) {
        this.identyfikatorProcesu = identyfikatorProcesu;
        this.nazwaAktywnosci = nazwaAktywnosci;
        this.czas = czas;
        waliduj();
    }

    @Override
    public void waliduj() {
        if (identyfikatorProcesu == null || identyfikatorProcesu.isBlank()) {
            throw new IllegalArgumentException("Identyfikator procesu nie może być pusty");
        }
        if (nazwaAktywnosci == null || nazwaAktywnosci.isBlank()) {
            throw new IllegalArgumentException("Nazwa aktywności nie może być pusta");
        }
        if (czas == null) {
            throw new IllegalArgumentException("Znacznik czasu nie może być null");
        }
    }

    public String getIdentyfikatorProcesu() {
        return identyfikatorProcesu;
    }

    public String getNazwaAktywnosci() {
        return nazwaAktywnosci;
    }

    public Instant getCzas() {
        return czas;
    }

    // TASK 1.1: Dodaj do klasy Zdarzenie metodę toString().
    @Override
    public String toString() {
        return "Zdarzenie{" +
                "identyfikatorProcesu='" + identyfikatorProcesu + '\'' +
                ", nazwaAktywnosci='" + nazwaAktywnosci + '\'' +
                ", czas=" + czas +
                '}';
    }
}