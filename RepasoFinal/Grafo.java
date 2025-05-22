
import java.util.*;

public class Grafo {
    
    Map<String,List<String>> adyacencia;
    Set<String> vertices;

    public Grafo(){

        adyacencia = new HashMap<>();
        vertices = new LinkedHashSet<>();
    }

    public void addVertice(String vertice1){
        
        if(!vertices.contains(vertice1)){
            vertices.add(vertice1);
            adyacencia.put(vertice1, new ArrayList<>());
        }
    }

    public Set<String> getVertices(){
        return vertices;
    }

    public void addArista(String vertice1, String vertice2){

        this.addVertice(vertice1);
        this.addVertice(vertice2);

        if(!adyacencia.get(vertice1).contains(vertice2)){
            adyacencia.get(vertice1).add(vertice2);
            adyacencia.get(vertice2).add(vertice1);
        }
    }

    public List<String> getAdyacentes(String vertice){
        return adyacencia.get(vertice);
    }

}
