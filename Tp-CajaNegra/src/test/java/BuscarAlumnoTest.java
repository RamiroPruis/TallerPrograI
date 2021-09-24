import escenarios.EscenarioSistemaConAlumnosCorrectos;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class BuscarAlumnoTest {
    EscenarioSistemaConAlumnosCorrectos escenario;
    @BeforeEach
    void setUp() {
        escenario = new EscenarioSistemaConAlumnosCorrectos();
    }

    @Test
    void BuscaAlumnoCorrecto() {
        Sistema sistema = escenario.getSistema();
        try {
            sistema.agregarAlumno(new Alumno("Mariano closs","Catamarca 1234","clossoficial@gmail.com"));
            sistema.agregarAlumno(new Alumno("Mariano Garcia", "Avenida432432", "marianito@gmail.com"));
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
           //METODO YA TESTEADO
        }
        try {
            var marianos = sistema.buscarAlumno("mariano");
            boolean cond = true;
            while(marianos.hasNext() && cond){
                cond = marianos.next().getApellidoNombre().toLowerCase().contains("mariano");
            }
            if (!cond)
                fail("se encontraron alumnos incorrectos" );
        } catch (NoEncontradoException e) {
            fail("deberia encontrar al alumno");
        }
    }

    @Test
    void BuscaAlumnoIncorrecto() {
        Sistema sistema = escenario.getSistema();
        try {
            sistema.buscarAlumno("");
            fail("No deberia encontrar un alumno");
        } catch (NoEncontradoException e) {
        }
    }
}
