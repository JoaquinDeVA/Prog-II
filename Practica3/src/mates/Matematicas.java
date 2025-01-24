package mates;

import java.util.stream.Stream;

public class Matematicas{
    /**
     * * Genera una aproximación al número Pi mediante el método de
     * * Montecarlo. El parámetro `pasos` indica el número de puntos
     * * generado.
     * */
    public static double generarNumeroPiIterativo(long pasos){
    long puntosCirculo = Stream
        .generate(() -> new double[]{Math.random(),Math.random()})
        .limit(pasos)
        .filter(punto -> punto[0]*punto[0] + punto[1]*punto[1] <= 1)
        .count(); 

        return 4.0 * puntosCirculo / pasos;
    }
}
