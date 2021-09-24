import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import escenarios.EscenarioSistemaConProfesores;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.Profesor;
import modelo.Sistema;


class BuscarProfesorTest {

    EscenarioSistemaConProfesores escenario;

    @BeforeEach
    void setUp() throws Exception {
        escenario = new EscenarioSistemaConProfesores();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void BuscaProfesor() {
        Sistema sistema = escenario.getSistema();
        try {
            sistema.agregarProfesor(new Profesor("Tomas Perez","Perez 1234","tomasperez@gmail.com","4963214"));
            sistema.agregarProfesor(new Profesor("Tomas Garcia", "Garcia 1234", "tomasgarcia@gmail.com","4958632"));
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            //METODO YA TESTEADO
        }
        try {
            var profesores = sistema.buscarProfesor("Tomas");
            boolean cond = true;
            while(profesores.hasNext() && cond){
                cond = profesores.next().getApellidoNombre().toLowerCase().contains("tomas");
            }
            if (!cond)
                fail("Se encontraron profesores incorrectos" );
        } catch (NoEncontradoException e) {
            fail("Deberia encontrar al profesor");
        }
    }

    @Test
    void BuscaProfesorIncorrecto() {
        Sistema sistema = escenario.getSistema();
        try {
            sistema.buscarProfesor("");
            fail("No deberia encontrar un profesor");
        } catch (NoEncontradoException e) {
        }
    }

}