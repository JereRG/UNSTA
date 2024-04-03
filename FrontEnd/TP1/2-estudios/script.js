// Función para mostrar contenido y marcar el paso correspondiente como activo

function showContent(sectionName, stepNumber) {
    var sections = document.getElementsByClassName('section-content');
    for (var i = 0; i < sections.length; i++) {
        sections[i].style.display = 'none';
    }
    document.getElementsByClassName(sectionName)[0].style.display = 'block';
    
    var steps = document.getElementsByClassName('step');
    for (var i = 0; i < steps.length; i++) {
        steps[i].classList.remove('active');
    }
    document.querySelector('.step' + stepNumber).classList.add('active');

    // Mover la línea de carga
    document.getElementById('line-process').style.width = ((parseInt(stepNumber) - 1) * 25) + '%';
}


// MOSTRAR POR DEFECTO ESTUDIO SECUNDARIO
window.onload = function() {
    showContent('secundario', '01');
};
