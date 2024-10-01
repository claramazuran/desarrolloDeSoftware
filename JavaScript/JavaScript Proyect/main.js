//Introduccion a js
  //ejercicio2
  let a = Math.floor(Math.random() * 101);//le asigna a "a" un valor random de 0 a 100"
  let b = Math.floor(Math.random() * 101);//le asigna a "b" un valor random de 0 a 100"
  let c;  
  const resultado = (a,b) => c = a+b;
  let suma = resultado(a,b);
  console.log(`El resultado de ${a} + ${b} es igual a ${suma}`);

  //ejercicio3, como estamos trabajando con node.js, este no es compatible con prompt, prompt es compatible solo con el navegador. Esta seccion se encuentra en el html
  //let nombreUsuario = prompt("Coloque su nombre de usuario");
  //console.log(`Bienvenido de nuevo ${nombreUsuario}`);

//Operadores logicos y condicionales
  
  //ejercicio 1
    let d = Math.floor(Math.random() * 101);//le asigna a "d" un valor random de 0 a 100"
    let e = Math.floor(Math.random() * 101);//le asigna a "e" un valor random de 0 a 100"
    let f = Math.floor(Math.random() * 101);//le asigna a "f" un valor random de 0 a 100"

    const quienEsMayor = (d,e,f) => {
      
        if (d > e && d > f) {
          console.log(`El numero ${d} es mayor que ${e} y ${f}`);
        } else if (e > d && e > f) {
          console.log(`El numero ${e} es mayor que ${d} y ${f}`);
        } else if (f > d && f > e) {
          console.log(`El numero ${f} es mayor que ${d} y ${e}`);
        } else if (e == d && e == f) {
          console.log(`Los tres numeros son iguales y son ${e}`);
        }
      }

    quienEsMayor(d,e,f);
  
//Operadores de asignacion y bucles
  //ejercicio1
    let numero = 10;
      while(numero >= 0) {
        console.log(numero)
        numero--;
      }
//Funciones
  //ejercicio 1
    const esPar = (nro)=> {
      if (nro%2 == 0) {
        console.log(`El numero ${nro} es par: true`)
      } else {
        console.log(`El numero ${nro} es par: false`)
      }
    }
    let resultado2 = esPar(a);

  //ejercicio2
    const convertirCelsiusAFahrenheit = (temperatura) => temperatura * 1.8 + 32
    let temperaturaAconvertir = 20;
    let resultado3 = convertirCelsiusAFahrenheit(temperaturaAconvertir);
    console.log(`${temperaturaAconvertir}°C son equivalentes a ${resultado3}°F`)

//Objetos en js
  //ejercicio 2
    let libro = {
      titulo: "20 Leguas de Viaje Submarino",
      autor: "Julio Berne",
      año: 2003,
      esAntiguo: function() {
        let antiguedad = 2024 - libro.año;
        if (antiguedad > 10) {
          console.log(`El libro ${libro.titulo} es antiguo: true`)
        } else {
          console.log(`El libro ${libro.titulo} es antiguo: false`)
        }

      }
    }
    libro.esAntiguo();
//Arrays
  //ejecrcicio 1
    const numeros = [1,2,3,4,5,6,7,8,9,10];
    let nuemrosMultiplicacion = numeros.map((elemento) => elemento * 2)
    console.log("Numeros Originales: " + numeros);
    console.log("Numeros multiplicados por 2: " + nuemrosMultiplicacion);
  //ejercicio 2
    let pares = [];
    for(let i = 1; i<=20; i++) {
      if (i%2 == 0){
        pares.push(i);
      }
    }  
    console.log("Primeros 10 nros pares: " + pares)

//DOM
  //ejercicio 1
  const parrafos = document.getElementById("parrafos");
  const botonCambioColor = document.getElementById("botonCambiarColor");

  const cambioColor = () => {
    if(parrafos.classList.contains("CambioDeColorParrafos")){
      parrafos.classList.remove("CambioDeColorParrafos");
    } else {
      parrafos.classList.add("CambioDeColorParrafos");
    }
  }
  botonCambioColor.addEventListener('click', () => {
    cambioColor();
  })
  //ejercicio 2
  const botonAlerta = document.getElementById("botonAlerta");
  const textArea = document.getElementById("texto");

  const mostrarAlerta = () => {
    alert("Has ingresado: " + texto.value)
  }

  botonAlerta.addEventListener('click', ()=> {
    mostrarAlerta();
  })
//eventos en DOM
//ejercicio 1  
const ListaDesordenada = document.getElementById("listaDesordenada")

  
  ListaDesordenada.addEventListener('click', (event) => {
    if (event.target.tagName === 'LI') {
    console.log(event.target.textContent);
    }
  });
//ejercicio 2
  const campoTexto = document.getElementById("campoTexto");
  const botonDeshabilitar = document.getElementById("botonDeshabilitar");
  const botonHabilitar = document.getElementById("botonHabilitar");

  botonDeshabilitar.addEventListener('click', () => {
    campoTexto.disabled = true;
  });

  botonHabilitar.addEventListener('click', () => {
    campoTexto.disabled = false;
  });
//Local Strorage
const formulario = document.getElementById("formulario");
const correoInput = document.getElementById("correo");
const correoGuardadoDiv = document.getElementById("correoGuardado");
const botonEliminar = document.getElementById("botonEliminar");

// Función para mostrar el correo guardado
const mostrarCorreoGuardado = () => {
  const correoGuardado = localStorage.getItem("correo");
  if (correoGuardado) {
    correoGuardadoDiv.textContent = `Correo guardado: ${correoGuardado}`;
    botonEliminar.style.display = "block";
  } else {
    correoGuardadoDiv.textContent = "";
    botonEliminar.style.display = "none";
  }
};

// Evento de envío del formulario
formulario.addEventListener('submit', (event) => {
  event.preventDefault();
  const correo = correoInput.value;
  localStorage.setItem("correo", correo);
  mostrarCorreoGuardado();
  correoInput.value = "";
});

// Evento de clic en el botón de eliminar
botonEliminar.addEventListener('click', () => {
  localStorage.removeItem("correo");
  mostrarCorreoGuardado();
});

// Mostrar el correo guardado al cargar la página
document.addEventListener('DOMContentLoaded', () => {
  mostrarCorreoGuardado();
});



  
    