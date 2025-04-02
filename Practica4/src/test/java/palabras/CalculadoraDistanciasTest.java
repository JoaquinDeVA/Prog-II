package palabras;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDistanciasTest {

    @Test
    public void CalcularTest1(){

        int resul = CalculadoraDistancias.calcularDistancia("perro","gato");
        assertEquals(4, resul);
    }

    @Test
    public void CalcularTest2(){

        int resul = CalculadoraDistancias.calcularDistancia("gato","lata");
        assertEquals(2, resul);
    }

    @Test
    public void CalcularTest3(){

        int resul = CalculadoraDistancias.calcularDistancia("gato","gato");
        assertEquals(0, resul);
    }


}
