function cargarContenido(url) {
  fetch(url)
    .then(response => response.text())
    .then(data => {
      document.getElementById('contenido').innerHTML = data;
      const script = document.createElement('script');
      script.src = '/scripts/scriptTareas.js';
      document.body.appendChild(script);
    })
    .catch(error => {
      console.error('Error al cargar el contenido:', error);
    });
}