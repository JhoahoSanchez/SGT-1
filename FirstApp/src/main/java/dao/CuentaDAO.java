package dao;

import com.example.firstapp.CuentaEntity;
public class CuentaDAO{

    public String crear(CuentaEntity cuenta) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.save(cuenta);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Cuenta creada";
        }catch (Exception e){
            return "Error: Cuenta no creada";
        }
    }

    public String actualizar(String direccionCorreo, String password) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            CuentaEntity cuenta = Conexion.session.get(CuentaEntity.class, direccionCorreo);
            cuenta.setContrasena(password);
            Conexion.session.update(cuenta);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Categoria actualizada";
        }catch (Exception e){
            return "Error: Categoria no actualizada";
        }
    }

    public CuentaEntity leer(String direccionCorreo) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            CuentaEntity cuenta = Conexion.session.get(CuentaEntity.class, direccionCorreo);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            System.out.println("Cuenta leida");
            return cuenta;
        }catch (Exception e){
            System.out.println("Error: Cuenta no leida");
            return null;
        }
    }

    public String borrar(String direccionCorreo) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            CuentaEntity cuenta = Conexion.session.get(CuentaEntity.class, direccionCorreo);
            Conexion.session.delete(cuenta);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Categoria eliminada";
        }catch (Exception e){
            return "Error: Categoria no eliminada";
        }
    }
}
