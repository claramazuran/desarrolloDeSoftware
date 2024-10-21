//nos genera y muestra los filtros que tenemos de las diferentes categorias
export {mostrarCategorias, filtroLista}
import { categoriaActiva } from "../../main";
import {obtenerProductosExistentes} from "../persistence/localStorage";
import { mostrarProductosPorCategoria } from "../views/store";
import { inputBuscar } from "./buscarElemento";

//elemntos DOM
const filtroLista = document.getElementById("listaFiltro");

//elemntos DOM

//filtros de categorias
const handleFilters = (categoryIn) => {
    const productosExistentes = obtenerProductosExistentes();
    console.log(productosExistentes)
    switch (categoryIn) {
        case categoriaActiva:
            mostrarProductosPorCategoria(productosExistentes);
            break;
        
        case "Sandwiches":
        case "Papas":
        case "Gaseosas":
            const result = productosExistentes.filter((el) => el.categoriaElemento.toLowerCase() === categoryIn.toLowerCase());
            mostrarProductosPorCategoria(result);
            break;
        
        case "Todos los Productos":
            mostrarProductosPorCategoria(productosExistentes);
            break;

        //el menor precio es por categoria, osea los ordena por categoria
        case "menorPrecio":
            const resultPrecioMenor = productosExistentes.sort((a,b) => parseFloat(a.precioElemento) - parseFloat(b.precioElemento));
            mostrarProductosPorCategoria(resultPrecioMenor);    
            break;

        //el mayor precio es por categoria, osea los ordena por categoria
        case "mayorPrecio":
                const resultPrecioMayor = productosExistentes.sort((a,b) => parseFloat(b.precioElemento) - parseFloat(a.precioElemento));
                mostrarProductosPorCategoria(resultPrecioMayor);
                break;

        default:
            break;
        
    }
};

//agregamos las categorias
const mostrarCategorias = () => {
    filtroLista.innerHTML = `
        <li id="Todos los Productos">Todos los Productos</li>
        <li id="Sandwiches">Sandwiches</li>
        <li id="Papas">Papas</li>
        <li id="Gaseosas">Gaseosas</li>
        <li id="mayorPrecio">Mayor Precio</li>
        <li id="menorPrecio">Menor Precio</li>
    `
    //añadimos dinamicamente el evento click
    const elementosLi = filtroLista.querySelectorAll("li");
    elementosLi.forEach((li) => {
        li.addEventListener("click", () => {
            inputBuscar.value = "";
            clickEnCategorias(li);

        });
    });
    
};

//manejamos el cambio de estilo en el caso de que se haga click en una categoria
const clickEnCategorias = (elemento) => {
    //aplico el filtro
    handleFilters(elemento.id);

    const elementosLi = filtroLista.querySelectorAll("li");
    elementosLi.forEach((el) => {
            if(el.classList.contains("liActivo")) {
                el.classList.remove("liActivo");
            } else {
                if(elemento === el) {
                    el.classList.add("liActivo");
                }
            }
    })
};
