const inputBox = document.getElementById("input-box");
const listContainer = document.getElementById("list-container");
const color = document.getElementById("color-selector");

function addCategory() {
  if (inputBox.value === '') {
    alert("Debes escribir algo.");
    return;
  }  
  
  let li = document.createElement("li");
  li.innerHTML = inputBox.value;
  listContainer.appendChild(li);
  let span = document.createElement("span");
  span.innerHTML = "\u00d7";
  li.appendChild(span);
  
  li.style.backgroundColor = color.value;
  
  inputBox.value = "";
  saveData();
}

listContainer.addEventListener("click", function(e) {
  if (e.target.tagName === "SPAN") {
    e.target.parentElement.remove();
    saveData();
  }
}, false);

function saveData() {
  localStorage.setItem("CategoryData", listContainer.innerHTML);
}

function showCategories() {
  listContainer.innerHTML = localStorage.getItem("CategoryData");
}

showCategories();
