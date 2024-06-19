## Spiegazione del Codice

### Import delle Librerie Necessarie

- `HashMap` e `Map` sono utilizzati per memorizzare il grafo e altre informazioni.
- `Stack` è utilizzato per ricostruire il percorso minimo.

### Classe `DijkstraWithHashMap`

- Implementa l'algoritmo di Dijkstra per calcolare il percorso minimo in un grafo.

### Metodo `calcolaPercorsoMinimo`

#### Parametri:

- `Map<String, Map<String, Integer>> mappa`: la mappa di adiacenza che rappresenta il grafo.
- `String start`: il nodo di partenza.
- `String end`: il nodo di destinazione.

#### Variabili:

- `visitato`: mappa che traccia se un nodo è stato visitato.
- `distanza`: mappa che contiene le distanze minime dai nodi di partenza.
- `predecessore`: mappa che traccia il predecessore di ogni nodo per ricostruire il percorso.

#### Inizializzazione:

- Tutti i nodi sono inizializzati con una distanza infinita e come non visitati.
- Il nodo di partenza ha una distanza di 0.

#### Ciclo Principale:

- Trova il nodo non visitato con la distanza minima.
- Aggiorna le distanze dei vicini del nodo corrente.

#### Ricostruzione del Percorso:

- Utilizza la mappa `predecessore` per ricostruire il percorso dal nodo di destinazione al nodo di partenza.
- Stampa il percorso e le distanze finali.

