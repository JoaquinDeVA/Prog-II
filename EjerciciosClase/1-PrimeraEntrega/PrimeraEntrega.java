import java.util.*;


public class PrimeraEntrega {

        
    public static int sumaN(int n){ // Suma de n numeros

        int suma = 0;
        
        for(int i =0; i<=n; i++){
        
            suma += i;
        }
        return suma;
    }

    public static int factorialN(int n){ // Factorial de n

        int producto = 1;
        
        for(int i =1; i<=n; i++){
        
            producto *= i;
        }
        return producto;
    }

    public static int potenciaN(int base,int n){ // Potencia n-ésima de un numero natural

        int resul = 1;
        for(int i = 0;i<n;i++){
            
            resul *= base;
        }
        return resul;
    }

    public static int sumaLista(List<Integer> lista){ //Suma de los elementos de una lista

        int suma = 0;
        for(int num : lista){
            
            suma +=  num;
        }
        return suma;
    }

    public static double mediaLista(List<Integer> lista){ //Media de una lista de elementos
        
        if(lista.isEmpty()){
            
            return 0;
        }
        
        double media = 0;
        
        for(int num : lista){
        
            media += num ;
        }
        return media/lista.size();
    }


    public static double sumaDesviacionLista(List<Integer> lista){ //Sumatorio de las desviaciones


        double media = mediaLista(lista);
        double resultado = 0;

        for(Integer num : lista){
            
            resultado += Math.pow(num - media,2);
        }

        return Math.sqrt(resultado/lista.size()- 1);
    }

    public static int sumaPares(int n){ //Suma de los primeros elementos pares hasta n

        int resul = 0;

        if( n % 2 == 1){
            n--;
        }

        while(n>0){

            resul += n;
            n -= 2;
        }
        return resul;
    }

    public static int sumaListaPares(List<Integer> lista){ //suma de los elementos pares de la lista

        int resul = 0;

        for (Integer num : lista){

            if( num % 2 == 0){

                resul += num;
            }
        }

        return resul;
    }

    public static List<Integer> obtenerListaPar(List<Integer> lista){ //devuelve una lista con solo numeros pares

        List<Integer> resul = new ArrayList<>();

        for (Integer num : lista){

            if( num % 2 == 0){

                resul.add(num);
            }
        }

        return resul;
    }

    public static List<Integer> ListaHastaN(int n){ //devuelve la lista hasta los n terminos pares

        List<Integer> lista = new ArrayList<>();
        if( n % 2 == 1){

            n--;
        }
        while(n != 0){
            lista.add(n);
            n -= 2;
        }
        return lista;
    }



    public static int calcularProductoEscalar(List<Integer> lista1,List<Integer> lista2){ //producto vectorial de dos listas

        int resul = 0; 

        for(int i = 0; i < lista1.size(); i++){

            resul += (lista1.get(i) * lista2.get(i));
        }
        return resul;
    }



    public static long FibonacciN(int n){ // n termino de la serie de Fibonacci

        long a= 0;
        long b = 1;
        long resul = 0;

        if( n == 0){return 0;}
        if( n == 1){return 1;}

        for(int i=2;i < n; i++){

            resul = b + a;
            a = b;
            b= resul;
        }
        return resul;
    }
    public static void main(String[] args) {
        // Probamos las funciones de la clase PrimeraEntrega
        System.out.println("Suma de los primeros 10 números: " + PrimeraEntrega.sumaN(10));
        System.out.println("Factorial de 5: " + PrimeraEntrega.factorialN(5));
        System.out.println("Potencia de 2^4: " + PrimeraEntrega.potenciaN(2, 4));

        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lista2 = Arrays.asList(2, 4, 6, 8, 10, 12);
        
        System.out.println("Suma de la lista: " + PrimeraEntrega.sumaLista(lista));
        System.out.println("Media de la lista: " + PrimeraEntrega.mediaLista(lista));
        System.out.println("Sumatorio de las desviaciones de la lista: " + PrimeraEntrega.sumaDesviacionLista(lista));
        System.out.println("Suma de los primeros pares hasta 10: " + PrimeraEntrega.sumaPares(10));
        System.out.println("Suma de los elementos pares de la lista: " + PrimeraEntrega.sumaListaPares(lista));
        
        List<Integer> listaPares = PrimeraEntrega.obtenerListaPar(lista);
        System.out.println("Lista con solo números pares: " + listaPares);
        
        List<Integer> listaHastaN = PrimeraEntrega.ListaHastaN(10);
        System.out.println("Lista de pares hasta 10: " + listaHastaN);
        
        System.out.println("Producto escalar de lista1 y lista2: " + PrimeraEntrega.calcularProductoEscalar(lista, lista2));
        System.out.println("10º término de la serie de Fibonacci: " + PrimeraEntrega.FibonacciN(10));
    }
}

