package servlets;

import clases.ListaDeCategoria;
import com.example.firstapp.CategoriaEntity;
import dao.CategoriaDAO;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SvCategoria", value = "/SvCategoria")
public class SvCategoriaCR extends HttpServlet {
    private CategoriaDAO categoriaDAO;
    private ListaDeCategoria listaDeCategoria;

    public void init() {
        this.categoriaDAO = new CategoriaDAO();
        this.listaDeCategoria = new ListaDeCategoria();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        if (this.listaDeCategoria.getListaCategorias().isEmpty()){
            this.listaDeCategoria.setCategorias(this.categoriaDAO.leerTodo());
        }
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCategorias", this.listaDeCategoria.getListaCategorias());
        response.sendRedirect("categorias.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String a = request.getParameter("nombre");
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setIdCategoria(categoriaDAO.size);
        categoria.setDescripcion(a);
        this.listaDeCategoria.agregarCategoria(categoria); //se guarda en buffer
        System.out.println(categoriaDAO.crear(categoria)); //se guarda en base de datos

        response.sendRedirect("categorias.jsp");
    }

    public void destroy() {
    }
}
