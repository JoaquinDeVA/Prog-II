package mates;

public class Matematicas{
    /**
     * * Genera una aproximación al número Pi mediante el método de
     * * Montecarlo. El parámetro `pasos` indica el número de puntos
     * * generado.
     * */
    public static double generarNumeroPiRecursivo(int pasos){
        if(pasos<0){
            throw new IllegalArgumentException("El numero de pasos debe ser positivo o 0");
        }
        return (double) auxiliarNumeroPiRecursivo(pasos,0)/pasos;
    }

    private static long auxiliarNumeroPiRecursivo(int pasos,int resul){
       
        if(pasos == 0){
            return  (4*resul);
        }
        double x = Math.random();
        double y = Math.random();
        if(x*x+y*y<=1){
            resul++;
        }
        return auxiliarNumeroPiRecursivo(pasos - 1, resul);
        
    }
}


