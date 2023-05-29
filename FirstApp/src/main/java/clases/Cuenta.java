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
}
