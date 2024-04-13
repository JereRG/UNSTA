// FUNCION QUE SE EJECUTA CUANDO EL DOM HA SIDO COMPLETAMENTE CARGADO
document.addEventListener('DOMContentLoaded', function() {
    // Seleccionamos el checkbox de alternancia y lo deshabilita al cargar la página
    const toggleCheckbox = document.querySelector('.toggle');
    toggleCheckbox.disabled = true;

    // Seleccionamos el botón de envío del formulario
    const submitButton = document.querySelector('.flip-card__btn');

    // Agregamos un evento al cambio del checkbox de alternancia
    toggleCheckbox.addEventListener('change', function() {
        // Si el checkbox esta marcado, se llama a la función para validar el segundo formulario
        if (this.checked) {
            validateForm();
        }
    });

    // Agregamos un evento al hacer clic en el botón de envio del formulario
    submitButton.addEventListener('click', function(event) {
        event.preventDefault(); // Evita que el formulario se envíe

        // Si el checkbox no esta marcado, se llama a la funcion para validar el primer formulario
        if (!toggleCheckbox.checked) {
            validateFirstForm();
        } else {
            // Si el checkbox esta marcado, se llama a la funcion para calcular el promedio
            calculateAverage();
        }
    });
});

// FUNCION PARA VALIDAR EL PRIMER FORMULARIO
function validateFirstForm() {
    const inputs = document.querySelectorAll('.flip-card__input');
    let isValid = true;

    // Verificamos si algun campo del primer formulario está vacío
    inputs.forEach(input => {
        if (!input.value.trim()) {
            isValid = false;
        }
    });

    // Validamos el formato del email
    const emailInput = document.querySelector('.flip-card__input[name="email"]');
    const emailValue = emailInput.value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (emailValue && !emailRegex.test(emailValue)) {
        isValid = false;
        // Muestra un mensaje de error si el email no tiene un formato válido
        showToast('error', 'fa-solid fa-circle-exclamation', 'Error', 'Por favor coloque un email válido.');
    }

    // Si algun campo esta vacio, muestra un mensaje de advertencia
    if (!isValid) {
        showToast('warning', 'fa-solid fa-triangle-exclamation', 'Warning', 'Por favor complete todos los campos.');
    } else {
        // Si el formulario es valido, activa el checkbox y llama a la funcion para validar el segundo formulario
        document.querySelector('.toggle').checked = true;
        toggleCheckbox.disabled = false;
        validateForm();
    }
}

// FUNCION PARA VALIDAR EL SEGUNDO FORMULARIO
function validateForm() {
    const inputs = document.querySelectorAll('#second-form .flip-card__input__matynotas');
    let isValid = true;

    // Verificamos si algun campo del segundo formulario esta vacio
    inputs.forEach(input => {
        if (!input.value.trim()) {
            isValid = false;
        }
    });
}

// FUNCION PARA CALCULAR EL PROMEDIO
function calculateAverage() {
    const flipCardBtnPromedio = document.querySelector('.flip-card__btn__promedio');
    flipCardBtnPromedio.disabled = true; // Desactivamos el boton mientras se muestra la notificacion

    const inputs = document.querySelectorAll('.flip-card__input__matynotas[type="number"]');
    let total = 0;
    let count = 0;

    // Calculamos el total y el numero de notas válidas
    inputs.forEach(input => {
        const value = parseFloat(input.value);
        if (!isNaN(value)) {
            total += value;
            count++;
        }
    });

    // Si hay al menos una nota valida, calcula el promedio y muestra la notificacion
    if (count > 0) {
        const average = total / count; // Calcula el promedio
        showToast('info', 'fa-solid fa-circle-info', 'Promedio', `El promedio es: ${average.toFixed(2)}`);
    } else {
        // Si no hay notas validas, muestra mensajes de error y advertencia
        showToast('error', 'fa-solid fa-circle-exclamation', 'Error', 'No se puede calcular el promedio. Ingrese al menos una nota válida.');
        showToast('warning', 'fa-solid fa-triangle-exclamation', 'Warning', 'Recuerda completar todos los campos.');
    }

    // Reactivamos el boton despues de un breve retraso y recarga la pagina para limpiar los formularios
    setTimeout(() => {
        flipCardBtnPromedio.disabled = false;
        location.reload();
    }, 9000); // Ajustamos el tiempo de espera según sea necesario
}

// FUNCION PARA VALIDAR EL FORMATO DEL EMAIL
function validateEmail(email) {
    return /\S+@\S+\.\S+/.test(email);
}

// FUNCION PARA MOSTRAR NOTIFICACIONES
function showToast(type, icon, title, text) {
    const notifications = document.querySelector('.notifications');
    const newToast = document.createElement('div');
    newToast.innerHTML = `
        <div class="toast ${type}">
            <i class="${icon}"></i>
            <div class="content">
                <div class="title">${title}</div>
                <span>${text}</span>
            </div>
            <i class="fa-solid fa-xmark" onclick="(this.parentElement).remove()"></i>
        </div>`;
    notifications.appendChild(newToast);
    newToast.timeOut = setTimeout(
        ()=>newToast.remove(), 7000
    );
}
