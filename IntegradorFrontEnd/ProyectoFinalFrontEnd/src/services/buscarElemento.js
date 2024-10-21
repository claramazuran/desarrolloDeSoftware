export{buscarProductoPorNombre, inputBuscar}
import { obtenerProductosExistentes} from "../persistence/localStorage";
import { mostrarProductosPorCategoria } from "../views/store";
import { filtroLista } from "./categories";
//DOM
const inputBuscar = document.getElementById("inputBuscarElemento");
//DOM

const buscarProductoPorNombre = () => {
    const products = obtenerProductosExistentes();
    
    const result = products.filter((el) => {
        return el.nombreElemento.includes(inputBuscar.value);
    });

    //en el caso de que busquemos y este seleccionado previamente una categoria, desseleccionarla
    const elementosLi = filtroLista.querySelectorAll("li");
    elementosLi.forEach((el) =>{
        if(el.classList.contains("liActivo")){
            el.classList.remove("liActivo");
        }    
    });
    //mostramos a los productos buscados
    mostrarProductosPorCategoria(result);
}
