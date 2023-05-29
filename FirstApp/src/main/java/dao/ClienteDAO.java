package dao;

import com.example.firstapp.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClienteDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public ClienteDAO() {
    }

    public String crear(ClienteEntity cliente) {
        try {
            this.open();
            this.session.beginTransaction();
            this.session.save(cliente);
            this.session.getTransaction().commit();
            this.close();
            return "Cliente creado";
        } catch (Exception e) {
            return "Error: Cliente no creado";
        }
    }

    public String actualizar(int id, String correo) {
        try {
            this.open();
            this.session.beginTransaction();
            ClienteEntity cliente = this.session.get(ClienteEntity.class, id);
            cliente.setDireccionCorreo(correo);
            this.session.update(cliente);
            this.session.getTransaction().commit();
            this.close();

            return "Correo actualizado";

        } catch (Exception e) {
            return "Error: Correo no actualizado";
        }
    }

    public ClienteEntity leer(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            ClienteEntity cliente = this.session.get(ClienteEntity.class, id);
            this.session.getTransaction().commit();
            this.close();
            System.out.println("Cliente leida");
            return cliente;
        } catch (Exception e) {
            System.out.println("Error: Cliente no leida");
            return null;
        }
    }

    public String borrar(int id) {
        try {
            this.open();
            this.session.beginTransaction();
            ClienteEntity cliente = this.session.get(ClienteEntity.class, id);
            this.session.delete(cliente);
            this.session.getTransaction().commit();
            this.close();
            return "Cliente eliminado";
        } catch (Exception e) {
            return "Error: Cliente no eliminado";
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
