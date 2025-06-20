

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticaDefensa1 {



    public static int sumaNStream(int n){

        return Stream.iterate(1, i -> i+1).limit(n).reduce(0,(total,w) -> total = total + w);
    }

    public static int SumaParesNStream(int n){

        return Stream.iterate(0, i -> i+2).limit(n/2 + 1).reduce(0,(total,w) -> total = total +w);
    }









    public static boolean esPrimoStream(int n){

        if(IntStream.rangeClosed(2,(int) Math.sqrt(n)).filter(i -> n%i == 0).count() == 0){

            return true;
        }
        return false;
    }

    public static boolean esPrimoIterar(int n){


        for(int i = 0; i < Math.sqrt(n); i++){

            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean esPrimoRecursivo(int n){

        return auxEsPrimoRecursivo(n,2,(int) Math.sqrt(n));
    }

    private static boolean auxEsPrimoRecursivo(int n, int indice,int parada){

        if( indice > parada){
            
            return true;
        }

        if ( n % indice == 0){
            return false;
        }
        return auxEsPrimoRecursivo(n, indice + 1, parada);

    }

    private static int factorial (int n){

        return auxFactorial(n, 1 , 1 );
    }

    private static int auxFactorial(int n, int total, int indice){

        if(indice > n){

            return total;
        }

        total = total*indice;
        return auxFactorial(n, total, indice + 1);
    }

    private static int fibonaccion (int n){

        return auxFinbonacci(n, 0, 1);
    }

    private static int auxFinbonacci ( int n, int a, int b){

        if( n == 0){

            return a;
        }

        int c = a;
        a = b;
        b = c + b;

        return auxFinbonacci(n -1 , a, b);
    }

    private static int fibo(int n){

        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }

        return fibo(n-1) + fibo(n-2);
    }
}