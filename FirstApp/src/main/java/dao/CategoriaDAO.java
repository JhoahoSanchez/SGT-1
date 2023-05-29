package dao;

import com.example.firstapp.CategoriaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CategoriaDAO {

    private SessionFactory sessionFactory;
    private Session session;
    public int size;

    public CategoriaDAO() {
    }

    public String crear(CategoriaEntity categoria) {
        try {
            this.open();
            this.session.beginTransaction();
            this.session.save(categoria);
            this.session.getTransaction().commit();
            this.close();
            return "Categoria creada";
        } catch (Exception e) {
            return "Error: Categoria no creada";
        }
    }

    public String actualizar(int id, String descripcion) {
        try {
            this.open();
            this.session.beginTransaction();
            CategoriaEntity categoria = this.session.get(CategoriaEntity.class, id);
            categoria.setDescripcion(descripcion);
            this.session.update(categoria);
            this.session.getTransaction().commit();
            this.close();
            return "Categoria actualizada";
        } catch (Exception e) {
            return "Error: Categoria no actualizada";
        }
    }

    public CategoriaEntity leer(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            CategoriaEntity categoria = this.session.get(CategoriaEntity.class, id);
            this.session.getTransaction().commit();
            this.close();

            System.out.println("Categoria leida");
            return categoria;
        } catch (Exception e) {
            System.out.println("Error: Categoria no leida");
        }
        return null;
    }

    public List<CategoriaEntity> leerTodo(){
        List<CategoriaEntity> listaCategorias = null;
        try {
            this.open();
            this.session.beginTransaction();
            listaCategorias = this.session.createQuery("from CategoriaEntity ").getResultList();
            this.session.getTransaction().commit();
            this.close();

            System.out.println("Categorias leidas");
            this.size = listaCategorias.size();
            return listaCategorias;
        } catch (Exception e) {
            System.out.println("Error: Categorias no leidas");
            return listaCategorias;
        }
    }

    public String borrar(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            CategoriaEntity categoria = session.get(CategoriaEntity.class, id);
            this.session.delete(categoria);
            this.session.getTransaction().commit();
            this.close();

            return "Categoria eliminada";

        } catch (Exception e) {
            return "Error: Categoria no eliminada";
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
