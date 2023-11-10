const fileInput = document.getElementById('file');
const fileName = document.getElementById('file-name');
const uploadButton = document.getElementById('upload-button');
const dropzone = document.querySelector('.dropzone');

fileInput.addEventListener('change', function () {
    if (fileInput.value) {
        fileName.textContent = 'Archivo seleccionado: ' + fileInput.files[0].name;
        uploadButton.removeAttribute('disabled');
    } else {
        fileName.textContent = 'Ningún archivo seleccionado';
        uploadButton.setAttribute('disabled', 'true');
    }
});

// Agregar eventos para arrastrar y soltar archivos en la zona de la gota
dropzone.addEventListener('dragover', function (e) {
    e.preventDefault();
    dropzone.classList.add('bg-light'); // Cambia el fondo al pasar sobre la zona de arrastre
});

dropzone.addEventListener('dragleave', function () {
    dropzone.classList.remove('bg-light'); // Restaura el fondo al salir de la zona de arrastre
});

dropzone.addEventListener('drop', function (e) {
    e.preventDefault();
    dropzone.classList.remove('bg-light'); // Restaura el fondo
    const file = e.dataTransfer.files[0];
    if (file) {
        fileName.textContent = 'Archivo seleccionado: ' + file.name;
        uploadButton.removeAttribute('disabled');
    }});


