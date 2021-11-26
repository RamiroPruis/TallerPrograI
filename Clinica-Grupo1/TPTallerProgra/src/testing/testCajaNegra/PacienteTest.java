package testing.testCajaNegra;

import modelo.PacienteFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import personas.Nino;
import personas.Paciente;

import static org.junit.Assert.*;

public class PacienteTest {
    Paciente pacienteMayor;
    Paciente pacienteNino;
    Paciente pacienteJoven;

    @Before
    public void setUp() throws Exception {
        pacienteMayor = PacienteFactory.getPaciente("22345698","Ramiro","Pruis","Mar del Plata","2235982821","Jara 980", "Mayor");
        pacienteNino = PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Nino");
        pacienteJoven = PacienteFactory.getPaciente("22345698","Joaquin","Fioriti","Mar del Plata","2235982821","Jara 980", "Joven");
    }

    @After
    public void tearDown() throws Exception {

    }

    //El metodo verifica que hay un error en la ejecucion del metodo prioridad.
    //Testea que el Nino tiene prioridad sobre el mayor (cuando no deberia).
    @Test
    public void prioridadNinoSobreMayorIncorrectoTest() {
        assertTrue("El paciente mayor tiene prioridad sobre el Nino",pacienteNino.prioridad(pacienteMayor));
    }


    //Testea que el paciente Mayor tiene prioridad sobre el Joven. (Invalido)
    @Test
    public void prioridadMayorSobreJovenIncorrectoTest() {
        assertTrue("El paciente mayor tiene prioridad sobre el Joven",pacienteMayor.prioridad(pacienteJoven));
    }


    //Testea que el paciente Joven tiene prioridad sobre el Nino. (Invalido)
    @Test
    public void prioridadJovenSobreMayorIncorrectoTest() {
        assertTrue("El paciente Nino tiene prioridad sobre el Joven",pacienteJoven.prioridad(pacienteNino));
    }


}