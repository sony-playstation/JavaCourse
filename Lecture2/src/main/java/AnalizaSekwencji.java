import java.util.List;

public class AnalizaSekwencji {
    
    // TASK 2.2: Zmodyfikuj analizę tak, aby obsługiwała procesy z jednym zdarzeniem.
    public static void wypiszNastepstwa(Proces proces) {
        List<Zdarzenie> zdarzenia = proces.getZdarzenia();
        
        // Procesy bez zdarzeń
        if (zdarzenia.isEmpty()) {
            System.out.println("Proces nie zawiera żadnych zdarzeń.");
            return;
        }
        
        // Procesy z jednym zdarzeniem
        if (zdarzenia.size() == 1) {
            System.out.println("Proces zawiera tylko jedno zdarzenie: " + 
                zdarzenia.get(0).getNazwaAktywnosci());
            System.out.println("Brak następstw do wyświetlenia.");
            return;
        }
        
        // Procesy z 2+ zdarzeniami
        for (int i = 0; i < zdarzenia.size() - 1; i++) {
            String a1 = zdarzenia.get(i).getNazwaAktywnosci();
            String a2 = zdarzenia.get(i + 1).getNazwaAktywnosci();
            System.out.println(a1 + " -> " + a2);
        }
    }
}

