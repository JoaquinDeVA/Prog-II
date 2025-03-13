package tests.mates;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MatematicasTest {
    @Test
    void testGenerarNumeroPiRecursivo() {

        double piEsperado = mates.Matematicas.generarNumeroPiRecursivo(3000);
        double pi = Math.PI;
        assertEquals(pi, piEsperado, 0.05);
        
    }
}
