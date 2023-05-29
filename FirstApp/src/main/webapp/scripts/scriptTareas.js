const inputBox = document.getElementById("description");
const listContainer = document.getElementById("list-container");
const date = document.getElementById("date");
//--------------------SE LLENA EL SELECT-----------------
var datosGuardados = localStorage.getItem("CategoryData");
// Verificar si hay datos guardados
if (datosGuardados) {
    var tempDiv = document.createElement("div");
    tempDiv.innerHTML = datosGuardados;

    var listItems = tempDiv.getElementsByTagName("li");

    var selectElement = document.getElementById("category-select");

    for (var i = 0; i < listItems.length; i++) {
        var categoryName = listItems[i].textContent;
        categoryName = categoryName.substring(0, categoryName.length - 1);
        //var color = listItems[i].style.backgroundColor;
        // Crea una nueva opción y establece su valor y texto
        var optionElement = document.createElement("option");
        optionElement.value = categoryName;
        //optionElement.textContent = categoryName;

        // Agrega la opción al elemento select
        selectElement.appendChild(optionElement);
    }

} else {
    console.log('No hay datos guardados en el localStorage.');
}

function addTask() {
    if (inputBox.value === '') {
        alert("You must write something!");
    }
    else {
        let li = document.createElement("li");
        var selectedIndex = selectElement.selectedIndex;
        var selectedOption = selectElement.options[selectedIndex];
        //var selectedColor =  selectedOption.value;
        //console.log(selectedColor);
        li.innerHTML = "["+"<span style='color: "+selectedOption.textContent+";' value=' "+selectedOption.textContent+ " '>" +selectedOption.textContent+ "</span>"+"] "+ inputBox.value;
        selectedOption.value = inputBox.value;
        listContainer.appendChild(li);

        let spanX = document.createElement("span");
        spanX.classList.add("equis-span");
        spanX.innerHTML = "\u00d7";
        li.appendChild(spanX);
        
        let spanD = document.createElement("span");
        spanD.classList.add("date-span");
        spanD.innerHTML = date.value;
        li.appendChild(spanD);
        
        inputBox.value = "";
        //saveData()
        closePopup();
    }

}
listContainer.addEventListener("click", function (e) {
    if (e.target.tagName === "LI") {
        e.target.classList.toggle("checked");
        //saveData()
    }
    else if (e.target.classList.contains("equis-span")) {
        e.target.parentElement.remove();
        //saveData()
    }
}, false);

function saveData() {
    localStorage.setItem("data", listContainer.innerHTML);
}
function showTask() {
    listContainer.innerHTML = localStorage.getItem("data");

}

//Codigo del popup
function showPopup() {
    var popupContainer = document.getElementById("popup-container");
    popupContainer.classList.add("show");
}

function closePopup() {
    var popupContainer = document.getElementById("popup-container");
    popupContainer.classList.remove("show");
}


showTask();