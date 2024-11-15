import org.example.Entidades.Estadistica;
import org.example.Entidades.Humano;
import org.example.Main;
import org.example.Repositorios.RepositorioEstadistica;
import org.example.Repositorios.RepositorioHumano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ContextConfiguration(classes = Main.class)
public class RepositorioEstadisticaTest {

    @Autowired
    private RepositorioEstadistica repositorioEstadistica;

    @Autowired
    private RepositorioHumano repositorioHumano;

    @BeforeEach
    public void setUp() {
        // Crea y guarda entidades de prueba en la base de datos en memoria
        Humano mutante1 = Humano.builder().esMutante(true).build();
        Humano mutante2 = Humano.builder().esMutante(true).build();
        Humano humano1 = Humano.builder().esMutante(false).build();

        repositorioHumano.save(mutante1);
        repositorioHumano.save(mutante2);
        repositorioHumano.save(humano1);

        Estadistica estadistica = Estadistica.builder()
                .cantidadMutantes(2)
                .cantidadHumanos(1)
                .ratio(2.0 / 3.0)
                .build();
        repositorioEstadistica.save(estadistica);
    }

    @Test
    public void testContarMutantes() {
        // Verifica que el método contarMutantes() devuelve la cantidad correcta
        long resultado = repositorioEstadistica.contarMutantes();
        assertEquals(2, resultado, "El número de mutantes debería ser 2");
    }

    @Test
    public void testContarHumanos() {
        // Verifica que el método contarHumanos() devuelve la cantidad correcta
        long resultado = repositorioEstadistica.contarHumanos();
        assertEquals(1, resultado, "El número de humanos debería ser 1");
    }
}