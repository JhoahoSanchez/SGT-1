package clases;

public class Pendiente implements Estado {
    private Tarea tarea;

    @Override
    public void actualizar() {
        tarea.setEstado(new Completado());
    }

    @Override
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}
