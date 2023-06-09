package clases;

import com.example.firstapp.CategoriaEntity;

import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String apellido;
    private int edad;
    private Cuenta cuenta;

    public Cliente(String nombre, String apellido, int edad, Cuenta cuenta){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cuenta = cuenta;
    }

    public boolean iniciarSesion(String correo, String password){
        return cuenta.validar(correo, password);
    }

    public void listarTarea() {
        List<Tarea> listaDeTareas = cuenta.getListaTareas().getListaTareas();
        for(int i=0; i < listaDeTareas.size();i++){
            if(!Objects.isNull(listaDeTareas.get(i))){
                System.out.println(listaDeTareas.get(i));
                System.out.println("--------------");
            }
        }
    }

    public void listarCategoria() {
        List listaDeCategorias = cuenta.getListaCategorias().getListaCategorias();
        for(int i=0; i < listaDeCategorias.size();i++){
            if(!Objects.isNull(listaDeCategorias.get(i))){
                System.out.println(listaDeCategorias.get(i));
                System.out.println("--------------");
            }
        }
    }

    public void buscarTareaPorFecha(String fecha) {
        List<Tarea> tarea = cuenta.getListaTareas().buscarTareaPorFecha(fecha);
        for(int i=0;i<tarea.size();i++){
            if(tarea.get(i) != null){
                System.out.println(tarea.get(i).toString());
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }  
}
