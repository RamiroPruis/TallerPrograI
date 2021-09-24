import static org.junit.Assert.*;

import escenarios.EscenarioSistemaConAlumnosCorrectos;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Sistema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EliminarAlumnoTest {
    private EscenarioSistemaConAlumnosCorrectos escenario;

    @BeforeEach
    void setUp() {
        escenario = new EscenarioSistemaConAlumnosCorrectos();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void EliminaAlumnoCorrecto() {
        Sistema sistema = escenario.getSistema();
        Alumno elim = new Alumno("Marianito", "Avenida432432", "marianito@gmail.com");
        try {
            sistema.agregarAlumno(elim); //inserto el alumno
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            //METODO TESTEADO CORRECTAMENTE
        }
        sistema.eliminarAlumno(elim);
        assertFalse("No deberia encontrarse el alumno en la coleccion",sistema.getAlumnos().contieneValor(elim));
    }
}
