
import org.example.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Main.class)
public class MainTest {

    @Test
    void testMain() {

        Main.main(new String[]{});
        // Aquí podrías agregar verificaciones adicionales si tu lógica se separa en métodos que se pueden probar
    }
}
