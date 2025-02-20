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
        return auxiliarNumeroPiRecursivo(pasos,0);
    }

    private static double auxiliarNumeroPiRecursivo(int pasos,int resul){
       
        if(pasos == 0){
            return (double) ((4*resul)/pasos);
        }
        double x = Math.random();
        double y = Math.random();
        if(x*x+y*y<=1){
            return auxiliarNumeroPiRecursivo(pasos - 1, resul++);
        }else{
            return auxiliarNumeroPiRecursivo(pasos - 1, resul);
        }
    }
}


