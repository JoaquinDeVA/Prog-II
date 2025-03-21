package aplicacion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Principal{

    /* Programa que calcula la media armonica.
     * Esta compuesto por dos métodos. Uno principal que transforma la lista de argumentos en una lista de tipo double. 
     * Llama a la funcion mediaArmonica e imprime el resultado por pantalla.
     * 
     * El otro método calcula dada una lista de tipo double su media armonica.
     * 
     * @param Un array de tipo String que representan valores double.
     */
    public static void main (String[] args){

        List<Double> datos = Arrays.stream(args).map(w->Double.parseDouble(w)).collect(Collectors.toList());
        System.out.println(mediaArmonica(datos));
    }
    /*
     * Este método tiene una complejidad algoritmica de O(n) ya que para cada dato de la lista tenemos que calcular su inverso.
     * 
     * @param Una lista compuesta por datos Double.
     * 
     * 
     */
    public static double mediaArmonica(List<Double> datos){

        double resul = 0.0;
        if(datos.isEmpty()){ 
            
            throw new ArithmeticException();
        }

        for(int i=0; i != datos.size();i++){
            
            if(datos.get(i) == 0.0){

                throw new ArithmeticException();
            }
            resul += (double) 1/datos.get(i);
        }

        if(resul == 0.0){

            throw new ArithmeticException();
        }
        resul = datos.size()/resul;
        return resul;
    }
}