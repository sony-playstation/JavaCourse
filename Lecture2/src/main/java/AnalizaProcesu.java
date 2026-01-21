import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;

public class AnalizaProcesu {
    
    public static void uporzadkujPoCzasie(Proces proces) {
        proces.getZdarzenia().sort(
            Comparator.comparing(Zdarzenie::getCzas)
        );
    }

    // TASK 2.1: Napisz metodę obliczającą czas trwania procesu.
    public static Duration obliczCzasTrwania(Proces proces) {
        List<Zdarzenie> zdarzenia = proces.getZdarzenia();
        
        if (zdarzenia.isEmpty()) {
            return Duration.ZERO;
        }
        
        if (zdarzenia.size() == 1) {
            return Duration.ZERO;
        }
        
        uporzadkujPoCzasie(proces);
        
        Instant pierwszyCzas = zdarzenia.get(0).getCzas();
        Instant ostatniCzas = zdarzenia.get(zdarzenia.size() - 1).getCzas();
        
        return Duration.between(pierwszyCzas, ostatniCzas);
    }
}

