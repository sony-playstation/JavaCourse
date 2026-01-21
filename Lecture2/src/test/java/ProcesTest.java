import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Instant;


public class ProcesTest {

    // TASK 5.1: Test waliduj() passes for process with two events
    @Test
    public void walidujPowinienPrzejscDlaProcesuZDwomaZdarzeniami() {
        Proces proces = new Proces("P1");
        proces.dodajZdarzenie(
            new Zdarzenie("P1", "Start", Instant.now())
        );
        proces.dodajZdarzenie(
            new Zdarzenie("P1", "End", Instant.now())
        );
        
        assertDoesNotThrow(() -> proces.waliduj());
    }

    // TASK 5.2: Test that adding null throws exception
    @Test
    public void dodanieNullJakoZdarzeniaPowinnoRzucicWyjatek() {
        Proces proces = new Proces("P1");
        
        assertThrows(
            NiepoprawneZdarzenieException.class,
            () -> proces.dodajZdarzenie(null)
        );
    }

    // Additional test from PDF
    @Test
    public void dodanieZdarzeniaZInnegoProcesPowinnoRzucicWyjatek() {
        Proces proces = new Proces("P1");
        Zdarzenie z = new Zdarzenie("P2", "Start", Instant.now());
        
        assertThrows(
            NiezgodnyProcesException.class,
            () -> proces.dodajZdarzenie(z)
        );
    }

    @Test
    public void procesZJednymZdarzeniemJestPoprawny() {
        Proces proces = new Proces("P1");
        proces.dodajZdarzenie(
            new Zdarzenie("P1", "Start", Instant.now())
        );
        
        assertDoesNotThrow(() -> proces.waliduj());
    }

    @Test
    public void pustyProcesPowinienBycNiepoprawny() {
        Proces proces = new Proces("P1");
        
        assertThrows(
            PustyProcesException.class,
            () -> proces.waliduj()
        );
    }
}