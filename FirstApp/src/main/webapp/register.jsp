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
    <form action="index.jsp" method="GET">

        <h1>Registro</h1>
        <input type="text" id="name" name="name" placeholder="Ingrese su nombre" required>
        <input type="text" id="lastName" name="lastName" placeholder="Ingrese su apellido" required>
        <span class="date-placeholder">Ingrese su fecha de nacimiento</span>
        <input type="date" id="age" name="age" required>
        <input type="email" id="email" name="email" placeholder="Ingrese su correo electrónico" required>
        <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" required>
        <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Repita su contraseña" required>
        <div class="spacer"></div>
        <div><button class="regsitro" type="submit">Registrarme</button></div>
        
    </form>
</body>

</html>