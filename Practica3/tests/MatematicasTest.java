package tests;

import lib.*;
import mates.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
public class MatematicasTest {
    

    private long pasos = 100000;
    
    @Test
    void testGenerarNumeroPiIterativo() {

        double pi = Math.PI;Matematicas.generarNumeroPiIterativo(pasos);
        double piEsperado = Math.PI;
        double tolerancia = 0.02;

        assertEquals(pi, piEsperado, tolerancia);
    }
}
