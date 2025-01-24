package aplicacion;

import mates.Matematicas;

public class Principal{
    public static void main(String[] args){
        System.out.println("El numero PI es " +
                Matematicas.generarNumeroPiRecursivo(Integer.parseInt(args[0])));
    }
}
