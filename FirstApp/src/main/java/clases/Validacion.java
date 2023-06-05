package clases;

import java.util.ArrayList;
import java.util.List;

public final class Validacion {

    public static List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

    public boolean existeCuenta(String correo, String[] cuentas) {
        for (String cuenta : cuentas) {
            if (correo.equals(cuenta)) {
                return true;
            }
        }
        return false;
    }

    public boolean coincidenContra(String contra1, String contra2){
        return contra1.equals(contra2);
    }
/*
    //Metodo arreglado
    public boolean coincidenContra(String contra1, String contra2){
        try{
            boolean aux = contra1.equals(contra2);
        }catch(Exception ex){
            e.printStackTrace();
        }
        return aux;
    }
*/
}
