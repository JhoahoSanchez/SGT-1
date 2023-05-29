package com.example.firstapp;

import java.sql.Date;

public class TareaEntity {
    private int idTarea;
    private Date fechaCreacion;
    private Date fechaVencimiento;
    private Integer categoria;
    private Integer estado;
    private String descripcion;
    private String direccionCorreo;
    private Byte notificar;

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public Byte getNotificar() {
        return notificar;
    }

    public void setNotificar(Byte notificar) {
        this.notificar = notificar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TareaEntity that = (TareaEntity) o;

        if (idTarea != that.idTarea) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(that.fechaCreacion) : that.fechaCreacion != null)
            return false;
        if (fechaVencimiento != null ? !fechaVencimiento.equals(that.fechaVencimiento) : that.fechaVencimiento != null)
            return false;
        if (categoria != null ? !categoria.equals(that.categoria) : that.categoria != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (direccionCorreo != null ? !direccionCorreo.equals(that.direccionCorreo) : that.direccionCorreo != null)
            return false;
        if (notificar != null ? !notificar.equals(that.notificar) : that.notificar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTarea;
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + (fechaVencimiento != null ? fechaVencimiento.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (direccionCorreo != null ? direccionCorreo.hashCode() : 0);
        result = 31 * result + (notificar != null ? notificar.hashCode() : 0);
        return result;
    }
}
