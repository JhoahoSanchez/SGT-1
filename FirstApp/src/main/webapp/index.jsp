<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/styles/login.css">

</head>

<body>
    <form action="paginaInicio.jsp" method="POST">
        <div>
            <img src="/images/user.png" alt="ImagenUser">
        </div>

        <h1>Login</h1>

        <input type="email" id="email" name="email" placeholder="Ingrese su correo electrónico" required>

        <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" required>
        <div><a href="recuperarContra.jsp">Olvidé la contraseña</a><br><br></div>

        <div class="cols">
            <button type="submit">Iniciar Sesión</button>
            <button type="button" onclick="window.location.href='register.jsp'">Registrarme</button>
        </div>

    </form>
</body>

</html>