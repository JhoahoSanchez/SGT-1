package clases;


import com.example.firstapp.CategoriaEntity;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCategoria {
    private List<CategoriaEntity> categorias;

    public ListaDeCategoria() {
        this.categorias = new ArrayList<CategoriaEntity>();
    }

    public void agregarCategoria(CategoriaEntity categoria) {
        categorias.add(categoria);
    }

    private int obtenerNumeroDecategoria() {
        return categorias.size();
    }

    public void quitarCategoria(CategoriaEntity categoria) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).equals(categoria)) {
                categorias.remove(i);
                break;
            }
        }
    }

    public List<CategoriaEntity> getListaCategorias() {
        return this.categorias;
    }

    public CategoriaEntity buscarCategoria(int id) {
        return categorias.get(id);
    }

    public void setCategorias(List categorias) {
        this.categorias = categorias;
    }
}
