package org.example;
import jdk.swing.interop.SwingInterOpUtils;
import org.example.Entidades.*; //importo todas las clases del paquete Entidades

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //conexión de nuestro proyecto con la unidad de persistencia, pongo el nombre de la unidad de persistencia
        EntityManagerFactory factory1 = Persistence.createEntityManagerFactory("UnidadDePersistencia1");

        //instanciamos a la entity manager factory, llamamos a la funcion create con el nombre de la factory
        EntityManager manager1 = factory1.createEntityManager();

        //manejo de errores
        try {
            //iniciamos una transaccion a la bd
            manager1.getTransaction().begin();

            //creamos un cliente
            Cliente cliente1 = Cliente.builder()
                    .nombre("Clara")
                    .apellido("Mazuran")
                    .dni(45257157)
                    .build();

            //creamos un domicilio
            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("Viognier")
                    .numero(18)
                    .build();

            //creamos una factura
            Factura factura1 = Factura.builder()
                    .fecha("6/9/24")
                    .numero(5003)
                    .total(590)
                    .build();

            //creo detalles de factura
            DetalleFactura detalleFactura1 = DetalleFactura.builder()
                    .cantidad(20)
                    .subtotal(490)
                    .build();
            DetalleFactura detalleFactura2 = DetalleFactura.builder()
                    .cantidad(10)
                    .subtotal(100)
                    .build();

            //creo articulos
            Articulo articulo1 = Articulo.builder()
                    .cantidad(50)
                    .denominacion("Regla")
                    .precio(24.5)
                    .build();

            Articulo articulo2 = Articulo.builder()
                    .cantidad(50)
                    .denominacion("Goma")
                    .precio(10)
                    .build();

            //creo categoria
            Categoria categoria1 = Categoria.builder()
                    .denominacion("Libreria")
                    .build();

            //conectamos a domicilio con cliente
            cliente1.setDomicilio(domicilio1);

            //conectamos a la factura con cliente
            factura1.setCliente(cliente1);

            //conectamos los detalles con la factura
            factura1.getDetalleFactura().add(detalleFactura1);
            factura1.getDetalleFactura().add(detalleFactura2);

            //seteo los articulos en dettalle factura
            detalleFactura1.setArticulo(articulo1);
            detalleFactura2.setArticulo(articulo2);

            //seteo la categoria en articulo
            articulo1.getCategoria().add(categoria1);
            articulo2.getCategoria().add(categoria1);

            //seteo el articulo en categoria
            categoria1.getArticulo().add(articulo1);
            categoria1.getArticulo().add(articulo2);

            //como la factura es nuestra clase principal, una vez que tengamos creado y relacionado todo, solo con persistir la factura se persiste todo
            manager1.persist(factura1);

                //PERSISTENCIA DE TODOS LOS OBJETOS
                //persistir al cliente, cuando se persiste al cliente se persiste el domicilio tmb
                /*manager1.persist(cliente1);

                //persisto la factura para que me la cree y poder conectarla con el cliente. Ademas se persisten los detalles
                manager1.persist(factura1);

                //persisto los articulos
                manager1.persist(articulo1);
                manager1.persist(articulo2);

                //persisto las categorias
                manager1.persist(categoria1);
                */
                //PERSISTENCIA DE TODOS LOS OBJETOS

            //me limpia la conexion
            manager1.flush();

            //commit de nuestro persist
            manager1.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            //si algo funciona mal hacemos un rollback para volver al estado anterior, por ejemplo en el caso de que se ingrese algun atributo inválido.
            manager1.getTransaction().rollback();
        }
        //manejo de errores

        //cierro la conexión con el entity manager
        manager1.close();

        //cierro la conexión con la factory
        factory1.close();

    }
}