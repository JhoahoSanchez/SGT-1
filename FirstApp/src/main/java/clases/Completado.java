package clases;

public class Completado implements Estado {

    private Tarea tarea;

    @Override
    public void actualizar() {
        tarea.setEstado(new Pendiente());
    }

    @Override
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}
