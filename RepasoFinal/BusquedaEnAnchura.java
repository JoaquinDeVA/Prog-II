import java.util.*;


    public class BusquedaEnAnchura { //ESTE RECORRIDO SOLO IMPRIME, SI QUITAMOS LOS SYSTEM OUT y ponemos una condicion de comparacion puede buscar

    public static void recorridoEnAnchura(ArbolBinario arbol) {
        


        if (arbol.esNulo() == true) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Deque<ArbolBinario> cola = new ArrayDeque<>();
        cola.add(arbol);

        System.out.print("Recorrido en anchura: ");
        
        while (!cola.isEmpty()) {
            
            ArbolBinario actual = cola.pop();

            System.out.print(actual.getDato() + " ");

            if (actual.getIzq().getRoot() != null) {
                cola.add(actual.getIzq());
            }

            if (actual.getDer().getRoot() != null) {
                cola.add(actual.getDer());
            }
        }
        System.out.println();
    }
}
