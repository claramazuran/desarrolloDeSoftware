import {mostrarCategorias} from "./src/services/categories"
import {abrirPopUpAgregarElementos, cerrarPopUpAgregarElementos, eliminarElemento, aniadirElemento} from "./src/services/Productos.js"
import {obtenerProductos} from "./src/views/store"
import { buscarProductoPorNombre } from "./src/services/buscarElemento.js";
import './style.css' 

export{categoriaActiva, setCategoriaActiva, productoActivo, setProductoActivo, eliminarBoton}

//Dom
    const botonCategorias = document.getElementById("menuCategoria");
    const botonBuscar = document.getElementById("botonBuscarElemento")
    const filtroLista = document.getElementById("listaFiltro");
    const botonAgregarElementos = document.getElementById("botonAgregarElemento");
    const cancelarBoton = document.getElementById("botonCancelar");
    const aceptarBoton = document.getElementById("botonAceptar");
    const eliminarBoton = document.getElementById("botonEliminar");
//Dom

//modificacion de elementos
let categoriaActiva = null;

const setCategoriaActiva = (categoriaIn) => {
    categoriaActiva = categoriaIn;
};

let productoActivo = null;

const setProductoActivo = (productoIn) => {
    productoActivo = productoIn;
}
//modificacion de elementos

//llamamos a la funcion que nos muestra los productos con sus repectivas categorias
obtenerProductos();

//evento que cuando s aprieta el boton categorias se muestren las posibles categorias a elegir
botonCategorias.addEventListener("click", () => {
    
    if(botonCategorias.classList.contains("mostrandoCategorias")){
        filtroLista.style.visibility = "hidden";
        botonCategorias.classList.remove("mostrandoCategorias");
    
    } else {
        filtroLista.style.visibility = "visible"
        botonCategorias.classList.add("mostrandoCategorias");
        mostrarCategorias();
    }

});


//abrir el pop up agregar elementos
botonAgregarElementos.addEventListener("click", () => {
    abrirPopUpAgregarElementos();
});

//cerrar el pop up agregar elementos
cancelarBoton.addEventListener("click", () =>{
    cerrarPopUpAgregarElementos();
});

//añadir elemento
aceptarBoton.addEventListener("click", () => {
    aniadirElemento();
});

//eliminar elemento
eliminarBoton.addEventListener("click", () => {
    eliminarElemento();
});

//buscar elementos
botonBuscar.addEventListener("click", () => {
    buscarProductoPorNombre();
})