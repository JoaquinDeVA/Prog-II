package QuintaEntrega.Ejercicio28;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test_EjercicioDos {


    @Test
    void testDesviaciónLista() {
        
        List<Integer> valores = Stream.of(2,4,6,8,9,10,12,13,15).collect(Collectors.toList());
        double resul = EjercicioDos.DesviaciónLista(valores);
        assertEquals(4.07, resul ,0.1);
    }

    @Test
    void testFibonacciN() {

        int resul = EjercicioDos.FibonacciN(8);
        assertEquals(21, resul);
        int resul2 = EjercicioDos.FibonacciN(0);
        assertEquals(0, resul2);

    }

    @Test
    void testFactorialN() {

        int resul = EjercicioDos.factorialN(4);
        assertEquals(24, resul);
    }

    @Test
    void testListaParN() {

        List<Integer> resul = EjercicioDos.listaParN(11);
        List<Integer> valores = Stream.of(2,4,6,8,10).collect(Collectors.toList());
        assertEquals(valores, resul);
    }

    @Test
    void testMediaLista() {

        List<Integer> valores = Stream.of(2,4,6,8,9,10,12,13,15).collect(Collectors.toList());
        double media = EjercicioDos.mediaLista(valores);
        assertEquals(8.77, media,0.01);
    }

    @Test
    void testObtenerListaPar() {
       
        List<Integer> valores = Stream.of(2,4,6,8,9,10,12,13,15).collect(Collectors.toList());
        List<Integer> resul = EjercicioDos.obtenerListaPar(valores, 0);
        List<Integer> esperado = Stream.of(2,4,6,8,10,12).collect(Collectors.toList());
        assertEquals(resul, esperado);
    }

    @Test
    void testPotenciaN() {
        
        int resul = EjercicioDos.potenciaN(3,4);
        assertEquals(81, resul);
    }

    @Test
    void testProductoEscalar() {
        
        List<Integer> valores1 = Stream.of(2,4,6).collect(Collectors.toList());
        List<Integer> valores2 = Stream.of(8,-9,10).collect(Collectors.toList());
        int resul = EjercicioDos.productoEscalar(valores1, valores2, 0);
        assertEquals(40,resul);
    }

    @Test
    void testSumaLista() {

        List<Integer> valores = Stream.of(2,4,6,8,9,10,12,13,15).collect(Collectors.toList());
        int resul = EjercicioDos.sumaLista(valores, 0);
        assertEquals(79,resul);
    }

    @Test
    void testSumaN() {
       
        int resul = EjercicioDos.sumaN(12);
        assertEquals(78, resul);
    }

    @Test
    void testSumaPares() {

        int resul = EjercicioDos.sumaPares(20);
        assertEquals(110, resul);
    }

    @Test
    void testSumaParesLista() {

        List<Integer> valores = Stream.of(2,4,6,8,9,10,12,13,15).collect(Collectors.toList());
        int resul = EjercicioDos.sumaParesLista(valores, 0);
        assertEquals(42,resul);
    }

}
