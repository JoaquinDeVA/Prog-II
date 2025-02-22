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
    .generate(()-> new double[]{Math.random(), Math.random()})
    .limit(pasos).filter((w) -> w[0]*w[0] + w[1]*w[1] <= 1)
    .count();

        return 4.0 * puntosCirculo / pasos;
    }
}
