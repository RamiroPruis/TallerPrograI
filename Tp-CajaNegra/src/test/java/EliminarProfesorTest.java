import static org.junit.Assert.*;

import escenarios.EscenarioSistemaConProfesores;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Profesor;
import modelo.Sistema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EliminarProfesorTest {
    private EscenarioSistemaConProfesores escenario;

    @BeforeEach
    void setUp() {
        escenario = new EscenarioSistemaConProfesores();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void EliminaProfesorCorrecto() {
        Sistema sistema = escenario.getSistema();
        Profesor elim = new Profesor("Cirimelo","avenida123","sandra@gmail.com","21312344");
        try {
            sistema.agregarProfesor(elim); //inserto el alumno
        } catch (ClaveYaExistenteException | DatoInvalidoException e) {
            //METODO TESTEADO CORRECTAMENTE
        }
        sistema.eliminarProfesor(elim);
        assertFalse("No deberia encontrarse el profesor en la coleccion",sistema.getProfesores().contieneValor(elim));
    }

}
