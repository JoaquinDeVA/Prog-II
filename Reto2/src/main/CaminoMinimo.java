package main;

import java.util.*;

import grafo.Grafo;

public class CaminoMinimo {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarRuta("A", "B", 5);
        grafo.agregarRuta("A", "C", 2);
        grafo.agregarRuta("B", "C", 1);
        grafo.agregarRuta("B", "D", 3);
        grafo.agregarRuta("C", "D", 7);

        new CaminoMinimo().calcularYMostrarCaminoMinimo("A", "D", grafo);
    }

   public void calcularYMostrarCaminoMinimo(String inicio, String fin, Grafo grafo) {

    ArrayList<String> vertices = new ArrayList<>(grafo.vertices());
    ArrayList<Integer> distancias = new ArrayList<>();
    ArrayList<String> camino = new ArrayList<>();
    ArrayList<String> visitados = new ArrayList<>();

    // Inicialización: distancia desde cada vértice al destino (fin)
    for (String vertice : vertices) {
        int costo = grafo.coste(vertice, fin);
        distancias.add(costo);
        camino.add(fin); // Suponemos inicialmente que todos llegan a fin directamente
    }

    // Algoritmo de camino mínimo inverso (hacia el destino)
    while (visitados.size() != vertices.size()) {
        int indiceMin = -1;
        int valorMin = Integer.MAX_VALUE;

        // Encontrar el vértice no visitado con menor distancia al destino
        for (int i = 0; i < vertices.size(); i++) {
            if (!visitados.contains(vertices.get(i)) && distancias.get(i) < valorMin) {
                valorMin = distancias.get(i);
                indiceMin = i;
            }
        }

        if (indiceMin == -1){ // Todos los vértices restantes son inaccesibles

         break; 
        }

        String actual = vertices.get(indiceMin);
        visitados.add(actual);

        // Para todos los demás vértices, verificar si mejora el camino pasando por 'actual'
        for (int i = 0; i < vertices.size(); i++) {
            String vertice = vertices.get(i);

            int costoIntermedio = grafo.coste(vertice, actual);
            
            if (costoIntermedio < Integer.MAX_VALUE) {
                int nuevaDistancia = costoIntermedio + distancias.get(indiceMin);
                if (nuevaDistancia < distancias.get(i)) {
                    distancias.set(i, nuevaDistancia);
                    camino.set(i, actual);
                }
            }
        }
    }

    // Mostrar resultados para el nodo de inicio
    int posInicio = vertices.indexOf(inicio);
    int distanciaTotal = distancias.get(posInicio);

    if (distanciaTotal == Integer.MAX_VALUE) {
        System.out.println("No existe un camino desde " + inicio + " a " + fin);
    } else {
        System.out.println("Distancia mínima desde " + inicio + " a " + fin + ": " + distanciaTotal);

        // Reconstruir el camino desde 'inicio' hasta 'fin'
        ArrayList<String> ruta = new ArrayList<>();
        String paso = inicio;

        while (!paso.equals(fin)) {
            ruta.add(paso);
            int idx = vertices.indexOf(paso);
            paso = camino.get(idx);
        }
        ruta.add(fin);

        System.out.println("Camino: " + String.join(" -> ", ruta));
    }
}

}
