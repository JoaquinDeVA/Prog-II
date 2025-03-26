package terceraEntrega;


import java.util.*;
import java.util.stream.*;
public class Personas {
    
    private ArrayList<Persona> personas;

    public Personas(){

        personas = new ArrayList<>();
    }

    public void annadirPersona(Persona persona){

        personas.add(persona);
    }

    public Persona elMasJoven(){

        return personas.stream().min(Comparator.comparingLong((w) -> (w.calcularEdad())))
        .orElseThrow(() -> new IllegalStateException("No hay personas"));
    }


    public long calcularSumaEdades(){

        return IntStream
        .range(0,personas.size())
        .map((i) -> (int) personas.get(i).calcularEdad())
        .reduce((acumulador,w) -> acumulador + w)
        .orElseThrow(() -> new IllegalStateException("No hay personas"));
    }

    public long calcularEdadMinima(){

        return  IntStream
        .range(0,personas.size())
        .map((i) -> (int) personas.get(i).calcularEdad())
        .min()
        .orElseThrow(() -> new IllegalStateException("No hay personas"));
    }

    public double calcularMediaDeEdad(){

        return IntStream
        .range(0,personas.size())
        .map((i) -> (int) personas.get(i).calcularEdad())
        .average()
        .orElseThrow(() -> new IllegalStateException("No hay personas"));
    }
}


