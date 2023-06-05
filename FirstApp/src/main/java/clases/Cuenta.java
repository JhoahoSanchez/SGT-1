package clases;

import com.example.firstapp.CategoriaEntity;
import com.example.firstapp.CuentaEntity;

public class Cuenta {
    private String correo;
    private String password;
    private ListaDeTarea listaDeTareas;
    public static ListaDeCategoria listaDeCategorias;

    public Cuenta(CuentaEntity cuenta){
        this.correo = cuenta.getDireccionCorreo();
        this.password = cuenta.getContrasena();
        listaDeTareas = new ListaDeTarea();
        listaDeCategorias = new ListaDeCategoria();
    }

    public Cuenta(){}

    public boolean validar(String correo, String password){
        //validar las credenciales de la cuenta
        return this.correo.equals(correo) && this.password.equals(password)?true:false;
    }

    public ListaDeTarea getListaTareas() {
        return listaDeTareas;
    }

    public ListaDeCategoria getListaCategorias() {
        return listaDeCategorias;
    }
     
    // public void registrarTarea(Tarea tarea) {
    //     listaDeTareas.agregarTarea(tarea);
    // }

    public void crearTarea(Tarea tarea) {
        this.listaDeTareas.agregarTarea(tarea);
    }

    public void quitarTarea(Tarea tarea) {
        this.listaDeTareas.quitarTarea(tarea);
    }

    public void cambiarEstadoTarea(Tarea tarea) {
        if(this.listaDeTareas.existeTarea(tarea)){
            tarea.cambiarEstado();
        }
    }

    public void crearCategoria(CategoriaEntity categoria) {
        this.listaDeCategorias.agregarCategoria(categoria);
    }

    public void modificarFechaVencimientoTarea(Tarea tarea, String nuevaFechaVencimiento) {
        if(this.listaDeTareas.existeTarea(tarea)){
            tarea.modificarFechaVencimiento(nuevaFechaVencimiento);
        }
    }

    public String encriptarContra(String password) {
        StringBuilder encryptedPassword = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            char encryptedChar = encryptCharacter(currentChar);
            encryptedPassword.append(encryptedChar);
        }
        return encryptedPassword.toString();
    }

    private char encryptCharacter(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            return (char) ((c - base + 3) % 26 + base);
        }
        return c;
    }

    public String desencriptarContra(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();

        for (int i = 0; i < encryptedPassword.length(); i++) {
            char currentChar = encryptedPassword.charAt(i);
            char decryptedChar = decryptCharacter(currentChar);
            decryptedPassword.append(decryptedChar);
        }

        return decryptedPassword.toString();
    }

    private char decryptCharacter(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            return (char) ((c - base - 3 + 26) % 26 + base);
        }
        return c;
    }

    public boolean validarFormatoCorreo(String correos) {
        String expresionRegular = "^[A-Za-z0-9._]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$";
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
