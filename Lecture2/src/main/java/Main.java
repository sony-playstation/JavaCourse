import java.time.Instant;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Test podstawowych funkcji
        System.out.println("Creating Process...");
        Proces proces = new Proces("P1");
        
        proces.dodajZdarzenie(
            new Zdarzenie("P1", "Start", Instant.now())
        );
        
        // Niewielkie opóźnienie - wyświetlanie czasu trwania
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        proces.dodajZdarzenie(
            new Zdarzenie("P1", "Validate", Instant.now())
        );
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        proces.dodajZdarzenie(
            new Zdarzenie("P1", "End", Instant.now())
        );
        
        // Task 1.1: Test toString()
        System.out.println("\nTask 1.1: toString()");
        for (Zdarzenie z : proces.getZdarzenia()) {
            System.out.println(z.toString());
        }
        
        // Task 1.2: Test null protection
        System.out.println("\nTask 1.2: Null Protection");
        try {
            proces.dodajZdarzenie(null);
        } catch (NiepoprawneZdarzenieException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        
        // Task 2.1: Test duration calculation
        System.out.println("\nTask 2.1: Process Duration");
        Duration duration = AnalizaProcesu.obliczCzasTrwania(proces);
        System.out.println("Process duration: " + duration.toMillis() + " ms");
        
        // Task 2.2: Test sequence analysis
        System.out.println("\nTask 2.2: Sequence Analysis");
        AnalizaSekwencji.wypiszNastepstwa(proces);
        
        // Test with single event
        System.out.println("\nSingle Event Process");
        Proces singleEventProces = new Proces("P2");
        singleEventProces.dodajZdarzenie(
            new Zdarzenie("P2", "OnlyEvent", Instant.now())
        );
        AnalizaSekwencji.wypiszNastepstwa(singleEventProces);
        
        // Task 3.2: Test Analizowalny interface
        System.out.println("\nTask 3.2: Analizowalny");
        proces.analizuj();
        
        // Task 4.1: Test PustyProcesException
        System.out.println("\nTask 4.1: Empty Process");
        try {
            Proces emptyProces = new Proces("P3");
            emptyProces.waliduj();
        } catch (PustyProcesException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        
        System.out.println("\nAll Tasks Completed Successfully");
    }
}