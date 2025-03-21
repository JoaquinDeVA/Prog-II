package aplicacion;

public class Principal {
    
    /* Aproximacion de e^x mediante el metodo Taylor. 
     * 
     * Cuanto mayor sea el valor de n (fijado a 10 en este caso) mas cercana sera la aproximacion. 
     * En la formula observamos como el cociente tiene un divisor que crece mucho mas rapido (factorial); lo que nos da esta idea
     * de que en pasos mas elevados obtenemos decimales cada vez menos relevantes respecto a la unidad.
     * 
     */
    public static void main(String[] args){

        System.out.println(calcularTaylorIterativo(Integer.parseInt(args[0])));

        System.out.println(calcularTaylorRecursivo(Integer.parseInt(args[0])));
        
    }
    /*
     *  @param Especifica a cuanto esta elevada la funcion e.
     */
    public static double calcularTaylorIterativo(int x){

        double total = 0.0;
        int factorial = 1;
        int potencia = 1;

        for(int i=0;i<=10;i++){
           
            for(int j=0;j<i;j++){
                potencia *=x;
            }

            if( i != 0){
                factorial *= i;
            }

            total += (double) potencia/factorial;
            potencia = 1;
        }
        return total;
    }
    /*
     *  @param Especifica a cuanto esta elevada la funcion e.
     */
    public static double calcularTaylorRecursivo(int x){

        return calcularTaylorRecursivoAux(x,0,0.0,1);
    }
    /* Funcion auxiliar para calcular la aproximación Taylor recursivamente. Metodo privado para mantener la abstraccion del programa.
     *  @param Especifica a cuanto esta elevada la funcion e. El paso actual del sumatorio, el total y el calculo del factorial arrastrado.
     */
    private static double calcularTaylorRecursivoAux(int x,int k,double total,int factorial){

        if ( k != 0){
           factorial *= k;
        }

        if(k == 10){
            
           return total += (double) potencia(x,k,1)/factorial;
        }
        total += (double) potencia(x,k,1)/factorial;
        return calcularTaylorRecursivoAux(x, k + 1, total, factorial);

    }
    /*  Esta funcion cuenta con un parametro extra para poder tener constancia de cuando el exponente introducido es 0.
     *  @param Donde x es la base, el parametro n el exponente y el indice un marcador de recorrido.
     */
    private static int potencia ( int x, int n, int indice){
        if( n == 0){
            return 1;
        }
        if( n == indice){
            return x;
        }
        return x * (potencia(x,n, indice +1));
    }
}
