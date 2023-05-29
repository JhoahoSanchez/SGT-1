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
        tareas.remove(tarea);
    }

    public List<Tarea> getListaTareas() {
        return this.tareas;
    }

    public boolean existeTarea(Tarea tarea) {
        return tareas.contains(tarea);
    }

    public List<Tarea> buscarTareaPorFecha(String fecha) {
        List<Tarea> tareasEncontradas = new ArrayList<>();
        LocalDate fechaT = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        for (Tarea tarea : tareas) {
            if (tarea != null && tarea.getFechaVencimiento().retornarFecha().equals(fechaT)) {
                tareasEncontradas.add(tarea);
            }
        }
        return tareasEncontradas;
    }

    public void setTareas(List<TareaEntity> tareas, ListaDeCategoria listaDeCategoria, int size) {

        Fecha fechaVencimiento;
        TareaEntity tarea;
        CategoriaEntity categoria1;
        for (int i = 0; i < size; i++) {
            tarea = tareas.get(i);
            fechaVencimiento = new Fecha(tarea.getFechaVencimiento());
            categoria1 = listaDeCategoria.getCategoria(tarea.getCategoria());
            this.tareas.add(new Tarea(tarea.getDescripcion(), fechaVencimiento, categoria1));
        }
    }
}