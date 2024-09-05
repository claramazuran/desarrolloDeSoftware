package org.example;
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

            //persistir al cliente
            manager1.persist(cliente1);

            //me limpia la conexion
            manager1.flush();

            //commit de nuestro persist
            manager1.getTransaction().commit();
        }
        catch (Exception e){
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