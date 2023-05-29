<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGT</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>
    
    <div class="container">
        <div class="todo-app">
            <h2>Tareas</h2>
            <div class="row">
                <input type="text" id="input-box" placeholder="Ingrese una nueva tarea...">
                <button onclick="addTask()">Add</button>
            </div>
            <ul id="list-container"></ul>
            <!-- tasks -->
            <!-- <ul id="list-container"> 
                
                <li class="checked">Task 1</li>
                <li>Task 2</li>
                <li>Task 3</li>
            </ul> -->

        </div>
    </div>
    <script src="scriptTareas.js"> </script>
</body>

</html>