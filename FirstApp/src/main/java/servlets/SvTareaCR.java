package servlets;

import clases.*;
import com.example.firstapp.TareaEntity;
import dao.CategoriaDAO;
import dao.TareaDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "SvTarea", value = "/SvTarea")
public class SvTareaCR extends HttpServlet {
    private CategoriaDAO categoriaDAO;
    private TareaDAO tareaDAO;
    private ListaDeCategoria listaDeCategoria;
    private ListaDeTarea listaDeTarea;

    public void init() {
        this.categoriaDAO = new CategoriaDAO();
        this.tareaDAO = new TareaDAO();
        this.listaDeCategoria = new ListaDeCategoria();
        this.listaDeTarea = new ListaDeTarea();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //if (this.listaDeCategoria.getListaCategorias().isEmpty()){
            this.listaDeCategoria.setCategorias(this.categoriaDAO.leerTodo());
        //}
        if (this.listaDeTarea.getListaTareas().isEmpty()){
            this.listaDeTarea.setTareas(this.tareaDAO.leerTodo(), this.listaDeCategoria, this.tareaDAO.size);
        }
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCategorias", this.listaDeCategoria.getListaCategorias());
        misesion.setAttribute("listaTareas", this.listaDeTarea.getListaTareas());
        response.sendRedirect("tareas.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String a = request.getParameter("descripcion");
        int b = Integer.parseInt(request.getParameter("categoria"));
        String c = request.getParameter("fechaVencimiento");

        TareaEntity tarea = new TareaEntity();
        tarea.setIdTarea(listaDeTarea.obtenerNumeroDeTareas());
        tarea.setFechaCreacion(Date.valueOf(LocalDate.now()));
        tarea.setFechaVencimiento(Date.valueOf(c));
        tarea.setCategoria(b);
        tarea.setEstado(0);
        tarea.setDescripcion(a);
        tarea.setDireccionCorreo("jhoaho2001@gmail.com");
        tarea.setNotificar((byte) 0);
        System.out.println(tareaDAO.crear(tarea));
        listaDeTarea.agregarTarea(new Tarea(tarea.getDescripcion(), new Fecha(tarea.getFechaVencimiento()), listaDeCategoria.getCategoria(b)));

        response.sendRedirect("tareas.jsp");
    }

    public void destroy() {
    }


}
