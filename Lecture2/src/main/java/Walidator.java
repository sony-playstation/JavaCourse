import java.util.List;

public class Walidator {
    public static void walidujWszystkie(List<Walidowalny> obiekty) {
        for (Walidowalny o : obiekty) {
            o.waliduj();
        }
    }
}