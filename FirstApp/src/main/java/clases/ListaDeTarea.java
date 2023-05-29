package clases;

import com.example.firstapp.CategoriaEntity;
import com.example.firstapp.TareaEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListaDeTarea {
    private List<Tarea> tareas;
    private final int NUM_MAXIMO_TAREAS = 25;

    public ListaDeTarea() {
        this.tareas = new ArrayList<Tarea>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public int obtenerNumeroDeTareas() {
        return tareas.size();
    }

    public void quitarTarea(Tarea tarea) {
        for (int i = 0; i < obtenerNumeroDeTareas(); i++) {
            if (tareas.get(i).equals(tarea)) {
                tareas.remove(i);
                break;
            }
        }
    }

    public List<Tarea> getListaTareas() {
        return this.tareas;
    }

    public boolean existeTarea(Tarea tarea) {
        return tareas.contains(tarea);
    }

    public Tarea[] buscarTareaPorFecha(String fecha) {
        Tarea[] tareasEncontradas = new Tarea[25];
        int numeroDeTarea = 0;
        LocalDate fechaT = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        for (int i = 0; i < obtenerNumeroDeTareas(); i++) {
            if (tareas.get(i) != null && tareas.get(i).getFechaVencimiento().retornarFecha().equals(fechaT)) {
                tareasEncontradas[numeroDeTarea] = tareas.get(i);
                numeroDeTarea++;
            }
        }
        return tareasEncontradas;
    }

    public void setTareas(List<TareaEntity> tareas, ListaDeCategoria listaDeCategoria, int size) {

        Fecha fechaVencimiento;
        TareaEntity tarea;
        Pendiente pendiente = new Pendiente();
        CategoriaEntity categoria1;
        for (int i = 0; i < size; i++) {
            tarea = tareas.get(i);
            fechaVencimiento = new Fecha(tarea.getFechaVencimiento());
            categoria1 = listaDeCategoria.buscarCategoria(tarea.getCategoria());
            this.tareas.add(new Tarea(tarea.getDescripcion(), fechaVencimiento, categoria1, pendiente));
        }
    }
}