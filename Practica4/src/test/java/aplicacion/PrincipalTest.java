package aplicacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PrincipalTest {
 
    @Test
    public void pruebaValida(){

        //No comprueba el valor impreso por pantalla, solo que el codigo ejecuta de principio a fin
        String[] args = new String[]{"Perro","gato"};
        Principal.main(args);
    }
}
