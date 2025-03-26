package QuintaEntrega.Ejercicio28;

import java.util.ArrayList;
import java.util.List;

public class EjercicioDos {

      public static int sumaN(int n){  //Suma de n terminos positivos
        
        if(n < 0){
	        throw new IllegalArgumentException("El número debe ser positivo.");
        }
        if(n == 0){
	        return 0;
        }

    return n + sumaN(n-1);
    }

    public static int factorialN(int n){	//Factorial de n
    
        if(n < 0){
	        
            throw new IllegalArgumentException("El número debe ser positivo.");
        }
        if(n == 0){
	        
            return 1;
        }   

        return n * factorialN(n-1);
    }

    public static int potenciaN(int base, int n){  //Potencia n-ésima de un numero natural
   
        if(n < 0){
            
            throw new IllegalArgumentException("El número debe ser positivo.");
        }   

        if(n == 0){
            
            return 1; 
        }
        int PotMitad= potenciaN(base, n/2);
        if( n % 2 == 0){
            
            return PotMitad * PotMitad;
        }

        return base * PotMitad * PotMitad;
    }


    public static int sumaLista(List<Integer> lista, int indice){ //Suma de los elementos de una lista
	
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){
            
            return 0;
        }
        
        return lista.get(indice) + sumaLista(lista, indice + 1);
    }


    public static double mediaLista(List<Integer> lista){  //Media aritmética de una lista
	
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(lista.isEmpty()){
            
            return 0;
        }
        int suma = sumaLista(lista,0);
        return (double) suma/lista.size();
    }

    public static double sumaDesviacionLista(List<Integer> lista, int indice){ //Sumatorio de las desviaciones

        double media = mediaLista(lista); //Metodo del apartado 5.
        
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){

            return 0;
        }
        double diferencia = lista.get(indice)-media;
        return Math.pow(diferencia,2) + sumaDesviacionLista(lista, indice+1);
    }

    public static double DesviaciónLista(List<Integer> lista){ 					//Desviación típica de una lista
        
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(lista.isEmpty()){
            
            return 0;
        }
        
        double sumaDesviacion = sumaDesviacionLista(lista, 0);
        return Math.sqrt(sumaDesviacion / lista.size());
    }


    public static int sumaPares(int n){		//La suma de los primeros números pares hasta n

        if(n<2){
            
            return 0;
        }
        if(n % 2 == 1){
            
            n--;
        }

        return n + sumaPares(n-2);
    }

    public static int sumaParesLista(List<Integer> lista,int indice){  //La suma de los elementos pares de una lista

        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){
            
            return 0;
        }
        if(lista.get(indice) % 2 == 0){
            
            return lista.get(indice) + sumaParesLista(lista,indice+1);
        }else{
            return sumaParesLista(lista,indice+1);
        }
    }

    public static List<Integer> obtenerListaPar(List<Integer> lista,int indice){ //Un nuevo array en el mismo orden de los numeros pares
        
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){
        
            return new ArrayList<>();
        }
        
        List<Integer> resultado = obtenerListaPar(lista,indice +1);
        if(lista.get(indice) % 2 == 0){
            
            resultado.add(0,lista.get(indice));
        }
        
        return resultado;
    }

    public static List<Integer> listaParN(int n){
        
        if(n < 0){
            
            throw new IllegalArgumentException("El parametro debe ser positivo");
        }	
        
        
        if(n%2 == 1){
            
            n--;
        }
        
        return auxliarListaParN(n, 2, new ArrayList<>());
    }
    private static List<Integer> auxliarListaParN(int n,int indice,List<Integer> resul){

        if(indice > n){
            return resul;
        }
        resul.add(indice);
        return auxliarListaParN(n, indice+ 2, resul);
    }
   
    public static int productoEscalar(List<Integer> vectorA,List<Integer> vectorB,int indice){
        
        if(vectorA == null){
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(vectorB == null){
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(indice < 0 || indice > vectorA.size()){
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == vectorA.size()){
        
            return 0;
        }
        if(vectorA.size() != vectorB.size()){

            throw new IllegalArgumentException("Los vectores tienen diferente longitud"); 
        }

        return vectorA.get(indice) * vectorB.get(indice) + productoEscalar(vectorA,vectorB,indice+1);
    }


    public static int FibonacciN(int n){ //Elemento n-ésimo de la sucesion de Fibonacci
        
        if(n<0){
            throw new IllegalArgumentException("El valor de n no puede ser negativo"); 
        }
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return FibonacciN(n-1) + FibonacciN(n-2);
    }

    
}
