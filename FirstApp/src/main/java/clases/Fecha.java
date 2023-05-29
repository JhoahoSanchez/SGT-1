package clases;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    private LocalDate fecha;

    public Fecha() {
        this.fecha = LocalDate.now();
    }

    public Fecha(Date date) {
        this.fecha = new Date(date.getTime()).toLocalDate();
    }

    public Fecha(String fecha) {
        this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate retornarFecha() {
        return this.fecha;
    }

    @Override
    public String toString() {
        return fecha.toString();
    }

    public boolean verificarFecha() {
        return LocalDate.now().isAfter(this.retornarFecha());
    }
}
