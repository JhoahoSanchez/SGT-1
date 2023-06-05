package dao;

import com.example.firstapp.TareaEntity;

import java.util.List;

public class TareaDAO {

    public int size;
    public TareaDAO() {
    }

    public String crear(TareaEntity tarea) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.save(tarea);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Tarea creada";
        } catch (Exception e) {
            return "Error: Tarea no creada";
        }
    }

    public String actualizar(TareaEntity tarea) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.update(tarea);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Tarea actualizada";
        } catch (Exception e) {
            return "Error: Tarea no actualizada";
        }
    }

    public TareaEntity leer(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            TareaEntity tarea = Conexion.session.get(TareaEntity.class, id);
            Conexion.session.getTransaction().commit();
            Conexion.sessionFactory.close();
            System.out.println("Tarea leida");
            return tarea;
        } catch (Exception e) {
            System.out.println("Error: Tarea no leida");
            return null;
        }
    }

    public String borrar(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            TareaEntity tarea = Conexion.session.get(TareaEntity.class, id);
            Conexion.session.delete(tarea);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Tarea eliminada";
        } catch (Exception e) {
            return "Error: Tarea no eliminada";
        }
    }

    public List<TareaEntity> leerTodo(){
        List<TareaEntity> listaTareas = null;
        try{
            Conexion.open();
            Conexion.session.beginTransaction();
            listaTareas = Conexion.session.createQuery("from TareaEntity ").getResultList();
            Conexion.session.getTransaction().commit();
            Conexion.close();
            System.out.println("Tareas leidas");
            this.size = listaTareas.size();
            return listaTareas;
        } catch (Exception e) {
            System.out.println("Error: Tareas no leidas");
            return listaTareas;
        }
    }
}
