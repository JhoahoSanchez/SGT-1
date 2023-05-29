package clases;

import com.example.firstapp.CategoriaEntity;

public class RestriccionTarea {
    public RestriccionTarea(){}

    public void validarDescripcion(String descripcion) {
        if(descripcion.isEmpty()){
            throw new IllegalArgumentException("No puede crear una tarea con descripcion nula");
        }
    }

    public void validarFecha(Fecha fechaVencimiento) {
        if(fechaVencimiento.verificarFecha()){
            throw new IllegalArgumentException("La fecha de vencimiento dede ser mayor a la fecha actual");
        }
    }

    public void validarCategoria(CategoriaEntity categoria) {
        if(categoria.getDescripcion() == null){
            throw new IllegalArgumentException("Debe ingresar una categoria para la tarea");
        }
        if(!existeCategoria(categoria)){
            throw new IllegalArgumentException("Debe ingresar el nombre la descripcion de una de las categorias registradas");
        }
    }

    private boolean existeCategoria(CategoriaEntity categoria) {
        for(CategoriaEntity categorias : Cuenta.listaDeCategorias.getListaCategorias()){
            if( categorias != null && categoria.getDescripcion().equals(categorias.getDescripcion())){
                return true;
            }
        }
        return false;
    }
}
