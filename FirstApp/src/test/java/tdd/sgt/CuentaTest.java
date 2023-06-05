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
}