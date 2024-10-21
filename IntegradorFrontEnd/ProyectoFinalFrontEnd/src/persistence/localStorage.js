export{obtenerProductosExistentes, guardarEnLocalStorage}


//obtenemos los datos de los productos que tenemos guardados
const obtenerProductosExistentes = () => {
    const productos = JSON.parse(localStorage.getItem("productos"));

    if(productos){
        return productos;
    } else {
        return [];
    }
};

//se guarda o elimina un producto del localStore
const guardarEnLocalStorage = (producto) => {

    //traer todos los productos ya guardados
    let productosExistentes = obtenerProductosExistentes();

    const existingIndex = productosExistentes.findIndex((productoLocal) => 
        productoLocal.id === producto.id 
    );

    
    if(existingIndex !== -1 ) {
        //significa que ya existe nuestro producto
        productosExistentes[existingIndex] = producto;
    } else {
        //no existe entonces lo tenemos que crear
        productosExistentes.push(producto);
    }

    //seteamos en el localStorage los cambios
    localStorage.setItem("productos", JSON.stringify(productosExistentes));
}