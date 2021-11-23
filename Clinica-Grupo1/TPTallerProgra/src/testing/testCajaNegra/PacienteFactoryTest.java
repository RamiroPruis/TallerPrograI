package testing.testCajaNegra;

import excepciones.NoExisteRangoEtarioException;
import modelo.PacienteFactory;
import org.junit.*;
import static org.junit.Assert.*;
import personas.Paciente;

public class PacienteFactoryTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getPacienteCorrectoJoven() {
        try {
            Paciente pacientePrueba = PacienteFactory.getPaciente("123","nombre","apellido","ciudad","123","domicilio","Joven");
            assertNotNull(pacientePrueba);
        } catch (NoExisteRangoEtarioException e) {
            fail("No deberia entrar aca porque tiene bien definido el rango etario");
        }

    }

    @Test
    public void getPacienteCorrectoNino() {
        try {
            Paciente pacientePrueba = PacienteFactory.getPaciente("123","nombre","apellido","ciudad","123","domicilio","Nino");
            assertNotNull(pacientePrueba);
        } catch (NoExisteRangoEtarioException e) {
            fail("No deberia entrar aca porque tiene bien definido el rango etario");
        }

    }

    @Test
    public void getPacienteCorrectoMayor() {
        try {
            Paciente pacientePrueba = PacienteFactory.getPaciente("123","nombre","apellido","ciudad","123","domicilio","Mayor");
            assertNotNull(pacientePrueba);
        } catch (NoExisteRangoEtarioException e) {
            fail("No deberia entrar aca porque tiene bien definido el rango etario");
        }

    }

    @Test
    public void getPacienteIncorrecto() {
        try {
            Paciente pacientePrueba = PacienteFactory.getPaciente("123","nombre","apellido","ciudad","123","domicilio","asd");
            fail("Deberia tirar excepcion porque el rango etario esta mal definido");
        } catch (NoExisteRangoEtarioException e) {

        }

    }

}