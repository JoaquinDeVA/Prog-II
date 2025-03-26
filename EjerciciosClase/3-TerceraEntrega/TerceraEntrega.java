package terceraEntrega;


import java.util.stream.*;
import java.util.*;
import java.util.function.Function;
public class TerceraEntrega{


/*  Ejercicio 12. Explique qué es una expresión lambda.

 Una expresion lambda es una implementacion especifica o funcion anonima de una interfaz funcional 
(aquella que tiene un unico método abstracto)  */


/* Ejercicio 13. Para ello se pide resolver el ejercicio 4 de
tal forma que sea aplicable a diferentes funciones reales de variable real. La
cabecera el método ha de ser la que se muestra a continuación: */

  
public static double integralA(double a, double b, double h,Function<Double, Double> funcion){
      
    if ( a >= b){
        return 0;
    }
    return funcion.apply(a)*h + integralA(a+h, b, h, funcion);
}

public static double integralB(double a, double b, double h,Function<Double, Double> funcion){

    double resul = 0;
    while(a < b){

        resul += funcion.apply(a)*h;
        a += h;
    }
    return resul;
}

/* Ejercicio 14. Resuelva los siguientes apartados:
1. Genere un stream de números mediante el método estático of de la
clase IntStream. */

IntStream numerosOf = IntStream.of(1,2,3,4,5,6,7,8,9,10);

/* 2. Genere un stream de números mediante el método estático range de
la clase IntStream */

IntStream numerosRange = IntStream.range(1,11);   //El uno va incluido y el 11 excluido

/* 3. Genere un stream de números mediante el método estático iterate
de la clase IntStream. */

IntStream numerosIterate = IntStream.iterate(1,(w) -> w + 1);

/* 4. Generer un stream de números aleatorios utilizando el método doubles
de la clase Random. */

Random generator = new Random();
DoubleStream numerosRandom = generator.doubles(); 
    
public double  practica(){

    return new Random().doubles().reduce((total,w)-> total + w)
    .orElseThrow(() -> new IllegalArgumentException("No hay elementos en la media"));
}



/* Ejercicio 15. Resuleva los apartados del 1 al 12 del ejercicio 2, ambos
inclusive, mediante expresiones lambda y streams */


    public static int sumaN(int n){ //Suma de los primeros n elementos
        
        if(n < 0){
            throw new IllegalArgumentException("El valor de n debe ser mayor o igual a 0");
        }
        
        return IntStream.range(1,n + 1).sum();
    }

    public static int factorialN(int n){ //Factorial de n

        if(n<0){
            throw new IllegalArgumentException("El valor de n debe ser mayor o igual a 0");
        }

        return IntStream.rangeClosed(1, n).reduce(1,(total,w) -> total * w);
    }

    public static int potenciaN(int base, int n){

        if(n<0){

            return 0;
        }

        return IntStream.range(0, n).reduce(1,(total,w) -> total * base);
        // Alternativa :return IntStream.generate(() -> base).limit(n).reduce(1,(total,w) -> total * w);
    }

    public static int sumaLista(List<Integer> lista){
        
        if(lista == null){
            throw new IllegalArgumentException("La lista no debe ser nula");
        }

        return lista.stream().reduce(0,(total,w) -> total + w);
    }

    public static double mediaLista(List<Integer> lista){

        if(lista == null){
            throw new IllegalArgumentException("La lista no debe ser nula");
        }

        double total = sumaLista(lista);
        Stream<Integer> listaS = lista.stream();
        return total/listaS.count();
    }

    //DESVIACION

    public static int sumaParesHastaN( int n){

        return Stream.iterate(2,w -> w + 2).limit(n/2).reduce(0,(resul,w) -> resul + w);
    }

    public static int sumaListaPares (List<Integer> lista){

        Stream<Integer> listaS = lista.stream();
        return listaS.filter((w) -> w % 2 == 0).reduce(0,(resul,w) -> resul + w);
    }

    public static List<Integer> listaPares (List<Integer> lista){ // Elementos de la lista que son pares

        return lista.stream().filter((w) -> w % 2 == 0).toList();
    }

    public static List<Integer> listaParesHastaN (int n){ //Lista de los numeros pares hasta n

        return Stream.iterate(2,(w) -> w + 2).limit(n/2).toList();
    }

    public static int productoEscalar(List<Integer> lista1, List<Integer> lista2){

        return IntStream.range(0, lista1.size()).map((w) ->lista1.get(w)*lista2.get(w)).sum();

        // hasta size ya que no esta incluido (generamos indice), y aplicamos transformacion con map
    }

    public static long fibonacciN (int n){

        return Stream
        .iterate(new long[]{0,1},(f) -> new long[]{f[1], f[0] + f[1]})
        .limit(n)
        .map((f) -> f[1])
        .reduce((resul,w) -> w)
        .orElseThrow();
    }
    
    
    
    
    /*Ejercicio 16. Resuelva el ejercicio 13 utilizando, no sólo expresiones lambda
sino también streams */

    public static double integral(double a, double b, double h,Function<Double, Double> funcion){
      
        return Stream.iterate( new double[]{a,a+h},(w) -> new double[]{w[1],w[1]+h})
        .takeWhile((w) -> w[0] <= b)
        .map((w) -> funcion.apply(w[0]) * h)
        .reduce(0.0,(resul,w) -> resul + w);
    }



    public static void main(String[] args){

        System.out.println("Integral de 0 a 10 y = x^2: " + integralA(0, 10, 0.1, (w) -> w*w));
        System.out.println("Integral de 0 a 10 y = x^2: " + integralB(0, 10, 0.1, (w) -> w*w));


        System.out.println("Suma de los primeros 10 elementos : " + sumaN(10));

        System.out.println("Factorial de 5 : " + factorialN(5));

        System.out.println("Potencia de 4 a la 3 : " + potenciaN(4,3));

        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(4);
        lista.add(8);
        System.out.println("Suma de la lista : " + sumaLista(lista));

        System.out.println("La media de la lista es :" + mediaLista(lista));

        System.out.println("La suma de los elementos pares hasta 21: "+sumaParesHastaN(21) );

        System.out.println("Suma elementos pares de la lista : " + sumaListaPares(lista));

        System.out.println("Lista con solo elementos pares : " + listaPares(lista));

        System.out.println("Lista con solo elementos pares hasta 21: " + listaParesHastaN(21));

        List<Integer> lista2 = new ArrayList<>();
        lista2.add(3);
        lista2.add(2);
        lista2.add(1);

        System.out.println("Producto escalar de dos listas : " + productoEscalar(lista,lista2));

        System.out.println("El elemento numero 8 de la serie de fibonacci: " + fibonacciN(8));

        System.out.println("Integral de 0 a 10 y = x^2: " + integral(0, 10, 0.1, (w) -> w*w));

    }
}