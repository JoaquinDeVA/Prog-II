package aplicacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrincipalTest {
    
    @Test
    public void PruebaSoluciones(){

        Principal.main(new String[]{"5"});
    }
    @Test
    public void pruebaCalculoIterativo(){

        double resul = Principal.calcularTaylorIterativo(2);
        assertEquals(7.38,resul,0.1);

        resul = Principal.calcularTaylorIterativo(5);
        assertEquals(146.381,resul,0.1);

    }

    @Test
    public void pruebaCalculoRecursivo(){

        double resul = Principal.calcularTaylorRecursivo(2);
        assertEquals(7.38,resul,0.1);

        resul = Principal.calcularTaylorRecursivo(5);
        assertEquals(146.381,resul,0.1);

    }
    
    
}
