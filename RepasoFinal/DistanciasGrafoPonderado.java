
import java.util.*;

public class DistanciasGrafoPonderado {
 

    public void dickstra(String vertice1,String vertice2,GrafoPonderado grafo){
        
        
        ArrayList<String> vertices = grafo.getVertices();
        ArrayList<Boolean> visitados = new ArrayList<>();
        ArrayList<String> camino = new ArrayList<>();
        ArrayList<Integer> distancia = new ArrayList<>();

        for(String vertice : vertices){

            distancia.add(grafo.coste(vertice,vertice2));
            camino.add(vertice2);
            visitados.add(false);
        }

        while(true){


            int indice = -1;
            int valorMin = Integer.MAX_VALUE;

            for(int i = 0; i < vertices.size();i++){

                if(distancia.get(i) < valorMin && !visitados.get(i)){

                    indice = i;
                    valorMin = distancia.get(i);
                }
            }


            if(indice == -1){
                break;
            }


            visitados.set(indice,true);
            String minimo = vertices.get(indice);

            for(int i = 0; i < vertices.size() ; i++){

                int valorInter = grafo.coste(vertices.get(i),minimo);

                if(valorInter < Integer.MAX_VALUE){

                    int nuevoCoste = valorInter + distancia.get(indice);

                    if(nuevoCoste < distancia.get(i)){

                        distancia.set(i, nuevoCoste);
                        camino.set(i, minimo);
                    }
                }
            }
        }

        if(distancia.get(vertices.indexOf(vertice1)) == Integer.MAX_VALUE){

            System.out.println("No hay camino entre los vertices");
            return;
        }

        
        ArrayList<String> caminoFinal = new ArrayList<>();

        String paso = vertice1;

        while (!paso.equals(vertice2)){
            caminoFinal.add(paso);
            paso = camino.get(vertices.indexOf(paso));
        }

        caminoFinal.add(vertice2);
        int distanciaFinal = distancia.get(vertices.indexOf(vertice1));

        System.out.print("El camino entre los vertices tiene una distancia de: " + distanciaFinal + ", el camino: ");

        for(String e : caminoFinal){

            System.out.print(e + ", ");
        }

        System.out.println();
        
    }











    public void floyd(String vertice1,String vertice2,GrafoPonderado grafo){
        
        ArrayList<ArrayList<Integer>> distancia = new ArrayList<>();
        ArrayList<ArrayList<String>> camino = new ArrayList<>();

        ArrayList<String> vertices = grafo.getVertices();
        int n = vertices.size();



        for(int i = 0; i < n; i++){

            ArrayList<Integer> resulDistancia = new ArrayList<>();
            ArrayList<String>  caminoInicial = new ArrayList<>();


            for(int j=0; j < n; j++){
                
                if(i == j){

                    resulDistancia.add(0);
                } else{
                    resulDistancia.add(grafo.coste(vertices.get(i), vertices.get(j)));                    
                }
                caminoInicial.add(vertices.get(j));
            }
            distancia.add(resulDistancia);
            camino.add(caminoInicial);
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0;j < n; j++){

                    int ij = distancia.get(i).get(j);
                    int ik = distancia.get(i).get(k);
                    int kj = distancia.get(k).get(j);

                    if(ik < Integer.MAX_VALUE && kj < Integer.MAX_VALUE && ik + kj < ij){

                        distancia.get(i).set(j, ik +kj);
                        camino.get(i).set(j,vertices.get(k));
                    }
                }
            }
        }

        if(distancia.get(vertices.indexOf(vertice1)).get(vertices.indexOf(vertice2)) == Integer.MAX_VALUE){

            System.out.println("No hay camino entre los vertices");
            return;
        }

        ArrayList<String> recorrido = new ArrayList<>();
        String paso = vertice1;

        while(!paso.equals(vertice2)){

            recorrido.add(paso);
            paso = camino.get(vertices.indexOf(paso)).get(vertices.indexOf(vertice2));
        }
        int distanciaFinal = distancia.get(vertices.indexOf(vertice1)).get(vertices.indexOf(vertice2));

        System.out.print("El recorrido de distancia: " + distanciaFinal + ", sigue la siguiente ruta: ");
        for(String v : recorrido){

            System.out.print(v + ", ");
        }
        System.out.println(vertice2);
    }
}
