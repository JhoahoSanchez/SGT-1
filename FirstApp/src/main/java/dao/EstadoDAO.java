package dao;

import com.example.firstapp.EstadoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EstadoDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public EstadoDAO() {
    }

    public String crear(EstadoEntity estado) {
        try {
            this.open();
            this.session.beginTransaction();
            this.session.save(estado);
            this.session.getTransaction().commit();
            this.close();
            return "Estado creado";
        } catch (Exception e) {
            return "Error: Estado creado";
        }
    }

    public String actualizar(int id, String descripcion) {
        try {
            this.open();
            this.session.beginTransaction();
            EstadoEntity estado = this.session.get(EstadoEntity.class, id);
            estado.setDescripcion(descripcion);
            this.session.update(estado);
            this.session.getTransaction().commit();
            this.close();
            return "Estado actualizado";
        } catch (Exception e) {
            return "Error: Estado no actualizado";
        }
    }


    public EstadoEntity leer(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            EstadoEntity estado = this.session.get(EstadoEntity.class, id);
            this.session.getTransaction().commit();
            this.close();
            System.out.println("Categoria leida");
            return estado;
        } catch (Exception e) {
            System.out.println("Error: Categoria no leida");
            return null;
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
}
