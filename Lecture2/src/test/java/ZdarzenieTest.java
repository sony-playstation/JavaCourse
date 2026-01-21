import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Instant;

public class ZdarzenieTest {

    @Test
    public void poprawneZdarzeniePowinnoZostacUtworzone() {
        Zdarzenie z = new Zdarzenie("P1", "Start", Instant.now());
        
        assertNotNull(z);
        assertEquals("P1", z.getIdentyfikatorProcesu());
        assertEquals("Start", z.getNazwaAktywnosci());
    }

    @Test
    public void utworzenieZdarzeniaBezNazwyPowinnoRzucicWyjatek() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Zdarzenie("P1", "", Instant.now())
        );
    }

    @Test
    public void utworzenieZdarzeniaBezIdentyfikatoraPowinnoRzucicWyjatek() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Zdarzenie(null, "Start", Instant.now())
        );
    }

    @Test
    public void utworzenieZdarzeniaBezCzasuPowinnoRzucicWyjatek() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Zdarzenie("P1", "Start", null)
        );
    }

    // TASK 1.1: Test toString() method
    @Test
    public void toStringShouldContainAllFields() {
        Instant czas = Instant.parse("2024-01-15T10:30:00Z");
        Zdarzenie z = new Zdarzenie("P1", "Start", czas);

        String result = z.toString();

        assertTrue(result.contains("P1"));
        assertTrue(result.contains("Start"));
        assertTrue(result.contains("2024-01-15"));
    }
}