package tdd.sgt;


import clases.Validacion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class ValidacionCuentaTest {

    private String[] listaCuenta;
    private String correo;
    private boolean expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"jhoaho2001@gmail.com", new String[]{"jhoaho2001@gmail.com", "46156456@mail.ex", "asdaseq@pepe.net", "dqwqeqweqw@meme.nes"}, true});
        objects.add(new Object[]{"46156456@mail.ex", new String[]{"jhoaho2001@gmail.com", "46156456@mail.ex", "asdaseq@pepe.net", "dqwqeqweqw@meme.nes"}, true});
        objects.add(new Object[]{"asdaseq@pepe.net", new String[]{"jhoaho2001@gmail.com", "46156456@mail.ex", "asdaseq@pepe.net", "dqwqeqweqw@meme.nes"}, true});
        objects.add(new Object[]{"dqwqeqweqw@meme.nes", new String[]{"jhoaho2001@gmail.com", "46156456@mail.ex", "asdaseq@pepe.net", "dqwqeqweqw@meme.nes"}, true});
        objects.add(new Object[]{"pinpon@gmail.com", new String[]{"jhoaho2001@gmail.com", "46156456@mail.ex", "asdaseq@pepe.net", "dqwqeqweqw@meme.nes"}, false});
        return objects;
    }

    public ValidacionCuentaTest(String correo, String[] listaCuenta, boolean expected) {
        this.listaCuenta = listaCuenta;
        this.correo = correo;
        this.expected = expected;
    }

    @Test
    public void given_list_when_exist_then_error() { //Parametrizada
        Validacion validacion = new Validacion();
        boolean actual = validacion.existeCuenta(correo, listaCuenta);
        assertEquals(expected, actual);
    }
}
