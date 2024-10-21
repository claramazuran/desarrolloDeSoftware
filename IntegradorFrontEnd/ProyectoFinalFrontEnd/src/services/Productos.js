export {abrirPopUpAgregarElementos, cerrarPopUpAgregarElementos, aniadirElemento, eliminarElemento}
import { eliminarBoton } from "../../main";
import {guardarEnLocalStorage, obtenerProductosExistentes} from "../persistence/localStorage"
import { obtenerProductos, mostrarProductosPorCategoria} from "../views/store";
import {productoActivo, setProductoActivo} from "/main"
import Swal from "sweetalert2"

//elemntos DOM
const contenedorPopUpPrincipal = document.getElementById("modeloPoUp");
const contenedorBotonesPopUp = document.getElementById("contenedorBotonesPU");
//elemntos DOM

const abrirPopUpAgregarElementos = () => {
    contenedorPopUpPrincipal.style.display = "flex";

    //si ya existe el producto, nos abre el popUp y nos trae todos los datos que tiene
    if (productoActivo) {
        const nombreElemento = document.getElementById("inputNombreProducto");
        const imagenElemento = document.getElementById("inputImagenProducto");
        const precioElemento = document.getElementById("inputPrecioProducto");
        const categoriaElemento = document.getElementById("elegirCategoria");

        nombreElemento.value = productoActivo.nombreElemento;
        imagenElemento.value = productoActivo.imagenElemento;
        precioElemento.value = productoActivo.precioElemento;
        categoriaElemento.value = productoActivo.categoriaElemento;

        //que me meustre el boton de poder eliminar
        eliminarBoton.style.display = "block";

    } else {
        eliminarBoton.style.display = "none";
    }
};

const cerrarPopUpAgregarElementos = () => {
    contenedorPopUpPrincipal.style.display = "none";
    setProductoActivo(null);
    resetPopUp();
};

//reseteamos el popoUp para que cuando lo cierre y vuelva a abrir no me salgan los valores que puse anteriormenete
const resetPopUp = () => {
    const nombreElemento = document.getElementById("inputNombreProducto");
    const imagenElemento = document.getElementById("inputImagenProducto");
    const precioElemento = document.getElementById("inputPrecioProducto");
    const categoriaElemento = document.getElementById("elegirCategoria");

    nombreElemento.value = "";
    imagenElemento.value = "";
    precioElemento.value = 0;
    categoriaElemento.value = "Seleccione una Categoria";
};

//añadir un elemento
const aniadirElemento = () => {
    //los coloco aca porque el valos que van a tener es dinamico y va a depender del momento en ejecucion
    const nombreElemento = document.getElementById("inputNombreProducto").value;
    const imagenElemento = document.getElementById("inputImagenProducto").value;
    const precioElemento = document.getElementById("inputPrecioProducto").value;
    const categoriaElemento = document.getElementById("elegirCategoria").value;

    let nuevoProducto = null;

    if(productoActivo){
        //si tenemos un producto activo
        nuevoProducto = {
            ...productoActivo,//operador sprits, itera a un objeto, permanece el id
            nombreElemento,
            imagenElemento,
            precioElemento,
            categoriaElemento
        }
    } else {
        //CREAMOS UN OBJETO PARA PODER GUARDAR EL PRODUCTO EN EL LOCALSTORAGE
        nuevoProducto = {
            id: new Date().toISOString(), //me genera un id unico con la fecha de hoy con segundos 
            nombreElemento,
            imagenElemento,
            precioElemento,
            categoriaElemento
        };
    }
    //alerta de que los cambios se guardaron bien
    Swal.fire({
        position: "center",
        icon: "success",
        title: "Tu producto ha sido guardado correctamente",
        showConfirmButton: false,
        timer: 1500
    });
    guardarEnLocalStorage(nuevoProducto);
    obtenerProductos();

    //cerramos el popup
    cerrarPopUpAgregarElementos();
};

//eliminar un eleemnto
const eliminarElemento = () => {
    //alerta que avisa que estamos queriendo eliminar un elemento
    Swal.fire({
        title: "¿Desea Eliminar Elemento?",
        text: "No podras revertir esta acción!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Sí, eliminar!",
        cancelButtonText: "Cancelar"
    }).then((result) => {
        if (result.isConfirmed) {
            //traemos todos los elementos
            const products = obtenerProductosExistentes();
            const result = products.filter((el) => el.id !== productoActivo.id);
            
            //seteamos en el localStorage los productos que no queremos eliminar
            localStorage.setItem("productos", JSON.stringify(result));

            //llamamos a la funcion que me muestra todos los productos pero no nos va a mostrar el que eliminamos
            mostrarProductosPorCategoria(result);

            cerrarPopUpAgregarElementos();
        } else {
            cerrarPopUpAgregarElementos();
        }
    });
    
};