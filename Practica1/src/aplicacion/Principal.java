package aplicacion;

import mates.Matematicas;

public class Principal{
    public static void main(String[] args){
        System.out.println("El numero PI es " +
                Matematicas.generarNumeroPiIterativo(Long.parseLong(args[0])));
    }
}
