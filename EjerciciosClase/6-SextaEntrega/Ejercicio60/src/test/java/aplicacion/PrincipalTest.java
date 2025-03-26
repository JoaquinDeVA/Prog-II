package aplicacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class PrincipalTest {
    

    @Test
    public void testClasePrincipal(){
        
        String[] entrada = {"3.5","4.5","5.5"};
        Principal.main(entrada);
    }

    @Test
    public void testFuncionalidadMediaArmonica(){

        ArrayList<Double> prueba = new ArrayList<>();
        prueba.add(3.5);
        prueba.add(4.5);
        prueba.add(5.5);
        List<Double> lista = prueba.subList(0,3);
        
        double resul = Principal.mediaArmonica(lista);
        assertEquals(4.35, resul,0.01);
   }

    @Test
    public void testCasosMediaArmonica(){
    
        ArrayList<Double> prueba = new ArrayList<>();
        assertThrows( ArithmeticException.class, () -> Principal.mediaArmonica(prueba));

        prueba.add(2.0);
        prueba.add(-2.0);
        assertThrows( ArithmeticException.class, () -> Principal.mediaArmonica(prueba));

        prueba.add(0.0);
        prueba.remove(1);
        assertThrows( ArithmeticException.class, () -> Principal.mediaArmonica(prueba));
   }
    
    
}
