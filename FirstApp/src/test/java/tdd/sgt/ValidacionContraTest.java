package tdd.sgt;

import clases.Validacion;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidacionContraTest {

    //El sistema verificará que la confirmación de la contraseña coincida con la contraseña anteriormente digitada.
    @Test
    public void given_two_strings_when_match_then_ok(){ //Caso normal
        Validacion validacion = new Validacion();
        assertEquals(true, validacion.coincidenContra("null", "null"));
    }

    @Test (expected = NullPointerException.class)
    public void given_two_strings_when_match_then_exception(){ //Caso de fallo
        Validacion validacion = new Validacion();
        assertEquals(true, validacion.coincidenContra(null, "null"));
    }
}
