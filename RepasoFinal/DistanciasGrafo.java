

import java.util.*;

public class DistanciasGrafo {

    
    public void RecorridoEnAnchura(String vertice1,String vertice2,Grafo grafo){

        if(vertice1.equals(vertice2)){
                
            System.out.println("No hay camino ya que el vertice inicial es ya el destino");
            return;
        }

        Deque<String> cola = new ArrayDeque<>();
        List<String> visitados = new ArrayList<>();
        Map<String,String> camino = new HashMap<>();

        cola.add(vertice1);
        visitados.add(vertice1);

        while(!cola.isEmpty()){

            String actual = cola.pop();

            if(grafo.getAdyacentes(actual).contains(vertice2)){

                camino.put(vertice2,actual);
                break;
            } else{
                for(String adyacente : grafo.getAdyacentes(actual)){

                    if(!visitados.contains(adyacente)){
                        cola.add(adyacente);
                        camino.put(adyacente,actual);
                        visitados.add(adyacente);
                    }
                }
            }
        }

        if(!camino.containsKey(vertice2)){

            System.out.println("No hay camino de v1 a v2");
            return;
        }

        Stack<String> recorridoInver = new Stack<>();
        String paso = vertice2;

        while(!paso.equals(vertice1)){

            recorridoInver.add(paso);
            paso = camino.get(paso);
        }
        recorridoInver.add(vertice1);

        ArrayList<String> resul = new ArrayList<>();

        while(!recorridoInver.isEmpty()){
            resul.add(recorridoInver.pop());
        }

        int distancia = resul.size() -1;

        System.out.print("La distancia es: "  + distancia + ", con el recorrido: " + resul.get(0));
        for(int i = 1; i < resul.size() ; i++){
            System.out.print( ", " + resul.get(i));
        }
        System.out.println();
    }
}
