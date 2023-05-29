package clases;


import com.example.firstapp.CategoriaEntity;

public class Tarea {
    private Fecha fechaCreacion;
    private Fecha fechaVencimiento;
    private CategoriaEntity categoria;
    private RecordatorioTarea recordatorioTarea;
    private String descripcion;
    private Estado estado;
    private RestriccionTarea restriccionTarea = new RestriccionTarea();

    public Tarea(String descripcion, Fecha fechaVencimiento, RecordatorioTarea recordatorioTarea, CategoriaEntity categoria){
        this(descripcion,fechaVencimiento,categoria);
        this.recordatorioTarea = recordatorioTarea;
    }

    public Tarea(String descripcion, Fecha fechaVencimiento, CategoriaEntity categoria){
        restriccionTarea.validarDescripcion(descripcion);
        this.descripcion = descripcion;

        this.fechaCreacion = new Fecha();

        restriccionTarea.validarFecha(fechaVencimiento);
        this.fechaVencimiento = fechaVencimiento;

        //restriccionTarea.validarCategoria(categoria);
        this.categoria =  categoria;
        this.estado = new Pendiente();
        this.estado.setTarea(this);
    }

    public void setEstado(Estado estado){
        this.estado = estado;
        //this.estado.setTarea(this);
    }
    public void cambiarEstado() {
        this.estado.actualizar();
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

    @Override
    public String toString() {
        return "Tarea  con fechaCreacion:" + fechaCreacion + ", fechaVencimiento:" + fechaVencimiento + ", categoria="
                + categoria + ", recordatorioTarea: " + recordatorioTarea + ", descripcion: " + descripcion + ", estado:"
                + estado;
    }


}
