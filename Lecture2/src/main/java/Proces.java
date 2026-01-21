import java.util.ArrayList;
import java.util.List;

public class Proces implements Walidowalny, Analizowalny {
    private final String identyfikator;
    private final List<Zdarzenie> zdarzenia;

    public Proces(String identyfikator) {
        if (identyfikator == null || identyfikator.isBlank()) {
            throw new IllegalArgumentException("Identyfikator procesu nie może być pusty");
        }
        this.identyfikator = identyfikator;
        this.zdarzenia = new ArrayList<>();
    }

    // TASK 1.2: Zabezpiecz klasę Proces przed dodaniem wartości null.
    public void dodajZdarzenie(Zdarzenie z) {
        if (z == null) {
            throw new NiepoprawneZdarzenieException("Zdarzenie nie może być null");
        }
        if (!z.getIdentyfikatorProcesu().equals(identyfikator)) {
            throw new NiezgodnyProcesException("Zdarzenie należy do innego procesu");
        }
        zdarzenia.add(z);
    }

    @Override
    public void waliduj() {
        if (zdarzenia.isEmpty()) {
            throw new PustyProcesException("Proces nie zawiera żadnych zdarzeń");
        }
    }

    public List<Zdarzenie> getZdarzenia() {
        return zdarzenia;
    }

    public String getIdentyfikator() {
        return identyfikator;
    }

    // TASK 3.2: Zaimplementuj ten interfejs w klasie Proces (Analizowalny)
    @Override
    public void analizuj() {
        System.out.println("Analiza procesu: " + identyfikator);
        System.out.println("Liczba zdarzeń: " + zdarzenia.size());
        if (!zdarzenia.isEmpty()) {
            System.out.println("Zdarzenia:");
            for (Zdarzenie z : zdarzenia) {
                System.out.println("  - " + z.getNazwaAktywnosci() + " o " + z.getCzas());
            }
        }
    }
}