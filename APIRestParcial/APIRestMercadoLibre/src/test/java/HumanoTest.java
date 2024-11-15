import org.example.Entidades.Humano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanoTest {
    private Humano humano;

    @BeforeEach
    void setUp() {
        humano = new Humano();
    }

    @Test
    void testEsMutante_CuandoHayMutacionVertical() {
        List<String> dnaMutante = Arrays.asList("AAAA", "CTGC", "TTTT", "ACGT");
        boolean resultado = humano.esMutante(dnaMutante);
        assertTrue(resultado, "Debería ser mutante por columna vertical");
    }

    @Test
    void testEsMutante_CuandoHayMutacionHorizontal() {
        List<String> dnaMutante = Arrays.asList("ATGC", "ATGC", "ATGC", "ATGC");
        boolean resultado = humano.esMutante(dnaMutante);
        assertTrue(resultado, "Debería ser mutante por fila horizontal");
    }

    @Test
    void testEsMutante_CuandoHayMutacionDiagonalIzquierdaADerecha() {
        List<String> dnaMutante = Arrays.asList("AGGCGA",
                "CAGTGC",
                "CCATGT",
                "CCAGTG",
                "CCCTTA",
                "TCTCTG");
        boolean resultado = humano.esMutante(dnaMutante);
        assertTrue(resultado, "Debería ser mutante por diagonal izquierda a derecha");
    }

    @Test
    void testEsMutante_CuandoHayMutacionDiagonalDerechaAIzquierda() {
        List<String> dnaMutante = Arrays.asList("ATGCGA",
                "CACTGC",
                "TCATGT",
                "CGAGTG",
                "CCCTTA",
                "TCTCTG");
        boolean resultado = humano.esMutante(dnaMutante);
        assertTrue(resultado, "Debería ser mutante por diagonal derecha a izquierda");
    }

    @Test
    void testEsMutante_CuandoNoHayMutaciones() {
        List<String> dnaNoMutante = Arrays.asList("ATGC", "CAGT", "TCTA", "AGGC");
        boolean resultado = humano.esMutante(dnaNoMutante);
        assertFalse(resultado, "No debería ser mutante");
    }

    @Test
    void testEsMutante_CuandoHayUnaMutacion() {
        List<String> dnaConUnaMutacion = Arrays.asList("ATGC", "CAGT", "TCTA", "AGGA");
        boolean resultado = humano.esMutante(dnaConUnaMutacion);
        assertFalse(resultado, "No debería ser mutante con solo una mutación");
    }
}
