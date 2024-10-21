import {obtenerProductosExistentes} from "../persistence/localStorage";
import { abrirPopUpAgregarElementos } from "../services/Productos";
import { categoriaActiva, setCategoriaActiva, productoActivo, setProductoActivo } from "/main";
export {mostrarProductosPorCategoria, obtenerProductos}

//funcion que se encarga de traer todos los elementos y llamar a mostrarProductosPorCategoria
const obtenerProductos = () => {
    const productos = obtenerProductosExistentes();
    mostrarProductosPorCategoria(productos);
};

//se encarga de filtrar y renderizar la seccion con todos sus respectivos elementos
const mostrarProductosPorCategoria = (productosAMostrar) => {
    //filtrado de arrays por categoria
    const sandwiches = productosAMostrar.filter((el) => el.categoriaElemento.toLowerCase() === "sandwiches");
    const papas = productosAMostrar.filter((el) => el.categoriaElemento.toLowerCase() === "papas");
    const gaseosas = productosAMostrar.filter((el) => el.categoriaElemento.toLowerCase() === "gaseosas");

    //define las secciones por categoria
    const renderProductGroup = (productos, titulo) => {
        if(productos.length>0){
            const productosHtml = productos.map((producto, index) => {
                return `<div class="containerTargetItem" id="product-${producto.categoriaElemento}-${index}">
                    <div>
                        <img src='${producto.imagenElemento}'/>
                    </div>

                    <div> 
                        <h2>${producto.nombreElemento}</h2>
                    </div>

                    <div class="targetProps"> 
                        <p><b>Precio: $${producto.precioElemento}</b></p>
                    </div>
                </div>
                `
            });
            //retorna la seccion con todos los elementos dentro
            return `
                <section class="sectionStore">
                    <div class="containerTitleSection">
                        <h3>${titulo}</h3>
                    </div>
                    
                    <div class="containerProductStore">
                        ${productosHtml.join("")}
                    </div>
                </section>
            `
        } else {
            return ""
        }
    };

    //renderiza cada uno de los productos dentro de su categoria
    const appContainer = document.getElementById("containerStore");

    appContainer.innerHTML = `
        ${renderProductGroup(sandwiches, "Sandwiches")}
        ${renderProductGroup(papas, "Papas")}
        ${renderProductGroup(gaseosas, "Gaseosas")}
    `

    //se añaden eventos de manera dinamica
    const addEvents = (productos) => {
        if(productos) {
            productos.forEach((elemento, index) => {
                const productContainer = document.getElementById(`product-${elemento.categoriaElemento}-${index}`);
                
                //me permite que cuando aprete un elemento de comida se me abra el pop up de agregar elemento
                productContainer.addEventListener("click" , () => {
                    setProductoActivo(elemento);
                    abrirPopUpAgregarElementos();
                });
            });
        
        };
    };

    addEvents(sandwiches);
    addEvents(papas);
    addEvents(gaseosas);
};