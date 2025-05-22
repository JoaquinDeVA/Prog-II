public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregamos vértices y aristas
        grafo.addArista("A", "B");
        grafo.addArista("A", "C");
        grafo.addArista("B", "D");
        grafo.addArista("C", "E");
        grafo.addArista("D", "F");
        grafo.addArista("E", "F");

        // Creamos instancia de la clase que contiene el método de recorrido
        DistanciasGrafo dist = new DistanciasGrafo();

        // Probamos el método para encontrar el camino mínimo entre A y F
        dist.RecorridoEnAnchura("A", "F", grafo);




         GrafoPonderado grafo2 = new GrafoPonderado();

        // Agregar aristas (esto también crea los vértices)
        grafo2.addArista("A", "B", 2);
        grafo2.addArista("A", "C", 5);
        grafo2.addArista("B", "C", 1);
        grafo2.addArista("B", "D", 4);
        grafo2.addArista("C", "D", 2);

        // Instancia de clase con algoritmo de Floyd
        DistanciasGrafoPonderado dgp = new DistanciasGrafoPonderado();

        // Ejecutar Floyd para camino más corto entre A y D
        dgp.floyd("A", "D", grafo2);

        GrafoPonderado grafo3 = new GrafoPonderado();
        grafo3.addArista("A", "B", 2);
        grafo3.addArista("B", "C", 3);
        grafo3.addArista("A", "C", 10);
        grafo3.addArista("C", "D", 1);

        DistanciasGrafoPonderado dgp2 = new DistanciasGrafoPonderado();
        dgp2.dickstra("A", "D", grafo3);
    }
}