import java.util.*;

public class SegundaEntrega {

    /*
     *Ejercicio 1. Explique qué es un método recursivo.
     *Se trata de una funcion que se llama si misma para la resolucion de un problema dividiendo asi
     *el problema del que partimos en problemas mas pequeños o subprogramas.
     */
    
    //Ejercicio 2.Programe las siguientes funciones mediante métodos recursivos

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

        return base * potenciaN(base, n-1);
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
        if(n < 2){
            
            return new ArrayList<>();
        }
        
        if(n%2 == 1){
            
            n--;
        }
        List<Integer> resultado = listaParN(n-2);
        resultado.add(0,n);
        return resultado;
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

    public static boolean comprobarFibonacci(){

        int doce = FibonacciN(12);
        int trece = FibonacciN(13);

        double resultado = (double) trece/doce;

        double esperado = 0.5 + Math.sqrt(5)/2;
        double tolerancia = 1e-4;
            
        if(Math.abs(resultado - esperado) < tolerancia){
            
            return true;
        }
        return false;
    }




    /*Ejercicio 3. ¿En qué consiste el problema de las Torres de Hanoi? ¿Cómo
puede resolverse?

Es un problema donde tenemos una torre formada por discos y tres bases sobre las que contruir.
Se debe mover la torre de una localizacion a otra sin apilar un disco mayor sobre uno menor y 
moviendo un unico disco.
Para resolverlo hay que mover los n-1 discos a la torre auxiliar para poder mover el disco final 
al destino.
Por ejemplo con 3 discos movemos el primero a destino y el segundo a auxiliar, ahora el primer disco
apilado en auxiliar permite que el tercer disco se mueva al destino. Usando el origen ahora podemos 
volver a apilarlos en el destino. */

    public static void hanoi(int n, String inicio, String destino,String auxiliar){
        
        if(n == 1){
        
            mover(inicio,destino);
        }
        hanoi(n-1,inicio,auxiliar,destino);	
        mover(inicio,destino);
        hanoi(n-1,auxiliar,destino,inicio);
    }
    static void mover(String inicio, String destino){
	    System.out.println("Mover de" + inicio + "a" + destino);
    }



   // Ejercicio 4. Escriba un método recursivo con la siguiente cabecera:

    public static double integralEXCuadrado(double limInf, double limSup, double h){
        
        if(limInf >= limSup){
            
            return 0;
        }
        
        return Math.exp(Math.pow(limInf,2))*h + integralEXCuadrado(limInf + h,limSup,h);
    }
    


    /*Ejercicio 5. ¿Por qué la ejecución de un método recursivo puede levantar una excepción de desbordamiento de pila 
con la misma entrada que la versión no recursiva no provoca tal excepción?

Cuando usamos recursividad hacemos una concadenacion de llamadas a una funcion. Internamente este conjunto
de llamadas se almacena en el stack junto con el valor de las variables especificas a cada llamada. Esto
se debe a que las llamadas siguen el comportamiento de una pila donde el ultimo elemento en introducirse (ultima llamada)
es la primera en resolverse (liberar esa seccion de memoria). Como el tamaño de la pila es limitado comparado
con el del heap puede darse un "stack overflow" si un error en nuestro programa o el numero de llamadas necesarias 
es demasiado alto.*/




//Ejercicio 6. Escriba un método recursivo que reciba una cadena de caracteres y devuelva la suma de sus códigos. 


public static int sumaCodigos(String str){

    if(str.isEmpty()){
        return 0;
    }
    return (int) str.charAt(0) + sumaCodigos(str.substring(1));
}

//Ejercicio 7. Escriba un método recursivo que reciba una cadena de caracteres y la transforme según el cifrado de César. 

public static String cifrarCadena(String str, int desplazamiento){

    if(str.isEmpty()){

        return "";
    }
    int caracter = (int) str.charAt(0);

    int base = (caracter >= 'a') ? 'a' : 'A'; //comprueba si el caracter es minuscula al ver si su valor es mayor o igual a "a"

    char transpuesto = (char) ((caracter-base+desplazamiento)%26 + base);

    return (String) (transpuesto + cifrarCadena(str.substring(1),desplazamiento));
}
    
/* Ejercicio 8. Escriba un método recursivo que transforme una cadena de caracteres en otra en la que sólo estén presentes 
los caracteres con código par, y lo estén en el mismo orden en que aparecen en la cadena original.
Por ejemplo, si la cadena de entrada es “Llego mañana”, la de salida será “Ll n”, pues el código de ‘L’ es 76, el de ‘l’ es 108,
el del espacio, 32, etc. Sin embargo, la letra ‘a’, por ejemplo, no aparece porque su código es 97. 
La cabecera del método será la que se muestra a continuación: */

    public static String conCodigoPar(String str){

        if(str.isEmpty()){
        
            return "";
        }
        if((int) str.charAt(0) % 2 == 0){
        
            return str.charAt(0) + conCodigoPar(str.substring(1));
        }
            return conCodigoPar(str.substring(1));
    }
    
}
