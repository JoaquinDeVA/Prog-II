
public class CuartaEntrega{
	
	
//¿Qué es un algoritmo?
	
//34. Un algoritmo es un metodo, consistente de varios pasos, que resuelve un problema.

/*35. Escriba dos algoritmos en Java y esos mismos dos algoritmos
en C para resolver el mismo problema. Por ejemplo, puede escribir un algo-
ritmo recursivo y otro iterativo (con un bucle) para resolver el problema de
la suma de los n primeros números naturales. */	

public static int sumaN (int n){ //Al parecer ambas funciones tienen la misma gramatica en C++
	
	int resul = 0;
	
	while ( n > 0){
		resul += n;
		n--;
	}
	return resul;
}

public static int sumaNRecursivo (int n){
	
	if( n == 0){
		return 0;
	}
	return n + sumaNRecursivo(n - 1);
}

/*36. Defina O(n) en términos de un límite de cociente de funciones. -> f(x)/n = k donde k es un entero */
	
	
	
/*37. La fórmula para calcular el espacio recorrido por un móvil que se deja caer al vacío (suponiendo v0 = 0)
 es e = 1/2 gt^2, donde g es la aceleración de la gravedad en la superficie de la tierra,
 y t el tiempo que está cayendo el móvil. ¿Cuál es la complejidad temporal de este cálculo en función de t?
	
 O(1) ya que para cualquier t solo hay que realizar las operaciones 0.5*g*(t*t)         */




/*38. Indique la complejidad temporal asintótica de los siguientes
métodos:
public static String primero(ArrayList<String> lista){
	return lista.get(0);
}
Tiene una complejidad de O(1)

public static String nEsimo(ArrayList<String> lista, int n){
	return lista.get(n);
}
Tiene una complejidad de O(1) */
	
	
	
	
/*39. Calcule la complejidad temporal de los algoritmos del ejercicio 35.
Ambas tienen una complejidad de O(n). Para una entrada n se ejecutaran n pasos*/
	
	
/*40. Resuelva cualquiera de los apartados del ejercicio 11 y calcule
su complejidad temporal.
	
    public static int sumaN(int n){ // Suma de n numeros:  O(n)

        int suma = 0;
        
        for(int i =0; i<=n; i++){
        
            suma += i;
        }
        return suma;
    }

    public static int factorialN(int n){ // Factorial de n:  O(n)

        int producto = 1;
        
        for(int i =1; i<=n; i++){
        
            producto *= i;
        }
        return producto;
    }

    public static int potenciaN(int base,int n){ // Potencia n-ésima de un numero natural: O(n)

        int resul = 1;
        for(int i = 0;i<n;i++){
            
            resul *= base;
        }
        return resul;
    }

    public static int sumaLista(List<Integer> lista){ //Suma de los elementos de una lista: O(n)

        int suma = 0;
        for(int num : lista){
            
            suma +=  num;
        }
        return suma;
    }

    public static double mediaLista(List<Integer> lista){ //Media de una lista de elementos: O(n)
        
        if(lista.isEmpty()){
            
            return 0;
        }
        
        double media = 0;
        
        for(int num : lista){
        
            media += num ;
        }
        return media/lista.size();
    }


    public static double sumaDesviacionLista(List<Integer> lista){ //Sumatorio de las desviaciones: O(n)


        double media = mediaLista(lista);
        double resultado = 0;

        for(Integer num : lista){
            
            resultado += Math.pow(num - media,2);
        }

        return Math.sqrt(resultado/lista.size()- 1);
    }

    public static int sumaPares(int n){ //Suma de los primeros elementos pares hasta n: O(n)

        int resul = 0;

        if( n % 2 == 1){
            n--;
        }

        while(n>0){

            resul += n;
            n -= 2;
        }
        return resul;
    }

    public static int sumaListaPares(List<Integer> lista){ //suma de los elementos pares de la lista: O(n)

        int resul = 0;

        for (Integer num : lista){

            if( num % 2 == 0){

                resul += num;
            }
        }

        return resul;
    }

    public static List<Integer> obtenerListaPar(List<Integer> lista){ //devuelve una lista con solo numeros pares: O(n)

        List<Integer> resul = new ArrayList<>();

        for (Integer num : lista){

            if( num % 2 == 0){

                resul.add(num);
            }
        }

        return resul;
    }

    public static List<Integer> ListaHastaN(int n){ //devuelve la lista hasta los n terminos pares: O(n)

        List<Integer> lista = new ArrayList<>();
        if( n % 2 == 1){

            n--;
        }
        while(n != 0){
            lista.add(n);
            n -= 2;
        }
        return lista;
    }



    public static int calcularProductoEscalar(List<Integer> lista1,List<Integer> lista2){ //producto vectorial de dos listas: O(n)

        int resul = 0; 

        for(int i = 0; i < lista1.size(); i++){

            resul += (lista1.get(i) * lista2.get(i));
        }
        return resul;
    }



    public static long FibonacciN(int n){ // n termino de la serie de Fibonacci: O(n)

        long a= 0;
        long b = 1;
        long resul = 0;

        if( n == 0){return 0;}
        if( n == 1){return 1;}

        for(int i=2;i < n; i++){

            resul = b + a;
            a = b;
            b= resul;
        }
        return resul; 
    } */
	
	
	
	
	
	
	
	
	
	
/*41. Calcule la complejidad temporal y espacial de cualquiera de los algoritmos (recursivos) del ejercicio 2
 (salvo los referentes a la serie de Fibonacci). Compare dichas complejidades con el algoritmo iterativo para
resolver el mismo problema.



public static int sumaN(int n){  //Suma de n terminos positivos: O(n)
        
        if(n < 0){
	        throw new IllegalArgumentException("El número debe ser positivo.");
        }
        if(n == 0){
	        return 0;
        }

    return n + sumaN(n-1);
    }

    public static int factorialN(int n){	//Factorial de n: O(n)
    
        if(n < 0){
	        
            throw new IllegalArgumentException("El número debe ser positivo.");
        }
        if(n == 0){
	        
            return 1;
        }   

        return n * factorialN(n-1);
    }

    public static int potenciaN(int base, int n){  //Potencia n-ésima de un numero natural: O(log(n))
   
        if(n < 0){
            
            throw new IllegalArgumentException("El número debe ser positivo.");
        }   

        if(n == 0){
            
            return 1; 
        }
        int PotMitad= potenciaN(base, n/2);
        if( n % 2 == 0){
            
            return PotMitad * PotMitad;
        }

        return base * PotMitad * PotMitad;
    }


    public static int sumaLista(List<Integer> lista, int indice){ //Suma de los elementos de una lista: O(n)
	
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){
            
            return 0;
        }
        
        return lista.get(indice) + sumaLista(lista, indice + 1);
    }


    public static double mediaLista(List<Integer> lista){  //Media aritmética de una lista: O(n)
	
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(lista.isEmpty()){
            
            return 0;
        }
        int suma = sumaLista(lista,0);
        return (double) suma/lista.size();
    }

    public static double sumaDesviacionLista(List<Integer> lista, int indice){ //Sumatorio de las desviaciones: O(n)

        double media = mediaLista(lista); //Metodo del apartado 5.
        
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){

            return 0;
        }
        double diferencia = lista.get(indice)-media;
        return Math.pow(diferencia,2) + sumaDesviacionLista(lista, indice+1);
    }

    public static double DesviaciónLista(List<Integer> lista){ 					//Desviación típica de una lista: O(n)
        
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(lista.isEmpty()){
            
            return 0;
        }
        
        double sumaDesviacion = sumaDesviacionLista(lista, 0);
        return Math.sqrt(sumaDesviacion / lista.size());
    }


    public static int sumaPares(int n){		//La suma de los primeros números pares hasta n: O(n) 

        if(n<2){
            
            return 0;
        }
        if(n % 2 == 1){
            
            n--;
        }

        return n + sumaPares(n-2);
    }

    public static int sumaParesLista(List<Integer> lista,int indice){  //La suma de los elementos pares de una lista: O(n)

        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){
            
            return 0;
        }
        if(lista.get(indice) % 2 == 0){
            
            return lista.get(indice) + sumaParesLista(lista,indice+1);
        }else{
            return sumaParesLista(lista,indice+1);
        }
    }

    public static List<Integer> obtenerListaPar(List<Integer> lista,int indice){ //Un nuevo array en el mismo orden de los numeros pares: O(n)
        
        if(lista == null){
            
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(indice < 0 || indice > lista.size()){
            
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == lista.size()){
        
            return new ArrayList<>();
        }
        
        List<Integer> resultado = obtenerListaPar(lista,indice +1);
        if(lista.get(indice) % 2 == 0){
            
            resultado.add(0,lista.get(indice));
        }
        
        return resultado;
    }

    public static List<Integer> listaParN(int n){
        
        if(n < 0){
            
            throw new IllegalArgumentException("El parametro debe ser positivo");
        }	
        
        
        if(n%2 == 1){
            
            n--;
        }
        
        return auxliarListaParN(n, 2, new ArrayList<>());
    }
    private static List<Integer> auxliarListaParN(int n,int indice,List<Integer> resul){

        if(indice > n){
            return resul;
        }
        resul.add(indice);
        return auxliarListaParN(n, indice+ 2, resul);
    }
   
    public static int productoEscalar(List<Integer> vectorA,List<Integer> vectorB,int indice){ // producto escalar de dos vectores O(n)
        
        if(vectorA == null){
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(vectorB == null){
            throw new IllegalArgumentException("La lista no puede ser nula.");
        }	
        if(indice < 0 || indice > vectorA.size()){
            throw new IllegalArgumentException("Indice fuera de rango.");
        }
        if(indice == vectorA.size()){
        
            return 0;
        }
        if(vectorA.size() != vectorB.size()){

            throw new IllegalArgumentException("Los vectores tienen diferente longitud"); 
        }

        return vectorA.get(indice) * vectorB.get(indice) + productoEscalar(vectorA,vectorB,indice+1);
    } */
	
	
	
	
	
	
	
	
	
	
	
	
	
/*42. Sea un conjunto A con cardinalidad n, y sea l un algoritmo que ejecuta una instrucción para cada 
elemento del producto cartesiano de A × A. Calcule la complejidad temporal de l en función de n.

Tendra una complejidad O(n^2) ya que para una cardinalidad n existen n^2 pares ordenados*/
	
	
/*43. Calcule la complejidad temporal del siguiente método:
public static double sumaEltosMatriz(double matriz[][]){
	double suma = 0;
for(int i = 0; i < matriz.length; i++){
	for(int j = 0; j < matriz[i].length; j++){
		suma+=matriz[i][j];
	}
}
return suma;
}
Tendra una complejidad de O(n^2) ya que son dos bucles anidados que van en funcion de la longitud de la matriz*/
	
	
	
/*44.Escriba un algoritmo que busque un número en un array de
enteros. Calcule su complejidad temporal en el caso peor, en el caso mejor y
en el caso promedio. Su cabecera será la siguiente:

public static boolean buscar(int e, int[] array){
	
	int dch = array.length -1;
	int izq = 0;
	
	while(izq <= dch){
	
		medio = (dch - izq)/2;
		
		if(e > array[medio]){
			izq = medio +1;
		}
		else if(e < array[medio]){
			dch = medio -1;
		}
		else if( e == array[medio]){
			return true;
		} 
	}
	return false;
}
En el peor de los casos tiene complejidad O(log(n)), en el mejor O(1) y de promedio O(log(n))
*/
	
	
	
	
/*45. Escriba un algoritmo recursivo para buscar un número en un
array ordenado de enteros. Su cabecerá será la misma que la del ejercicio 43.
Calcule su complejidad en el caso peor*/
	
	
	
	
	
/*46. Calcule las complejidades temporal y espacial del algoritmo
recursivo para calcular el elemento n-ésimo de la sucesión de Fibonacci

La serie de fibonacci tendra una complejidad temporal de O(2^n) y espacial de O(n)*/
	
	
	
/*47. Se tiene el siguiente método. Utilizando el profiler de Netbeans se han medido los tiempos de ejecución
de diferentes llamadas al método (véase el cuadro 1). Explique los resultados

De manera teorica observamos un algoritmo de O(n). Los resultados muestran lo mismo. Cada vez que aumentan en
saltos de *10 el numero de elementos tambien lo hace el tiempo de ejecucion.*/
	
	
	
	
	
/*48. Se tiene el siguiente método: Utilizando el profiler de Netbeans se han medido los tiempos de ejecución
de diferentes llamadas al método (véase el cuadro 2). Explique los resultados

De manera teorica observamos un algoritmo de O(n^2). Los resultados muestran lo mismo. Cada vez que multiplicamos por 
diez el numero de elementos el tiempo de ejecuccion crece 10^2 es decir *100    */
	
	
/*49. Explique la definición que se muestra a continuación:
Sean dos funciones T : N → N y f : N → N. Se dice que T (n) es de orden
f (n), y se escribe T (n) ∈ O(f (n)), si y sólo si existen dos números naturales
k y n0 tales que, para todo m, también natural, que cumpla m > n0, entonces
T (m) ≤ k · f (m).

Si existe un natural k tal que para todo m mayor que n0 se cumple que T(m) es siempre menor o igual a f(m) por k 
podemos afirmar que T(n) pertence a O(f(n)) */
	
	
	
/*50.Asumiendo la definición del ejercicio 49, se pide

1)Para k = 4 y n0 = 0 la definicion anterior cumple que T(n) pertenece a O(log(n))
2)Si, ya que para un k=1 y n0=0 se sigue cumpliendo la igualdad con O(n). Esto se debe a que el ritmo de crecimiento de O(n) es mayor.
3)Si, ya que el cambio de base entre 2 y 3 es una constante por lo que solo habria que cambiar el valor de k.

*/
	

/*51.Estudie de forma comparativa entre ellas el crecimiento de las siguientes funciones reales de variable real:
1. f0(x) = 1,
2. f1(x) = x,
3. f2(x) = x2,
4. f3(x) = log2(x), y
5. f4(x) = 2^x.

El orden de crecimiento es el siguiente, f4>f2>f1>f3>f0 */	
	
	
	
/*52.Calcule la complejidad temporal asintótica del método

public static int f(int n) {
	if (n == 0) return 1;
	else if (n < 0) return -1;
	else{
		int m = 1/f(n/2) + f(n/2);
		return sumaNPrimeros(m);
	}
} 


/*53. La complejidad en el caso peor de la inserción en un array
list es diferente si el array list está ordenado de si no lo está. ¿Es cierta esta
afirmación? Justifique la respuesta.

En uno que no esta ordenado, en el peor de los casos, tendremos que mover los n elementos del arraylist para posicionar
nuestro elemento en la posicion 0. Complejidad O(n). En el caso de tenerlo ordenado tendra una complejidad de busqueda de O(log(n))
y en el peor caso, habra que mover de nuevo O(n) elementos. Como tomamos el mayor de los dos ambos tienen complejidad O(n)*/


/*54. Suponga que una instrucción tarda en ejecutarse 10 ns, y que
el tamaño de la entrada es n = 100, se pide calcular el tiempo requerido para
los siguientes números de ejecuciones. Para hacerlo mas sencillo asusimos base 10:
1. log(n),	-> 2*10ns  = 20ns  				->	50ns			-> 5ms
2. n,		-> 100*10ns = 1000ns			->	1ms				-> 100s
3. nlog(n), ->	100*2*10ns = 2000ns			->	5ms 			-> 500s
4. n2,		-> 100*100*10ns = 100000ns		->	100s			-> 10000000 s
5. n8 y		-> 10^7 s						->	10^32s			-> 10^37 s
6. 10n.		-> 10^92 s						->	10^100000*10ns	-> 10^100000ms
Realice los cálculos anteriores, pero ahora bajo los siguientes supuestos:
1. n = 100.000.
2. n = 100.000 y el tiempo de instrucción (o bloque de instrucciones) 1
ms
*/

/*55. Explique por qué el problema del ajedrez todavía no está
resuelto.

Porque, en el peor de los casos, disponemos de 50 movimientos posibles por turno (seguramente sean mas el calculo es complejo). 
Esto supone explorar las 50 posiblidades lo que lo combierte en una complejidad de O(50^n) para una cantidad normal 
es un numero demasiado grande. Por ejemplo para 10 turnos desde esa posicion y solo uno de los jugadores puede hacer:

97.7 cuatrillones de jugadas distintas
Esto no explora los movimientos del rival ni la longitud promedio o maxima de una partida*/
	
}