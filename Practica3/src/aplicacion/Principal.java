package aplicacion;

import mates.Matematicas;

public class Principal{
    /** Toma como argumento de programa el numero de pasos y procede a imprimir por pantalla el resultado **/
    public static void main(String[] args){
        System.out.println("El numero PI es " +
                Matematicas.generarNumeroPiIterativo(Integer.parseInt(args[0])));
    }
}
