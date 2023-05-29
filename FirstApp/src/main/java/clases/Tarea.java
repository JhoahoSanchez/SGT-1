package clases;


import com.example.firstapp.CategoriaEntity;

public class Tarea {
    private Fecha fechaCreacion;
    private Fecha fechaVencimiento;
    private CategoriaEntity categoria;
    private RecordatorioTarea recordatorioTarea;
    private String descripcion;
    private Estado estado;

    public Tarea(String descripcion, Fecha fechaVencimiento, CategoriaEntity categoria, Estado estado){
        if(descripcion.isEmpty()){
            throw new IllegalArgumentException("No puede crear una tarea con descripcion nula");
        }
        this.descripcion = descripcion;

        this.fechaCreacion = new Fecha();
        if(fechaVencimiento == null){
            throw new IllegalArgumentException("Debe seleccionar la fecha de vencimiento");
        }
        this.fechaVencimiento = fechaVencimiento;
        if(categoria.getDescripcion().equals("")){
            throw new IllegalArgumentException("Debe ingresar una categoria para la tarea");
        }
        //if(!existeCategoria(categoria)){
          //  throw new IllegalArgumentException("Debe ingresar el nombre la descripcion de una de las categorias registradas");
        //}
        this.categoria =  categoria;
        this.estado = estado;
    }

    public Tarea(String descripcion, Fecha fechaVencimiento, RecordatorioTarea recordatorioTarea, CategoriaEntity categoria, Estado estado){
        if(descripcion.isEmpty()){
            throw new IllegalArgumentException("No puede crear una tarea con descripcion nula");
        }
        this.descripcion = descripcion;
        this.fechaCreacion = new Fecha();
        if(fechaVencimiento == null){
            throw new IllegalArgumentException("Debe seleccionar la fecha de vencimiento");
        }
        this.fechaVencimiento = fechaVencimiento;
        this.recordatorioTarea = recordatorioTarea;
        if(categoria.getDescripcion().equals("")){
            throw new IllegalArgumentException("Debe ingresar una categoria para la tarea");
        }

        if(!existeCategoria(categoria)){
            throw new IllegalArgumentException("Debe ingresar el nombre la descripcion de una de las categorias registradas");
        }
        this.categoria = categoria;
        this.estado = estado;
    }

    public void cambiarEstado() {
        if(this.estado.actualizar() == 0){
            this.estado = new Completado();
        }else{ this.estado = new Pendiente();}
    }

    public void modificarFechaVencimiento(String nuevaFechaVencimiento) {
        if(recordatorioTarea == null){
            this.fechaVencimiento = new Fecha(nuevaFechaVencimiento);
        }else{
            if(recordatorioTarea.verificar(this, nuevaFechaVencimiento)){
                this.fechaVencimiento = new Fecha(nuevaFechaVencimiento);
            }else{System.out.println("No puede ingresar una fecha de vencimiento anterior a la ya establecida");}
        }
    }

    private boolean existeCategoria(CategoriaEntity categoria) {
        return Cuenta.listaDeCategorias.getListaCategorias().contains(categoria);
    }

    public Fecha getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaVencimiento(Fecha fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public RecordatorioTarea getRecordatorioTarea() {
        return recordatorioTarea;
    }

    public void setRecordatorioTarea(RecordatorioTarea recordatorioTarea) {
        this.recordatorioTarea = recordatorioTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea  con fechaCreacion:" + fechaCreacion + ", fechaVencimiento:" + fechaVencimiento + ", categoria="
                + categoria + ", recordatorioTarea: " + recordatorioTarea + ", descripcion: " + descripcion + ", estado:"
                + estado;
    }


}
