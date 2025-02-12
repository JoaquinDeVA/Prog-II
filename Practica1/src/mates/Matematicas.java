package mates;

public class Matematicas{
    /**
     * * Genera una aproximación al número Pi mediante el método de
     * * Montecarlo. El parámetro `pasos` indica el número de puntos
     * * generado.
     * */
    public static double generarNumeroPiIterativo(long pasos){
    long puntosCirculo = 0;
    int j = 1;
        for (long i=0; i<pasos; i++){
            double x = Math.random();
            double y = Math.random();
            if (x*x + y*y <= 1){
                puntosCirculo++;
            }
            if( i >= (pasos-1)*j/10){
                System.out.println("Has alcanzado el: " + (j*10) + "%");
                j++;
            }
        }
        return 4.0 * puntosCirculo / pasos;
    }
}
