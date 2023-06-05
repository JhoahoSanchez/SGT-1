package dao;

import com.example.firstapp.EstadoEntity;

public class EstadoDAO {

    public EstadoDAO() {
    }

    public String crear(EstadoEntity estado) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.save(estado);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Estado creado";
        } catch (Exception e) {
            return "Error: Estado creado";
        }
    }

    public String actualizar(int id, String descripcion) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            EstadoEntity estado = Conexion.session.get(EstadoEntity.class, id);
            estado.setDescripcion(descripcion);
            Conexion.session.update(estado);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Estado actualizado";
        } catch (Exception e) {
            return "Error: Estado no actualizado";
        }
    }


    public EstadoEntity leer(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            EstadoEntity estado = Conexion.session.get(EstadoEntity.class, id);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            System.out.println("Categoria leida");
            return estado;
        } catch (Exception e) {
            System.out.println("Error: Categoria no leida");
            return null;
        }
    }
}
