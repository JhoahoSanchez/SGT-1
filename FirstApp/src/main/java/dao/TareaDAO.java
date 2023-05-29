package dao;

import com.example.firstapp.TareaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TareaDAO {

    private SessionFactory sessionFactory;
    private Session session;
    public int size;

    public TareaDAO() {
    }

    public String crear(TareaEntity tarea) {
        try {
            this.open();
            this.session.beginTransaction();
            this.session.save(tarea);
            this.session.getTransaction().commit();
            this.close();
            return "Tarea creada";
        } catch (Exception e) {
            return "Error: Tarea no creada";
        }
    }

    public String actualizar(TareaEntity tarea) {
        try {
            this.open();
            this.session.beginTransaction();
            this.session.update(tarea);
            this.session.getTransaction().commit();
            this.close();
            return "Tarea actualizada";
        } catch (Exception e) {
            return "Error: Tarea no actualizada";
        }
    }

    public TareaEntity leer(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            TareaEntity tarea = this.session.get(TareaEntity.class, id);
            this.session.getTransaction().commit();
            this.sessionFactory.close();
            System.out.println("Tarea leida");
            return tarea;
        } catch (Exception e) {
            System.out.println("Error: Tarea no leida");
            return null;
        }
    }

    public String borrar(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            TareaEntity tarea = session.get(TareaEntity.class, id);
            session.delete(tarea);
            session.getTransaction().commit();
            this.close();
            return "Tarea eliminada";
        } catch (Exception e) {
            return "Error: Tarea no eliminada";
        }
    }

    public void close() {
        this.sessionFactory.close();
        this.session.close();
    }

    public void open() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public List<TareaEntity> leerTodo(){
        List<TareaEntity> listaTareas = null;
        try{
            this.open();
            this.session.beginTransaction();
            listaTareas = this.session.createQuery("from TareaEntity ").getResultList();
            this.session.getTransaction().commit();
            this.close();

            System.out.println("Tareas leidas");
            this.size = listaTareas.size();
            return listaTareas;
        } catch (Exception e) {
            System.out.println("Error: Tareas no leidas");
            return listaTareas;
        }
    }
}
