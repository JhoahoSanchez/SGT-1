package dao;

import com.example.firstapp.CategoriaEntity;

import java.util.List;

public class CategoriaDAO {

    public int size;

    public CategoriaDAO() {
    }

    public String crear(CategoriaEntity categoria) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.save(categoria);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Categoria creada";
        } catch (Exception e) {
            return "Error: Categoria no creada";
        }
    }

    public String actualizar(int id, String descripcion) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            CategoriaEntity categoria = Conexion.session.get(CategoriaEntity.class, id);
            categoria.setDescripcion(descripcion);
            Conexion.session.update(categoria);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Categoria actualizada";
        } catch (Exception e) {
            return "Error: Categoria no actualizada";
        }
    }

    public CategoriaEntity leer(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            CategoriaEntity categoria = Conexion.session.get(CategoriaEntity.class, id);
            Conexion.session.getTransaction().commit();
            Conexion.close();

            System.out.println("Categoria leida");
            return categoria;
        } catch (Exception e) {
            System.out.println("Error: Categoria no leida");
        }
        return null;
    }

    public List<CategoriaEntity> leerTodo() {
        List<CategoriaEntity> listaCategorias = null;
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            listaCategorias = Conexion.session.createQuery("from CategoriaEntity ").getResultList();
            Conexion.session.getTransaction().commit();
            Conexion.close();

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
            Conexion.open();
            Conexion.session.beginTransaction();
            CategoriaEntity categoria = Conexion.session.get(CategoriaEntity.class, id);
            Conexion.session.delete(categoria);
            Conexion.session.getTransaction().commit();
            Conexion.close();

            return "Categoria eliminada";

        } catch (Exception e) {
            return "Error: Categoria no eliminada";
        }
    }
}
