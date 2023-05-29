package dao;

import com.example.firstapp.CuentaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CuentaDAO{

    private SessionFactory sessionFactory;
    private Session session;
    public String crear(CuentaEntity cuenta) {
        try {
            this.open();
            this.session.beginTransaction();
            this.session.save(cuenta);
            this.session.getTransaction().commit();
            this.close();
            return "Cuenta creada";
        }catch (Exception e){
            return "Error: Cuenta no creada";
        }
    }

    public String actualizar(String direccionCorreo, String password) {
        try {
            this.open();
            this.session.beginTransaction();
            CuentaEntity cuenta = this.session.get(CuentaEntity.class, direccionCorreo);
            cuenta.setContrasena(password);
            this.session.update(cuenta);
            this.session.getTransaction().commit();
            this.close();
            return "Categoria actualizada";
        }catch (Exception e){
            return "Error: Categoria no actualizada";
        }
    }

    public CuentaEntity leer(String direccionCorreo) {
        try {
            this.open();
            this.session.beginTransaction();
            CuentaEntity cuenta = this.session.get(CuentaEntity.class, direccionCorreo);
            this.session.getTransaction().commit();
            this.close();
            System.out.println("Cuenta leida");
            return cuenta;
        }catch (Exception e){
            System.out.println("Error: Cuenta no leida");
            return null;
        }
    }

    public String borrar(String direccionCorreo) {
        try {
            this.open();
            this.session.beginTransaction();
            CuentaEntity cuenta = session.get(CuentaEntity.class, direccionCorreo);
            this.session.delete(cuenta);
            this.session.getTransaction().commit();
            this.close();
            return "Categoria eliminada";
        }catch (Exception e){
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
