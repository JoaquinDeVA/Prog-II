
import java.util.*;

public class GrafoPonderado{


    private class Arista{

        public String destino;
        public int distancia;

        public Arista(String destino, int distancia){

            this.destino = destino;
            this.distancia = distancia;
        }
    }
  
    private ArrayList<String> vertices;
    private Map<String,List<Arista>> adyacencia;

    public GrafoPonderado(){
        
        vertices = new ArrayList<>();
        adyacencia = new HashMap<>();
    }

    public void addVertice(String vertice){
        
        if(!vertices.contains(vertice)){

            vertices.add(vertice);
            adyacencia.put(vertice, new ArrayList<>());
        }
    }

    public Arista getArista(String vertice1,String vertice2){

        for(Arista arista : this.getAdyacentes(vertice1)){

            if(arista.destino.equals(vertice2)){
                return arista;
            }
        }
        return null;
    }

    public List<Arista> getAdyacentes(String vertice1){

        return adyacencia.get(vertice1);
    }

    public void addArista(String vertice1,String vertice2, int distancia){

        this.addVertice(vertice1);
        this.addVertice(vertice2);

        if(this.getArista(vertice1, vertice2) == null){

            adyacencia.get(vertice1).add(new Arista(vertice2,distancia));
            adyacencia.get(vertice2).add(new Arista(vertice1,distancia));
        }
    }

    public int coste(String vertice1,String vertice2){

        if(vertice1.equals(vertice2)){
            return 0;
        }
        Arista arista = this.getArista(vertice1, vertice2);
        if(arista != null){
            return arista.distancia;
        }

        return Integer.MAX_VALUE;
    }


    public ArrayList<String> getVertices(){
        
        return vertices;
    }
}