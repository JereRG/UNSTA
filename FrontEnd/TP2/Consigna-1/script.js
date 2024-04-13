// FUNCION PARA GENERAR NUMERO ALEATORIOS Y MOSTRAR: PROMEDIO , SUMA TOTAL , MAXIMO Y MINIMO
function numerosAleatorios(){

    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML
    ul.innerHTML = ''; // Vaciamos la lista del archivo HTML al renderizar

    var numeros = []; // Arreglo para almacenar los números aleatorios

    var suma = 0; // Variable para almacenar el valor de la suma total de los elementos

    // Variables para almacenar el numero maximo y numero minimo
    var numeroMaximo = -Infinity;
    var numeroMinimo = +Infinity;

    for (i = 0; i < 10; i++) {
        var numeroRandom = Math.floor(Math.random() * 100) + 1; // Generacion del numero random

        numeros.push(numeroRandom); // Almacenar el número aleatorio en el arreglo

        var li = document.createElement("li"); // Creamos una variable para la creacion de elementos li
        li.textContent = numeroRandom; // Asignamos el texto de cada li al numero random generado
        ul.appendChild(li); // Generamos los elementos li dentro de la lista
        
        /* 
            SUMA TOTAL DE LOS ELEMENTOS
        */

        suma += numeroRandom; // Sumamos y asignamos la variable suma a los numeros random    

        var h2 = document.getElementById("sumaTotal"); // Accedemos al elemento H2
        h2.textContent = "La suma de los numeros generados es: " + suma; // Mostramos el texto en el elemento H2 con el valor de la suma total

        /* 
            PROMEDIO DE TODOS LOS ELEMENTOS
        */
        var promedio = suma / (i + 1); // i+1 porque i inicia en 0
        document.getElementById("promedioTotal").textContent = "El promedio de los numeros generados es: " + promedio.toFixed(2);

        /* 
            MAXIMO Y MINIMO DE LOS ELEMENTOS
        */
        // Actualizamos el numero maximo si es necesario
        if(numeroRandom > numeroMaximo) {
            numeroMaximo = numeroRandom;
        }
        // Actualizamos el numero minimo si es necesario
        if(numeroRandom < numeroMinimo) {
            numeroMinimo = numeroRandom;
        }
        // Mostrar el numero maximo y el numero minimo en los elementos HTML
        document.getElementById("numMax").textContent = "Numero Maximo: " + numeroMaximo;
        document.getElementById("numMin").textContent = "Numero Minimo: " + numeroMinimo;
    }
    // Devolver el arreglo de números aleatorios
    return numeros;
}

// FUNCION PARA ELIMINAR EL PRIMER ELEMENTO 
function eliminarPrimerElemento() {
    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML

    // Eliminamos el primer elemento de una lista en HTML si la lista tiene al menos un elemento.
    if (ul.firstChild) {
        ul.removeChild(ul.firstChild);
    }
}

// FUNCION PARA ELIMINAR EL ULTIMO ELEMENTO
function eliminarUltimoElemento() {
    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML

    // Eliminamos el ultimo elemento de una lista en HTML si la lista tiene al menos un elemento.
    if (ul.lastChild) {
        ul.removeChild(ul.lastChild);
    }
}

// FUNCION PARA AGREGAR UN NUEVO ELEMENTO
function agregarNuevoElemento() {
    // Accedemos a la lista del archivo HTML
    var ul = document.getElementById("listaNumerosAleatorios");

    var nuevoNumero = Math.floor(Math.random() * 100) + 1; // Generar un nuevo numero aleatorio
    var li = document.createElement("li"); // Creamos una variable para la creacion de elementos li
    li.textContent = nuevoNumero; // Asignamos el texto de cada li al numero "nuevo" random generado
    ul.appendChild(li); // Generamos los elementos li dentro de la lista
}

// FUNCION PARA ORDENAR DE MENOR A MAYOR
function ordenarArregloMenorMayor() {
    
    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML
    var lis = ul.getElementsByTagName("li"); // Obtenemos todos los elementos li
    var numeros = []; // Creamos un arreglo vacio para almacenar los numeros

     // Iteramos sobre cada elemento li obtenido anteriormente
    
    for (var i = 0; i < lis.length; i++) {
        numeros.push(parseInt(lis[i].textContent)); // Convertimos el texto contenido en cada elemento li a un int y se agrega al arreglo
    }

    numeros.sort(function(a, b){return a - b}); // Ordenamos de menor a mayor
    ul.innerHTML = '';  // Vaciamos el contenido del elemento ul

    for (var i = 0; i < numeros.length; i++) {
        var li = document.createElement("li"); // Creamos un nuevo elemento li

        li.textContent = numeros[i];  // Establecemos el texto del nuevo elemento li con el numero correspondiente del arreglo

        ul.appendChild(li); // Agregamos el nuevo elemento li al elemento ul
    }
}

// FUNCION PARA ORDENAR DE MAYOR A MENOR
function ordenarArregloMayorMenor() {
    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML
    var lis = ul.getElementsByTagName("li");  // Obtenemos todos los elementos li
    var numeros = []; // Creamos un arreglo vacio para almacenar los numeros

    // Iteramos sobre cada elemento li obtenido anteriormente

    for (var i = 0; i < lis.length; i++) {
        numeros.push(parseInt(lis[i].textContent)); // Convertimos el texto contenido en cada elemento li a un int y se agrega al arreglo
    }

    numeros.sort(function(a, b){return b - a}); // Ordenamos de mayor a menor
    ul.innerHTML = ''; // Vaciamos el contenido del elemento ul

    // Iteramos sobre el arreglo ordenado y agregamos cada numero como un nuevo elemento

    for (var i = 0; i < numeros.length; i++) {
        var li = document.createElement("li"); // Creamos un nuevo elemento li

        li.textContent = numeros[i];  // Establecemos el texto del nuevo elemento li con el numero correspondiente del arreglo

        ul.appendChild(li); // Agregamos el nuevo elemento li al elemento ul
    }
}

// FUNCION PARA INVERTIR EL ARREGLO
function invertirArreglo() {
    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML
    var lis = ul.getElementsByTagName("li"); // Obtenemos todos los elementos li
    var numeros = [];  // Creamos un arreglo vacio para almacenar los numeros

    // Iteramos sobre cada elemento li obtenido anteriormente
    for (var i = 0; i < lis.length; i++) {
        numeros.push(parseInt(lis[i].textContent)); // Convertimos el texto contenido en cada elemento li a un int y se agrega al arreglo
    }

    numeros.reverse(); // Invertir el orden del arreglo
    ul.innerHTML = ''; // Vaciamos el contenido del elemento ul

     // Iteramos sobre el arreglo ordenado y agregamos cada numero como un nuevo elemento

    for (var i = 0; i < numeros.length; i++) {
        var li = document.createElement("li"); // Creamos un nuevo elemento li

        li.textContent = numeros[i]; // Establecemos el texto del nuevo elemento li con el numero correspondiente del arreglo

        ul.appendChild(li); // Agregamos el nuevo elemento li al elemento ul
    }
}

// FUNCION PARA MOSTRAR EL CONTENIDO EN CONSOLA
function mostrarContenidoArreglo() {
    var ul = document.getElementById("listaNumerosAleatorios"); // Accedemos a la lista del archivo HTML
    var lis = ul.getElementsByTagName("li"); // Obtenemos todos los elementos li
    var numeros = []; // Creamos un arreglo vacio para almacenar los numeros

    // Iteramos sobre cada elemento li obtenido anteriormente
    for (var i = 0; i < lis.length; i++) {
        numeros.push(parseInt(lis[i].textContent)); // Convertimos el texto contenido en cada elemento li a un int y se agrega al arreglo
    }

    // Mostrar el contenido del arreglo en la consola con su posición
    console.log("Contenido del arreglo:");

    // Iteramo sobre el arreglo para mostrar cada elemento junto con su posición en la consola
    for (var i = 0; i < numeros.length; i++) {
        console.log("Posicion " + i + ": " + numeros[i]);
    }
}




