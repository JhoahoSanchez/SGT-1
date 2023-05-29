package clases;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecordatorioTarea {
    public RecordatorioTarea(){    
    }

    public boolean verificar(Tarea tarea, String nuevaFechaVencimiento) {
        // if( LocalDate.now().isBefore(tarea.getFechaVencimiento().retornarFecha())){
        //     notificar();
        // }
        LocalDate fechaT = LocalDate.parse(nuevaFechaVencimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return tarea.getFechaVencimiento().retornarFecha().isBefore(fechaT);
    }

    private void notificar() {
        throw new IllegalArgumentException("Tienes una tarea sin completar");
    }
}
