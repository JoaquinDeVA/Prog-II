package grafo;

import java.util.*;

public class Grafo {

    private static class Arista {

        private String destino;
        private int distancia;

        public Arista(String destino, int distancia) {
            this.destino = destino;
            this.distancia = distancia;
        }

        public int getDistancia() {
            return distancia;
        }

        public String getDestino() {
            return destino;
        }
    }
    //Falta añadir el array de vertices
    private Map<String, List<Arista>> adyacencia;

    public Grafo() {
        adyacencia = new HashMap<>();
    }

    public boolean agregarVertice(String vertice) {
        if (!adyacencia.containsKey(vertice)) {
            adyacencia.put(vertice, new ArrayList<>());
            return true;
        }
        return false;
    }

    public void agregarRuta(String vertice1, String vertice2, int distancia) {
        this.agregarVertice(vertice1);
        this.agregarVertice(vertice2);

        adyacencia.get(vertice1).add(new Arista(vertice2, distancia));
        adyacencia.get(vertice2).add(new Arista(vertice1, distancia)); // Si es no dirigido
    }

    public List<Arista> obtenerAdyacentes(String vertice) {

        return adyacencia.get(vertice);
    }

    public Set<String> vertices() {
        return adyacencia.keySet();
    }

    public int coste(String vertice1, String vertice2) {
        for (Arista arista : this.obtenerAdyacentes(vertice1)) {
            if (arista.getDestino().equals(vertice2)) {
                return arista.getDistancia();
            }
        }
        return Integer.MAX_VALUE;
    }
}
