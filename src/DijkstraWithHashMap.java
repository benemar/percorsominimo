import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Questa classe implementa l'algoritmo di Dijkstra per calcolare il percorso minimo
 * in un grafo rappresentato da una mappa di adiacenza.
 */
public class DijkstraWithHashMap {

    /**
     * Calcola il percorso minimo da un nodo di partenza a un nodo di destinazione
     * utilizzando l'algoritmo di Dijkstra.
     *
     * @param mappa La mappa di adiacenza che rappresenta il grafo.
     * @param start Il nodo di partenza.
     * @param end   Il nodo di destinazione.
     */
    public static void calcolaPercorsoMinimo(Map<String, Map<String, Integer>> mappa, String start, String end) {
        // Traccia i nodi visitati
        Map<String, Boolean> visitato = new HashMap<>();

        // Mappa con le distanze minime
        Map<String, Integer> distanza = new HashMap<>();

        // Mappa per tracciare i predecessori
        Map<String, String> predecessore = new HashMap<>();

        // Inizializza le distanze e i nodi visitati
        for (String nodo : mappa.keySet()) {
            distanza.put(nodo, Integer.MAX_VALUE);
            visitato.put(nodo, false);
            predecessore.put(nodo, null);  // Inizializza il predecessore di ogni nodo
        }

        // Imposta la distanza iniziale del nodo di partenza a 0
        distanza.put(start, 0);

        // Ciclo principale dell'algoritmo di Dijkstra
        while (true) {
            String nodoCorrenteChiave = null;
            int distanzaCorrente = Integer.MAX_VALUE;

            // Trova il nodo non visitato con la distanza minima
            for (Map.Entry<String, Integer> entry : distanza.entrySet()) {
                if (!visitato.get(entry.getKey()) && entry.getValue() < distanzaCorrente) {
                    distanzaCorrente = entry.getValue();
                    nodoCorrenteChiave = entry.getKey();
                }
            }

            // Se non ci sono più nodi non visitati con una distanza finita, termina il ciclo
            if (nodoCorrenteChiave == null) {
                break;
            }

            // Marca il nodo corrente come visitato
            visitato.put(nodoCorrenteChiave, true);

            // Aggiorna le distanze dei vicini del nodo corrente
            for (Map.Entry<String, Integer> neighbor : mappa.get(nodoCorrenteChiave).entrySet()) {
                if (!visitato.get(neighbor.getKey())) {
                    int nuovaDistanza = distanza.get(nodoCorrenteChiave) + neighbor.getValue();
                    if (nuovaDistanza < distanza.get(neighbor.getKey())) {
                        distanza.put(neighbor.getKey(), nuovaDistanza);
                        predecessore.put(neighbor.getKey(), nodoCorrenteChiave);  // Aggiorna il predecessore
                    }
                }
            }
        }

        // Ricostruisce il percorso migliore dal nodo di partenza al nodo di destinazione
        Stack<String> percorso = new Stack<>();
        for (String nodo = end; nodo != null; nodo = predecessore.get(nodo)) {
            percorso.push(nodo);
        }

        // Stampa il percorso migliore
        if (percorso.size() == 1 && !percorso.peek().equals(start)) {
            System.out.println("Non esiste un percorso dal nodo " + start + " al nodo " + end);
        } else {
            System.out.print("Percorso da " + start + " a " + end + ": ");
            while (!percorso.isEmpty()) {
                System.out.print(percorso.pop() + (percorso.isEmpty() ? "" : " -> "));
            }
            System.out.println();
        }

        // Stampa le distanze finali
        for (Map.Entry<String, Integer> entry : distanza.entrySet()) {
            System.out.println("Distanza da " + start + " a " + entry.getKey() + " è " + entry.getValue());
        }
    }
}
