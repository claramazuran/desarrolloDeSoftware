import { Header } from './Header'
import { FormProduct } from './FormProduct/ListProduct/FormProduct'
import { useState } from 'react';
import { ListProduct } from './FormProduct/ListProduct/ListProduct';

interface ItemProduct {
    precio: number,
    nombre: string,
    imagen: string
}
export const AppProduct = () => {
    const [products, setProducts] = useState<ItemProduct[]>([]);
    console.log(products)
    const handleAddProduct = (newItem: ItemProduct) => {
        setProducts((prev)=>[...prev, newItem])
    }
    return (
        <div>
            <Header/>
            <h2 className='text-center'>Formulario</h2>
            <FormProduct handleAddProduct={handleAddProduct}/>
            <h2 className='text-center'>Productos</h2>
            {
                products.length > 0 ? <ListProduct arrItems={products}/> : <h3>No hay productos</h3>
            }
            

        </div>
    )
}
