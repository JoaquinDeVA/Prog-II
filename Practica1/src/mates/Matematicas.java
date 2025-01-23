package mates;

public class Matematicas{
    /**
     * * Genera una aproximación al número Pi mediante el método de
     * * Montecarlo. El parámetro `pasos` indica el número de puntos
     * * generado.
     * */
    public static double generarNumeroPiIterativo(long pasos){
    int puntos = 0;
        for (int i=0; i<pasos; i++){
            double x = Math.random();
            double y = Math.random();
            if (x*x + y*y < 1){
                puntos++;
            }
        }
        return 4.0 * puntos / pasos;
    }
}
