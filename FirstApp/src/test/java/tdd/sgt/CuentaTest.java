package tdd.sgt;

import clases.Cuenta;
import org.junit.Test;
import static org.junit.Assert.*;

public class CuentaTest {

    private static final int ITERATIONS = 10000;

    @Test(timeout = 10) // Tiempo límite de 10 milisegundo
    public void given_password_when_encrypt_then_ok() {
        Cuenta cuenta = new Cuenta();
        String password = "1105976292Jh@";

        long startTime = System.currentTimeMillis();
        String contra = cuenta.encriptarContra(password);
        System.out.println("Password encriptada: " + contra);
        String contra1 = cuenta.desencriptarContra(contra);
        System.out.println("Password descriptada: " + contra1);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Tiempo de ejecución promedio: " + (executionTime / ITERATIONS) + " ms");
    }

    @Test
    public void given_apassword_when_validatepasswordformat_then_ok(){
        //Test Unitario: Mock
        iCuenta icuenta = Mockito.mock(iCuenta.class);
        Mockito.when(icuenta.validarFormatoPassword("56978@bc")).thenReturn(true);

        assertTrue(icuenta.validarFormatoPassword("56978@bc"));
    }

    @Test
    public void given_amailaccount_when_validatemailformat_then_ok(){
        //Test Unitario: Coberura de prueba
        String correo = "andres.327@hotmail.com";
        Cuenta cuenta = new Cuenta();
        boolean resultado = cuenta.validarFormatoCorreo(correo);

        assertTrue(resultado);
    }

    @Test
    public void given_anaccount_when_validate_then_ok(){
        //Test Unitario: Caso de exito
        //Arrange: datos necesarios para la prueba
        String correo = "andres.gmail.com";
        String password= "12345";
        //Act: se llama al método validar
        Cuenta cuenta = new Cuenta(correo,password);
        boolean resultado = cuenta.validar(correo, password);
        //Assert
        assertTrue(resultado);
    }
}