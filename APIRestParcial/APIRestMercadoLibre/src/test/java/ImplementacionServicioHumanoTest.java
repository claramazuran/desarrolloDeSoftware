import jakarta.persistence.EntityNotFoundException;
import org.example.Entidades.EntidadBase;
import org.example.Main;
import org.example.Repositorios.RepositorioBase;
import org.example.Servicios.ImplementacionServicioBase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.example.Entidades.Humano;
import org.example.Entidades.Estadistica;
import org.example.Repositorios.RepositorioHumano;
import org.example.Repositorios.RepositorioEstadistica;
import org.example.Servicios.ImplementacionServicioHumano;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.io.Serializable;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class ImplementacionServicioHumanoTest {
    @Mock
    private RepositorioHumano repositorioHumano;

    @Mock
    private RepositorioBase<Humano, Long> repositorioHumano1;

    @Mock
    private RepositorioHumano repositorioBase;

    private ImplementacionServicioBase servicioBase;

    @Mock
    private RepositorioEstadistica repositorioEstadistica;

    @InjectMocks
    private ImplementacionServicioHumano servicioHumano;

    private Humano humano;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        servicioBase = Mockito.mock(ImplementacionServicioBase.class, Mockito.CALLS_REAL_METHODS);
        humano = Humano.builder().id(1L).build();
    }

    @Test
    public void testMutanteOno() {
        Humano humano = new Humano();
        humano.setDna(List.of("AAAAGTG", "CAGTGCC", "TGATATG", "GAATTGC", "CCCTTCG", "TGACTTG", "CACTACG"));

        when(repositorioHumano.save(humano)).thenReturn(humano);
        boolean esMutante = servicioHumano.mutanteOno(humano);

        assertTrue(esMutante);
    }

    @Test
    public void testObtenerEstadistica() {
        // Configura el comportamiento del mock
        when(repositorioEstadistica.contarHumanos()).thenReturn(100L);
        when(repositorioEstadistica.contarMutantes()).thenReturn(40L);

        // Llama al método que quieres probar
        Estadistica estadistica = servicioHumano.obtenerEstadistica();

        // Verifica los resultados
        assertEquals(100L, estadistica.getCantidadHumanos());
        assertEquals(40L, estadistica.getCantidadMutantes());
        assertEquals(0.4, estadistica.getRatio(), 0.001);

        // Verifica que los métodos del mock fueron llamados
        verify(repositorioEstadistica).contarHumanos();
        verify(repositorioEstadistica).contarMutantes();
        verify(repositorioEstadistica).save(estadistica);
    }

    @Test
    public void testObtenerEstadistica_NoDatos() {
        // Configura el comportamiento del mock
        when(repositorioEstadistica.contarHumanos()).thenReturn(0L);
        when(repositorioEstadistica.contarMutantes()).thenReturn(0L);

        // Llama al método
        Estadistica estadistica = servicioHumano.obtenerEstadistica();

        // Verifica que el ratio sea 0
        assertEquals(0L, estadistica.getCantidadHumanos());
        assertEquals(0L, estadistica.getCantidadMutantes());
        assertEquals(0.0, estadistica.getRatio(), 0.001);
    }

    @Test
    public void testSave() {
        Humano humano = new Humano();
        humano.setDna(List.of("AAAAGTG", "CAGTGCC", "TGATATG", "GAATTGC", "CCCTTCG", "TGACTTG", "CACTACG"));

        // Simula el comportamiento del repositorio
        when(repositorioHumano.save(humano)).thenReturn(humano);

        // Llama al método
        Humano savedHumano = servicioHumano.save(humano);

        // Verifica que el objeto guardado sea el correcto
        assertEquals(humano, savedHumano);
        verify(repositorioHumano).save(humano);
    }

    @Test
    public void testSave_DatabaseError() {
        when(repositorioHumano.save(humano)).thenThrow(new DataIntegrityViolationException("Error de base de datos"));

        assertThrows(DataIntegrityViolationException.class, () -> {
            servicioHumano.save(humano);
        });
    }

    @Test
    public void testMutanteOno_AdnConCaracteresInvalidos() {
        Humano humano = new Humano();
        humano.setDna(List.of("AT1G", "CG@o", "TGA$", "MLPN")); // ADN no válido con caracteres especiales

        boolean esMutante = servicioHumano.mutanteOno(humano);
        assertFalse(esMutante); // Se espera que no sea mutante
    }
    @Test
    public void testMutanteOno_NoMutante() {
        Humano humano = new Humano();
        humano.setDna(List.of("A"));

        // Llama al método
        boolean esMutante = servicioHumano.mutanteOno(humano);

        // Verifica que se considere no mutante
        assertTrue(!esMutante);
    }

    @Test
    public void testMutanteOno_DNAInvalido() {
        Humano humano = new Humano();
        humano.setDna(List.of("AT", "CG")); // ADN no válido

        boolean esMutante = servicioHumano.mutanteOno(humano);

        assertFalse(esMutante); // Se espera que no sea mutante
    }

    @Test
    public void testFindById_NotFound() {
        when(repositorioHumano.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            servicioHumano.findById(1L);
        });

        assertEquals("No value present", exception.getMessage());
    }

}
