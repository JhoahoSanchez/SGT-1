package dao;

import com.example.firstapp.ClienteEntity;

public class ClienteDAO {

    public ClienteDAO() {
    }

    public String crear(ClienteEntity cliente) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.save(cliente);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Cliente creado";
        } catch (Exception e) {
            return "Error: Cliente no creado";
        }
    }

    public String actualizar(int id, String correo) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            ClienteEntity cliente = Conexion.session.get(ClienteEntity.class, id);
            cliente.setDireccionCorreo(correo);
            Conexion.session.update(cliente);
            Conexion.session.getTransaction().commit();
            Conexion.close();

            return "Correo actualizado";

        } catch (Exception e) {
            return "Error: Correo no actualizado";
        }
    }

    public ClienteEntity leer(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            ClienteEntity cliente = Conexion.session.get(ClienteEntity.class, id);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            System.out.println("Cliente leida");
            return cliente;
        } catch (Exception e) {
            System.out.println("Error: Cliente no leida");
            return null;
        }
    }

    public String borrar(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            ClienteEntity cliente = Conexion.session.get(ClienteEntity.class, id);
            Conexion.session.delete(cliente);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Cliente eliminado";
        } catch (Exception e) {
            return "Error: Cliente no eliminado";
        }
    }
}
