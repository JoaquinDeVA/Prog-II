package mates;

public class Matematicas{
    /**
     * * Genera una aproximación al número Pi mediante el método de
     * * Montecarlo. El parámetro `pasos` indica el número de puntos
     * * generado.
     * */
    public static double generarNumeroPiIterativo(long pasos,long contador){
        
        if(contador== 0){
            return 0;
        }
        double x = Math.random();
        double y = Math.random();
        if(x*x+y*y<=1){
            return (double) 4/pasos + generarNumeroPiIterativo(pasos,contador-1);
        }else{
            return generarNumeroPiIterativo(pasos,contador-1);
        }
    }
}
