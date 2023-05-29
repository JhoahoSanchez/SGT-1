<%@ page import="java.util.List" %>
<%@ page import="com.example.firstapp.CategoriaEntity" %>
<%@ page import="com.example.firstapp.TareaEntity" %>
<%@ page import="clases.ListaDeTarea" %>
<%@ page import="clases.Tarea" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGT</title>
    <link rel="stylesheet" href="styles/styleTareas.css">

</head>

<body>
<header class="header">
    <div class="logo">
        <a href="index.jsp"><img src="images/icon.png" alt="Logo"></a>
    </div>
    <nav>
        <ul class="nav-links">
            <li><a href="#">Perfil</a></li>
            <li><a href="SvTarea" method="GET">Tareas</a></li>
            <li><a href="SvCategoria" method="GET">Categorías</a></li>
        </ul>
    </nav>
</header>

<div class="container">
    <div class="todo-app">
        <h2>Tareas</h2>
        <div class="row">
            <button onclick="showPopup()">Add</button>
        </div>
        <ul id="list-container">
            <%
                List<Tarea> listaTareas = (List<Tarea>) request.getSession().getAttribute("listaTareas");
                for (Tarea tarea : listaTareas) {
            %>
            <li>
                <span>[<%=tarea.getCategoria().getDescripcion()%>]<%=tarea.getDescripcion() + "\t\t" + tarea.getFechaVencimiento() %></span>
            </li>
            <%}%>
        </ul>
    </div>
</div>

<div id="popup-container" class="popup-container">
    <div class="popup-content">
        <form method="POST" action="SvTarea">
            <!-- Contenido de la ventana emergente -->
            <h3>Agregar Tarea</h3>
            <br>
            <div class="rowP">
                <input type="text" id="description" required placeholder="Ingrese una nueva tarea..."
                       name="descripcion">
            </div>
            <div class="rowP">
                <select placeholder="Seleccione una categoría" name="categoria">
                    <!--id="category-select" -->
                    <%
                        List<CategoriaEntity> listaCategorias = (List) request.getSession().getAttribute("listaCategorias");
                        for (CategoriaEntity categoria : listaCategorias) {
                    %>
                        <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getDescripcion()%></option>
                    <%}%>
                </select>
            </div>
            <div class="rowP">
                <label for="date">Fecha límite</label>
                <input type="date" name="fechaVencimiento" id="date" required>
            </div>
            <div class="popup-footer">
                <button type="submit" onclick="addTask()">Guardar</button> <!-- onclick="addTask()" -->
                <button onclick="closePopup()">Cerrar</button>
            </div>
        </form>
    </div>
</div>
<script src="scripts/scriptTareas.js"></script>
</body>

</html>