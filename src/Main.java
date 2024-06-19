import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Creare la mappa che contiene i nodi e i pesi tra gli stessi nodi
        HashMap<String, Map<String, Integer>> graph = new HashMap<>();

        // Aggiungere i nodi e i rispettivi pesi
        graph.put("A", new HashMap<String, Integer>() {
            {
                put("B", 3);
                put("C", 2);
                put("D", 4);
            }
        });

        graph.put("B", new HashMap<String, Integer>() {
            {
                put("D", 1);
            }
        });

        graph.put("C", new HashMap<String, Integer>() {
            {
                put("E", 6);
            }
        });

        graph.put("D", new HashMap<String, Integer>() {
            {
                put("E", 3);
            }
        });

        // Assicurarsi che tutti i nodi siano presenti nella mappa, anche se non hanno archi uscenti
        graph.putIfAbsent("E", new HashMap<String, Integer>());

        // Calcolare il percorso minimo
        DijkstraWithHashMap.calcolaPercorsoMinimo(graph, "A", "E");
    }
}
